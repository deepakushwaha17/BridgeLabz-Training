package generics.CourseManagementSystem;

// Generic class Course
public class Course <T extends CourseType>{

	private String courseName;
	private String department;
	private int duration;
	private T courseType;
	
	public Course(String courseName, String department, int duration, T courseType) {
		this.courseName = courseName;
		this.department = department;
		this.duration = duration;
		this.courseType = courseType;
	}

	public String getCourseName() {
		return courseName;
	}
	
	public String getDepartment() {
		return department;
	}

	public int getDuration() {
		return duration;
	}
	
	public T getType() {
		return courseType;
	}
	
	public String getCourseDetails() {
		return "Course Name: " + courseName + ", Department: " + department + 
				", Duration: " + duration + ", Course Type: " + courseType.getCourseType();
	}
	
}
