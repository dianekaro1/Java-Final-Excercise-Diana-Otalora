package Functional;

import java.util.Collection;

public  class Course
{
	private int idCourse;
	private String nameCourse;
	private int classroomAssigned;
	private int timeCourseHour;
	
	public int getIdCourse() {
		return idCourse;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public int getClassroomAssigned() {
		return classroomAssigned;
	}

	public int getTimeCourseHour() {
		return timeCourseHour;
	}


	public Course(int idCourse, String nameCourse, int classroomAssigned, int timeCourseHour) 
	{
		this.idCourse = idCourse;
		this.nameCourse = nameCourse;
		this.classroomAssigned = classroomAssigned;
		this.timeCourseHour = timeCourseHour;
	}
	
	
}
