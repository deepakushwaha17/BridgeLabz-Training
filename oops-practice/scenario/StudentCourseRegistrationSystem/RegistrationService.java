package StudentCourseRegistrationSystem;

public interface RegistrationService {

	void enroll(Course course)throws CourseLimitExceededException;
	void drop(Course course);
}
