/*Student Report Generator
Scenario: You need to generate a report card for students based on subject-wise marks.
Problem Requirements:
● Store subjects and marks using arrays.
● Use a List to store multiple student records.
● Use methods for calculating average, grade assignment, and displaying result.
● Validate marks (should be 0–100), else throw InvalidMarkException.
● Format output strings to show a clean report card.*/

package classandobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReportGenerator {

    //calculate average marks
    static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    //assign grade based on average
    static String assignGrade(double average) {
        if (average >= 90) {
        	return "A+";
        }else if (average >= 80) {
        	return "A";
        }else if (average >= 70) {
        	return "B";
        }else if (average >= 60) {
        	return "C";
        }
        else {
        	return "F";
        }
    }

    //display report card
    static void displayReport(String name, String[] subjects, int[] marks) {
        System.out.println("\n------------------------------");
        System.out.println("Report Card for: " + name);
        System.out.println("------------------------------");
        System.out.printf("%-15s %s\n", "Subject", "Marks");
        System.out.println("------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-15s %d\n", subjects[i], marks[i]);
        }
        double avg = calculateAverage(marks);
        System.out.println("------------------------------");
        System.out.printf("%-15s %.2f\n", "Average", avg);
        System.out.printf("%-15s %s\n", "Grade", assignGrade(avg));
        System.out.println("------------------------------\n");
    }

    //validate marks
    static void validateMarks(int[] marks) throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid mark detected: " + mark + ". Must be between 0 and 100.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();
        input.nextLine(); // consume newline

        System.out.print("Enter number of subjects: ");
        int numSubjects = input.nextInt();
        input.nextLine(); // consume newline

        String[] subjects = new String[numSubjects];
        System.out.println("Enter subject names:");
        for (int i = 0; i < numSubjects; i++) {
            subjects[i] = input.nextLine();
        }

        for (int s = 1; s <= numStudents; s++) {
            System.out.println("\n--- Enter details for Student " + s + " ---");
            System.out.print("Enter student name: ");
            String name = input.nextLine();

            int[] marks = new int[numSubjects];
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for " + subjects[i] + ": ");
                marks[i] = input.nextInt();
            }
            input.nextLine(); // consume newline

            try {
                validateMarks(marks);
                students.add(new Student(name, subjects, marks));
            } catch (InvalidMarkException e) {
                System.out.println("Error: " + e.getMessage());
                s--; // repeat current student
            }
        }

        //display all report cards
        for (Student student : students) {
            displayReport(student.name, student.subjects, student.marks);
        }

        input.close();
    }
}


//custom exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

//student class
class Student {
    String name;
    String[] subjects;
    int[] marks;

    public Student(String name, String[] subjects, int[] marks) {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }
}
