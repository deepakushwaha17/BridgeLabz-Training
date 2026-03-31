package classandobject;

public class OnlineCourse {

	public static void main(String[] args) {
		Course c1 = new Course("Java Programming", 6, 15000);
        Course c2 = new Course("Python Development", 4, 12000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("Tech Academy");

        System.out.println("\nAfter updating institute name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();

	}

}

class Course {

    // Instance variables
    String courseName;
    int duration; // in months
    double fee;

    // Class variable 
    static String instituteName = "GLA University";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months" +
            ", Fee: ₹" + fee + ", Institute: " + instituteName);
    }

    // Class method to update institute name
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}
