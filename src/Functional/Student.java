package Functional;

import java.util.ArrayList;

public  class Student extends Person 
{
	private int age;
	private ArrayList<Integer> coursesAssigned = new ArrayList<Integer>();

	
	public int getAge() 
	{
		return age;
	}

	public ArrayList<Integer> getCoursesAssigned() {
		return coursesAssigned;
	}
	
	public Student(int id, String name, ArrayList<Integer> coursesAssigned, int age)
	{
		super(id, name);
		this.age = age;
		this.coursesAssigned = coursesAssigned;
	}
	public void addCourseAssigned (int courseId)
	{
	 coursesAssigned.add(courseId);
	}
}