/*Scenario: Develop a program to manage student test scores. The program should:
 ● Store the scores of n students in an array.
 ● Calculate and display the average score.
 ● Find and display the highest and lowest scores.
 ● Identify and display the scores above the average.
 ● Handle invalid input like negative scores or non-numeric input.*/

package classandobject;

import java.util.Scanner;

public class StudentScoreAnalyzer {

    //calculate average
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) sum += score;
        return (double) sum / scores.length;
    }

    //find highest score
    public static int findHighest(int[] scores) {
        int highest = scores[0];
        for (int score : scores) if (score > highest) highest = score;
        return highest;
    }

    // find lowest score
    public static int findLowest(int[] scores) {
        int lowest = scores[0];
        for (int score : scores) if (score < lowest) lowest = score;
        return lowest;
    }

    //print scores above average
    public static void printAboveAverage(int[] scores, double average) {
        boolean found = false;
        for (int score : scores) {
            if (score > average) {
                System.out.print(score + " ");
                found = true;
            }
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    //get valid number of students
    public static int getValidNumberOfStudents(Scanner input) {
        int n;
        while (true) {
            System.out.print("Enter number of students: ");
            if (input.hasNextInt()) {
                n = input.nextInt();
                if (n > 0) break;
                else System.out.println("Number of students must be positive.");
            } else {
                System.out.println("Invalid input! Enter a positive integer.");
                input.next(); // discard invalid input
            }
        }
        return n;
    }

    //get valid student score
    public static int getValidScore(Scanner input, int studentNumber) {
        int score;
        while (true) {
            System.out.print("Enter score for student " + studentNumber + ": ");
            if (input.hasNextInt()) {
                score = input.nextInt();
                if (score >= 0) break;
                else System.out.println("Score cannot be negative.");
            } else {
                System.out.println("Invalid input! Enter a non-negative integer.");
                input.next(); // discard invalid input
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get number of students with validation
        int n = getValidNumberOfStudents(input);

        int[] scores = new int[n];

        // Get each student's score with validation
        for (int i = 0; i < n; i++) {
            scores[i] = getValidScore(input, i + 1);
        }

        double average = calculateAverage(scores);
        int highest = findHighest(scores);
        int lowest = findLowest(scores);

        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.print("Scores above average: ");
        printAboveAverage(scores, average);
        
        input.close();
    }
}
