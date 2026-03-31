package StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person implements RegistrationService{

	ArrayList<Course> courses = new ArrayList<>();
    private HashMap<Course, String> grades = new HashMap<>();
    int maxCourses = 5;

	public Student(int id ,String name) {
		super(id,name);
		
	}
	@Override
    public void enroll(Course course) throws CourseLimitExceededException {
        if(courses.size() >= maxCourses){
            throw new CourseLimitExceededException("Cannot enroll more than " + maxCourses + " courses.");
        }
        if(course.enrollStudent()){
            courses.add(course);
            grades.put(course, "N/A");
            System.out.println("Enrolled in " + course.getCourseName());
        } else {
            System.out.println("Course full: " + course.getCourseName());
        }
    }

    @Override
    public void drop(Course course){
        if(courses.remove(course)){
            course.dropStudent();
            grades.remove(course);
            System.out.println("Dropped " + course.getCourseName());
        } else {
            System.out.println("You are not enrolled in " + course.getCourseName());
        }
    }

    public void viewGrades(){
        System.out.println("Grades for " + getPersonName()+ ":");
        for(Course c : courses){
            System.out.println(c.getCourseName() + " : " + grades.get(c));
        }
    }

    public void assignGrade(Course course, String grade) {
        if (grades.containsKey(course)) {
            grades.put(course, grade);
            System.out.println("Grade assigned successfully");
        } else {
            System.out.println("Student not enrolled in this course");
        }
    }


}
