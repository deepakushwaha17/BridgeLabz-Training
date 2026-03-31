package StudentCourseRegistrationSystem;

public class Course {
	private int courseId;
	private String courseName;
	private int maxStudents;
	private int enrolled = 0;

	public Course(int courseId , String courseName , int maxStudents) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.maxStudents = maxStudents;
	}

	public int getCourseId() {
		return courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public boolean enrollStudent() {
		if(enrolled < maxStudents) {
			enrolled++;
			return true;
		}
		return false;	
	}

	public void dropStudent() {
		enrolled--;
	}
}
