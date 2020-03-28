package Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import Functional.University;
import Interfaces.Menu;
import Interfaces.SaveData;
import Functional.Course;
import Functional.MenuOptions;
import Functional.Student;
import Functional.Teacher;

public class Main implements Menu
{
	private static final Object Yes = null;
	private static final ArrayList<Integer> NO = null;
	private Scanner teclado = new Scanner(System.in);
	static final String ANSWER_YES = "yes";
	static final String ANSWER_NO = "no";

	
    public static void main(String[ ] args)
    {
    	
    	University university = new University();
    	Main main = new Main();
    	
    	
    	initializeTeachers(university);
    	initializeStudents(university);
    	initializeCourses(university);
    	
		MenuOptions selectedOption;

    	do 
    	{
    		selectedOption = main.showMenu(); 
    		if(selectedOption != null)
    		{
    			switch(selectedOption)
    			{
    			case OPTION_1:
    				university.saveWorkingTeacherHours();
    				main.menuOption1(university.getTeachers().values());
    				break;
    			case OPTION_2: main.menuOption2(university);
    				break;
    			case OPTION_3: main.menuOption3(university);
    				break;
    			case OPTION_4: main.menuOption4(university);
    				break;
    			case OPTION_5: main.menuOption5(university);
    				break;
    			}
    			
    		}
    		else
    		{
    			System.out.println("**********Invalid Option***********\n\n");
    		}
    	}
    	while (selectedOption != MenuOptions.OPTION_6);
    	System.out.print(" Good bye");
    	return;
    	}
		
	public static void initializeTeachers(SaveData saveData)
   {
	   
		saveData.saveTeacher(3333, new Teacher(3333, "Juan Garcia", 3434300, 1 , 3, true));
		saveData.saveTeacher(4444, new Teacher(4444, "Mario Duarte", 200000, 2 , 3, true));
		saveData.saveTeacher(5555, new Teacher(5555, "Juana de Arco", 490000, 3 , 3, false));
		saveData.saveTeacher(6666, new Teacher(6666, "Jimena Fernandez",290000, 4 , 3, false));
   }
   
   public static void initializeStudents (SaveData saveData)
   {
		saveData.saveStudent(123, new Student(123, "Karen Martinez", new ArrayList<Integer>(List.of(1,2,3,4)), 23));
		saveData.saveStudent(234, new Student(234, "Kira Nene", new ArrayList<Integer>(List.of(2,4)), 22));
		saveData.saveStudent(345, new Student(345, "Alejandro Lopez", new ArrayList<Integer>(List.of(2,3)), 21));
		saveData.saveStudent(456, new Student(456, "Luciana Castro", new ArrayList<Integer>(List.of(2,3,4)), 20));
		saveData.saveStudent(567, new Student(567, "Francisco Sartre", new ArrayList<Integer>(List.of(1,2)), 26));
		saveData.saveStudent(678,  new Student(678, "Sofia Aristizabal", new ArrayList<Integer>(List.of(2)), 30));
   }
   
   private static  void initializeCourses(SaveData saveData)
	{
	   	   
	   for (int i=1; i<=4; i++)
		{ 
		  switch(i)
		  {
           case 1:
        	   saveData.saveCourse(i, new Course(i, "Mate", 101, 13)); 
           	break;
           case 2:
        	   saveData.saveCourse(i, new Course(i, "Logic", 102, 12));
        	 break;
           case 3:
        	   saveData.saveCourse(i, new Course(i, "Fisica", 103, 15));
           	break;
           case 4:
        	   saveData.saveCourse(i, new Course(i, "Quimica", 103, 15));
           	break;
           
         }
		}
	}

