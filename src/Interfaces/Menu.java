package Interfaces;

import java.util.Collection;
import java.util.HashMap;
import Functional.Course;
import Functional.MenuOptions;
import Functional.Teacher;
import Functional.University;

public interface Menu
{
	 public MenuOptions showMenu();
	 
	 public void menuOption1(Collection<Teacher> teachers);
	 public void menuOption2(University university);
	 public void menuOption3(University university);
	 public void menuOption4(University university);
	 public void menuOption5(University university);
	 
}
