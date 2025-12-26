/*Rewrite the above program to store the marks of the students in physics, chemistry, and maths 
in a 2D array and then compute the percentage and grade */

import java.util.Scanner;

public class StudentGrade2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num = input.nextInt();
        int[][] marks = new int[num][3];
        double[] percent = new double[num];
        String[] grade = new String[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            System.out.print("Physics: ");
            marks[i][0] = input.nextInt();
            System.out.print("Chemistry: ");
            marks[i][1] = input.nextInt();
            System.out.print("Maths: ");
            marks[i][2] = input.nextInt();

            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.err.println("Invalid marks! Enter positive values.");
                i--;
            }
        }

        for (int i = 0; i < num; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percent[i] = (double) total * 100 / 300;

            if (percent[i] >= 80.0)
                grade[i] = "Grade A, Remark: Level 4, above agency-normalized standards";
            else if (percent[i] >= 70.0)
                grade[i] = "Grade B, Remark: Level 3, at agency-normalized standards";
            else if (percent[i] >= 60.0)
                grade[i] = "Grade C, Remark: Level 2, below, but approaching agency-normalized standards";
            else if (percent[i] >= 50.0)
                grade[i] = "Grade D, Remark: Level 1, well below agency-normalized standards";
            else if (percent[i] >= 40.0)
                grade[i] = "Grade E, Remark: Level 1-, too below agency-normalized standards";
            else
                grade[i] = "Grade R, Remark: Remedial standards";
        }

        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade & Remark");
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t\t" +
                marks[i][2] + "\t" + String.format("%.2f", percent[i]) + "\t\t" + grade[i]);
        }
        input.close();
    }
}
