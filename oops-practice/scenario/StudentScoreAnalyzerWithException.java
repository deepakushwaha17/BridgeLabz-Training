/*Student Score Analyzer
Focus: Arrays, Methods, Exception Handling.
Scenario:
You're building a tool for teachers to analyze scores from a recent Math exam.
Requirements:
Accept array of student scores as input (int[])

Compute:
- Average score
- Highest & lowest scores
If any score is below 0 or above 100, throw InvalidScoreException
Use methods like calculateAverage(), findMax(), findMin().*/

package classandobject;

import java.util.Scanner;

public class StudentScoreAnalyzerWithException {

    //calculate average score
    static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    //find maximum score
    static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) max = score;
        }
        return max;
    }

    //find minimum score
    static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) min = score;
        }
        return min;
    }

    //validate scores
    static void validateScores(int[] scores) throws InvalidScoreException {
        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException("Invalid score detected: " + score + ". Score must be between 0 and 100.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores for " + n + " students:");
        for (int i = 0; i < n; i++) {
            scores[i] = input.nextInt();
        }

        try {
            validateScores(scores);

            System.out.println("\nAnalysis of Student Scores:");
            System.out.println("Average Score: " + calculateAverage(scores));
            System.out.println("Highest Score: " + findMax(scores));
            System.out.println("Lowest Score: " + findMin(scores));

        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}


//custom exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}
