/*Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. 
Compute the percentage and then calculate the grade  as per the following guidelines  */

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num = input.nextInt();
        int[] physics = new int[num];
        int[] chemistry = new int[num];
        int[] maths = new int[num];
        double[] percent = new double[num];
        String[] grade = new String[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            System.out.print("Physics: ");
            physics[i] = input.nextInt();
            System.out.print("Chemistry: ");
            chemistry[i] = input.nextInt();
            System.out.print("Maths: ");
            maths[i] = input.nextInt();

            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.err.println("Invalid marks! Enter positive values.");
                i--;
            }
        }

        for (int i = 0; i < num; i++) {
            int total = physics[i] + chemistry[i] + maths[i];
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
            System.out.println((i + 1) + "\t" + physics[i] + "\t" + chemistry[i] + "\t\t" +
                maths[i] + "\t" + String.format("%.2f", percent[i]) + "\t\t" + grade[i]);
        }
        input.close();
    }
}
