package generics.CourseManagementSystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CourseManagement {

	static Scanner input = new Scanner(System.in);
	
	static List<Course<?>> courses = new ArrayList<>();
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("\n--- University Course Management System ---");
            System.out.println("1. Add Course");
            System.out.println("2. Display All Courses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch(choice) {
            	case 1:
            		addCourse();
            		break;
            		
            	case 2:
            		System.out.println("\n-------- Courses List --------");
            		if(courses.isEmpty()) {
            			System.out.println("No course is added in list.");
            		}
            		else{
	            		for(Course<?> c : courses) {
	            			System.out.println(c.getCourseDetails());
	            		}
            		}
            		System.out.println("--------------------------------");
                    break;
                    
            	case 3:
            		System.out.println("Exiting University...");
                    input.close();
                    return;
                    
            	default:
                    System.out.println("Invalid choice!");
            }
		}
	}
	// Method to add course
	public static void addCourse() {
		System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();
        System.out.print("Enter Department: ");
        String department = input.nextLine();
        System.out.print("Enter Duration: ");
        int duration = input.nextInt();
        
        System.out.println("\n  --- Select Course Type ---");
        System.out.println("  1. Exam Course");
        System.out.println("  2. Assignment Course");
        System.out.println("  3. Research Course");
        System.out.print("Enter your choice: ");

        int choice = input.nextInt();
        input.nextLine(); // consume newline
        
        switch(choice) {
        	case 1 : 
        		courses.add(new Course<>(courseName, department, duration, new ExamCourse()));
        		System.out.println("Exam Course added.");
        		break;
        	case 2 : 
        		courses.add(new Course<>(courseName, department, duration, new AssignmentCourse()));
        		System.out.println("Assignment Course added.");
        		break;
        	case 3 : 
        		courses.add(new Course<>(courseName, department, duration, new ResearchCourse()));
        		System.out.println("Research Course added.");
        		break;
        	default : 
        		System.out.println("Invalid Type!");
        }
	}
}