	@Override
	public  MenuOptions showMenu()
	{
		System.out.println( "****Universidad " + "DCOA " +"******\n");
		
		for (int i=1; i<=6; i++)
		{ 
		  switch(i) 
		  {
	        case 1:
	        	System.out.println(i + "." + " " + "Print all the professors with its data");           
	        	break;
	        case 2:
	        	System.out.println(i + "." + " " + "Print all the classes");
	        	break;
	        case 3:
	        	System.out.println(i + "." + " " +  "Create a new student and add it to an existing class");
	        	break;
	        case 4:
	        	System.out.println(i + "." +  " " + "Create a new class and add a teacher, students and its relevant data");
	        	break;
	        case 5:
	        	System.out.println(i + "." +  " " + "List all the classes in which a given student is included");
	        	break;
	        case 6:
	        	System.out.println(i + "." + " " + "Exit");
	        	break;
	      }
		}
		
    		System.out.print("Choose the option you want to use \n");
    		return getMenuOption(teclado.nextInt());

	} 
	
	private static MenuOptions getMenuOption(int option)
	{
		 
		switch(option)
		{
		case 1: return MenuOptions.OPTION_1;
		case 2: return MenuOptions.OPTION_2;
		case 3: return MenuOptions.OPTION_3;
		case 4: return MenuOptions.OPTION_4;
		case 5: return MenuOptions.OPTION_5;
		case 6: return MenuOptions.OPTION_6;
		default: return null;
		}
	}

	@Override
	public void menuOption1(Collection<Teacher> teachers) 
	{
		for (Teacher teacher: teachers)
		{
			System.out.println("ID: " + teacher.getId() + "\n");
			System.out.println("Name: " + teacher.getName() + "\n");
			System.out.println("Class: " + teacher.getCourseAssigned() + "\n");
			System.out.println("Experice Years: " + teacher.getExperienceYears() + "\n");
			System.out.println("Salary: " + teacher.getSalaryCalculated() + "\n");
			System.out.println("Job type: " + teacher.getJobType() + "\n");
		}
					
	}

	@Override
	public void menuOption2(University university)
	{
		
		for(Course course: university.getCourses().values())
		{
			System.out.println(course.getIdCourse() + ": " + course.getNameCourse() + "\n");
		}
		System.out.println(" Select the code class you want more information:" + "\n");
		
		int selectedCourse = teclado.nextInt();

		if(university.getCourses().containsKey(selectedCourse))
		{
			do 
			{
				int optionSelected = showSubMenu();
				switch (optionSelected)
				{
					case 1: 
						Teacher teacher = university.getTeacherByCourseAssigned(selectedCourse);
						Collection collection = new ArrayList<Teacher>();
						collection.add(teacher);
						menuOption1(collection);
						break;
					case 2:
						printStudents(university.getStudentByCourseAssigned(selectedCourse));
						
					break;
					case 3: 
						Course course = university.getCourseById(selectedCourse);
						System.out.println("Classrom: " + course.getClassroomAssigned()+ "\n");
						System.out.println("Time: " + course.getTimeCourseHour() +"\n");	
						break;
				}
				
				
			}
			while (showSubMenu() != 4);
			

		}
		else
		{
			System.out.println("The select class doesn't found "+ "\n");
		}
			
	}
	
	private int showSubMenu ()
	{
		
		System.out.println("1. Show Teacher Assigned \n");
		System.out.println("2. Show Studens Assigned \n");
		System.out.println("3. Show more Information \n");
		System.out.println("4. Back \n");
		System.out.println("Select the option: \n");
		return teclado.nextInt();
	
	}

	private void printStudents(ArrayList<Student> students)
	{
		for(Student student: students)
		{
			System.out.println("Name: " + student.getName() +"\n");
		}
	}
	
	
	
