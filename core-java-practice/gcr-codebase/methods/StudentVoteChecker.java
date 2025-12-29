/*Write a program to take user input for the age of all 10 students in a class and check whether
 the student can vote depending on his/her age is greater or equal to 18. */
 
import java.util.Scanner;

public class StudentVoteChecker {

    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false; 
        } else if (age >= 18) {
            return true; 
        } else {
            return false; 
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] ages = new int[10]; 

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        System.out.println("\nVoting Eligibility:");
        for (int i = 0; i < 10; i++) {
            if (checker.canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " (age " + ages[i] + ") can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " (age " + ages[i] + ") cannot vote.");
            }
        }
        input.close();
    }
}
