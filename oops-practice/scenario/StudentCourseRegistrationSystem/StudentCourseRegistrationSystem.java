package StudentCourseRegistrationSystem;

import java.util.Scanner;

public class StudentCourseRegistrationSystem {

    static Scanner input = new Scanner(System.in);

    private static Course[] courses = {new Course(101, "MCA", 2),new Course(102, "BCA", 2),
        new Course(103, "BTech", 4) , new Course(104, "BPharma", 2)};

    private static Student student = new Student(1, "Amit");

    public static void main(String[] args){
        int choice;
        do {
            System.out.println("\n----- Student Course Registration -----");
            System.out.println("1. View Courses");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. View Grades");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch(choice){
                case 1: 
                	displayCourses(); 
                	break;
                case 2: 
                	enrollCourse(); 
                	break;
                case 3: 
                	dropCourse(); 
                	break;
                case 4: 
                	assignGradeToStudent();
                	break;
                case 5: 
                    student.viewGrades();
                    break;
                case 6: 
                	System.out.println("Exiting...."); 
                	System.exit(0);
                default: 
                	System.out.println("Invalid choice");
            }

        } while(choice != 0);
    }

    public static void displayCourses(){
        System.out.println("\nAvailable Courses:");
        for(Course c : courses){
            System.out.println(c.getCourseId() + " | " + c.getCourseName());
        }
    }

    public static void enrollCourse(){
        System.out.print("Enter Course ID to enroll: ");
        int id = input.nextInt();
        for(Course c : courses){
            if(c.getCourseId() == id){
                try {
                    student.enroll(c);
                } catch(CourseLimitExceededException e){
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Course not found");
    }

    public static void dropCourse(){
        System.out.print("Enter Course ID to drop: ");
        int id = input.nextInt();
        for(Course c : courses){
            if(c.getCourseId() == id){
                student.drop(c);
                return;
            }
        }
        System.out.println("Course not found");
    }
    
    public static void assignGradeToStudent() {
        System.out.print("Enter Course ID: ");
        int courseId = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter Grade (A/B/C/D/F): ");
        String grade = input.nextLine().toUpperCase();

        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                student.assignGrade(c, grade);
                return;
            }
        }
        System.out.println("Course not found");
    }

}
