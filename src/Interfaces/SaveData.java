package Interfaces;

import Functional.Course;
import Functional.Student;
import Functional.Teacher;

public interface SaveData 
{
	
	public void saveTeacher(int id, Teacher teacher);
	public void saveCourse(int id, Course course);
	public void saveStudent(int id, Student student);

}
