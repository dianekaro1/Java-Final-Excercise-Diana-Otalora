package Functional;

public  class Teacher extends Person
{
	private float salaryBase;
	private int courseAssigned;
	private int experienceYears;
	private boolean isFullTime;
	private int workingHours;
	static final String FULL_TIME_TYPE = "Full time";
	static final String PART_TIME_TYPE = "Part time";
	
	public void setWorkingHours(int workingHours)
	{
		this.workingHours = workingHours;
	}
	
	public float getSalaryCalculated() 
	{
		float salary;
		
		if (isFullTime)
		{
			salary = salaryBase * ((110/100) * experienceYears);
		}
		else
		{
			salary = salaryBase * workingHours;
		}
		return salary;
	}

	public void setCourseAssigned(int courseAssigned)
	{
		this.courseAssigned = courseAssigned;
	}
	
	public float getSalaryBase() {
		return salaryBase;
	}

	public int getCourseAssigned() {
		return courseAssigned;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public String getJobType()
	{
		if (isFullTime)
		{
			return FULL_TIME_TYPE;
		}
		else
		{
			return PART_TIME_TYPE;
		}
	}

		
	public Teacher(int id, String name, float salaryBase, int courseAssigned, int experienceYears,
			boolean isFullTime)
	{
		super(id, name);
		this.salaryBase = salaryBase;
		this.courseAssigned = courseAssigned;
		this.experienceYears = experienceYears;
		this.isFullTime = isFullTime;
	}	
}