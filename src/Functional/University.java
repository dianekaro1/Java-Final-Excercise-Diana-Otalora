package Functional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Interfaces.SaveData;

public class University implements SaveData
{	
		private HashMap<Integer, Teacher> teachers= new HashMap<Integer, Teacher>();
		private HashMap<Integer, Student> students= new HashMap<Integer, Student>();
		private HashMap<Integer, Course> courses= new HashMap<Integer, Course>();
		
		@Override
		public void saveTeacher(int id, Teacher teacher)
		{
 	       teachers.put(id, teacher);            			
		}
		
		@Override
		public void saveCourse(int id, Course course)
		{
			courses.put(id, course);
		
		}
		
		@Override
		public void saveStudent(int id, Student student)
		{
			students.put(id, student);
		}
		
		public University() {
			
		}

		public HashMap<Integer, Teacher> getTeachers() {
			return teachers;
		}

		public HashMap<Integer, Student> getStudents() {
			return students;
		}

		public HashMap<Integer, Course> getCourses() {
			return courses;
		}
		
		public Teacher getTeacherByCourseAssigned(int courseId)
		{
			for(Teacher teacher : teachers.values())
			{
				if (courseId == teacher.getCourseAssigned()) 
				{
					return teacher;
				}				
			}
			return null;
		}
		
		public ArrayList<Student> getStudentByCourseAssigned(int courseId)
		{
			ArrayList<Student> studentList = new ArrayList<Student>();
			
			for(Student student : students.values())
			{
				if (student.getCoursesAssigned().contains(courseId))
				{
					studentList.add(student);
				}				
			}
			return studentList;
		}
		
		public ArrayList<String> getCoursesByStudentId(int studentId)
		{
			ArrayList<String> coursesName = new ArrayList <String>();  
			Student student = getStudentbyID(studentId);
			
			for (int courseid: student.getCoursesAssigned())
			{
				Course course = getCourseById(courseid);
				coursesName.add(course.getNameCourse());
			}
			return coursesName;
		}
		
		public Course getCourseById(int courseId)
		{
			return courses.get(courseId);
			
		}
		
		public Student getStudentbyID(int studentId)
		{
			return students.get(studentId);
		}
		
		public Teacher getTeacherbyId(int teacherId)
		{
			return teachers.get(teacherId);
		}
		
		public void saveWorkingTeacherHours()
		{
			for (Course course: courses.values())
			{
				Teacher teacherCourseAssigned = getTeacherByCourseAssigned(course.getIdCourse());
				teacherCourseAssigned.setWorkingHours(course.getTimeCourseHour());
			}
					
		}
	}