	@Override
	public void menuOption3(University university) 
	{
		int id = 0;
		String name = "";
		String optionn = "";
		HashSet<Integer> coursesAssigned = new HashSet<Integer>();
		int age = 0;
		String option;
		
		
		System.out.println("Enter the general Student Information"+ "\n");
		System.out.println("Enter the Student ID"+ "\n");
		id = teclado.nextInt();
		if (university.getStudentbyID(id) != null)
		{
			System.out.println("Student ID already exists"+ "\n");
			return;
		}
		System.out.println("Enter Student Name"+ "\n");
		name = teclado.next();
		System.out.println("Enter Student Age"+ "\n");
		age = teclado.nextInt();
		validateCourse (coursesAssigned, university);
		
		do
		{
			System.out.println("Would you like enter the student to other class?"+ "\n");
			option = teclado.next();
			if(option.equalsIgnoreCase(ANSWER_YES))
		    {
				validateCourse (coursesAssigned, university);
			}
		}
		while(!option.equalsIgnoreCase(ANSWER_NO));
		
		if ((id != 0) && (name != "") && (age != 0))
		{
			university.saveStudent(id, new Student(id, name, new ArrayList<Integer>(coursesAssigned), age));
			System.out.println("Student saved correctly "+ "\n");

		}
		else 
		{
			System.out.println("Invalid data "+ "\n");
		}
	}
	
	private void validateCourse(HashSet<Integer> coursesAssigned, University university)
	{
		int course;
		
		System.out.println("Enter the Class from Student"+ "\n");
		course = teclado.nextInt();
		
		if(university.getCourseById(course) != null)
		{
			coursesAssigned.add(course);
		}
		else
		{
			System.out.println("Class doesn't exist"+ "\n");

		}
	}
		

	@Override
	public void menuOption4(University university)
	{
		int saveIdCourse = 0;
		String saveNameCourse = "";
		int saveClassRoomAssigned = 0;
		int saveTimeCourseHour= 0;
		int idTeacher = 0;
		int idStudent = 0;
		
		System.out.println("Enter Id Course"+ "\n");
		saveIdCourse = teclado.nextInt();
		
		if (university.getCourseById(saveIdCourse) != null)
		{
			System.out.println("Course ID already exists"+ "\n");
			return;
		}
		
		System.out.println("Enter Course Name"+ "\n");
		saveNameCourse = teclado.next();
		System.out.println("Enter the Classroom number"+ "\n");
		saveClassRoomAssigned = teclado.nextInt();
		System.out.println("Enter course hour"+ "\n");
		saveTimeCourseHour = teclado.nextInt();
				
		System.out.println("Enter the teacher id"+ "\n");
		idTeacher = teclado.nextInt();
		Teacher teacher = university.getTeacherbyId(idTeacher);
		
		if (teacher != null)
		{
			teacher.setCourseAssigned(saveIdCourse);	
		}
		else 
		{
			System.out.println("Teacher ID Doesn't exists"+ "\n");
		}
		
		System.out.println("Enter Student ID"+ "\n");
		idStudent = teclado.nextInt();
		Student student = university.getStudentbyID(idStudent);

		
		if (student != null)
		{
			student.addCourseAssigned(saveIdCourse);
		}
		else 
		{
			System.out.println("Student ID Doesn't exists"+ "\n");
		}
		
		if ((saveIdCourse != 0) && (saveNameCourse != "") && (saveClassRoomAssigned != 0) && (saveTimeCourseHour != 0))
		{
			university.saveCourse(saveIdCourse, new Course(saveIdCourse, saveNameCourse, saveClassRoomAssigned, saveTimeCourseHour));
			System.out.println("Course saved correctly "+ "\n");

		}
		else 
		{
			System.out.println("Invalid data "+ "\n");
		}
}

	@Override
	public void menuOption5(University university)
		{
		int studentId;
		
		System.out.println(" List of all Courses"+ "\n");
		System.out.println(" Enter the Student ID to show Courses Assigned"+ "\n");
		studentId= teclado.nextInt();	
		if (university.getStudentbyID(studentId) != null )
		{
			ArrayList<String> courseslist = university.getCoursesByStudentId(studentId);
			System.out.println(courseslist + "\n");			

		}
		else 
		{
		System.out.println(" Student ID doesn't Exist"+ "\n");
		}

	}
   
}