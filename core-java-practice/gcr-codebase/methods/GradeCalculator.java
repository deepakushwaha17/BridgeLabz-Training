/*Create a program to take input marks of students in 3 subjects: physics, chemistry, and maths. 
Compute the total, average, and the percentage score*/

import java.util.Scanner;

public class GradeCalculator { 

    // Generate random 2-digit PCM scores
    public static int[][] generatePCMScores(int n) {

        int[][] scores = new int[n][3];

        for (int i = 0; i < n; i++) {
            scores[i][0] = 10 + (int)(Math.random() * 90); // Physics
            scores[i][1] = 10 + (int)(Math.random() * 90); // Chemistry
            scores[i][2] = 10 + (int)(Math.random() * 90); // Maths
        }
        return scores;
    }

    // Calculate total, average and percentage
    public static double[][] calculateResults(int[][] scores) {

        int n = scores.length;
        double[][] result = new double[n][3];

        for (int i = 0; i < n; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 digits
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // Display scorecard in tabular format
    public static int displayScorecard(int[][] scores, double[][] result) {

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPercetage\t");

        for (int i = 0; i < scores.length; i++) {
            System.out.println( (i + 1) + "\t" +  scores[i][0] + "\t" +  scores[i][1] + "\t" + 
            scores[i][2] + "\t" +  result[i][0] + "\t" +  result[i][1] + "\t" + result[i][2]);
        }
        return 1;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[][] pcmScores = generatePCMScores(n);
        double[][] results = calculateResults(pcmScores);

        displayScorecard(pcmScores, results);
    }
}