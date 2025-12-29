//Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade

import java.util.Scanner;
import java.util.Random;

public class StudentScoreCalculation {

    public static int[][] generatePCMScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3]; // P, C, M

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(90) + 10; // 10–99
            }
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        int students = scores.length;
        double[][] results = new double[students][3]; // total, average, percentage

        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return results;
    }

    public static String[][] calculateGrades(double[][] results) {
        int students = results.length;
        String[][] grades = new String[students][1];

        for (int i = 0; i < students; i++) {
            double percent = results[i][2];

            if (percent >= 80){
                grades[i][0] = "A";
			} else if (percent >= 70){
                grades[i][0] = "B";
            } else if (percent >= 60){
                grades[i][0] = "C";
            } else if (percent >= 50){
                grades[i][0] = "D";
            } else if (percent >= 40){
                grades[i][0] = "E";
            } else{
                grades[i][0] = "R";
			}
        }
        return grades;
    }

    public static void displayScoreCard(
            int[][] scores, double[][] results, String[][] grades) {

        System.out.println("\nID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t" + 
			(int)results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t\t" + grades[i][0]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students : ");
        int n = input.nextInt();

        int[][] pcmScores = generatePCMScores(n);
        double[][] results = calculateResults(pcmScores);
        String[][] grades = calculateGrades(results);

        displayScoreCard(pcmScores, results, grades);
    }
}
