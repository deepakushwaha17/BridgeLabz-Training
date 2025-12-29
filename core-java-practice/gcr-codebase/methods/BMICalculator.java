/*An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in the 
team of 10 members. For this create a program to find the BMI and display the height, weight, 
BMI and status of each individual */

import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi; 
        }
    }

    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] data = new double[10][3]; // 10 persons, 3 columns

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + " : ");
            data[i][0] = input.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + " : ");
            data[i][1] = input.nextDouble();
        }

        calculateBMI(data);

        String[] status = determineBMIStatus(data);

        System.out.println("\nWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            String weight = String.format("%.2f", data[i][0]);
            String height = String.format("%.2f", data[i][1]);
            String bmi = String.format("%.2f", data[i][2]);
            System.out.println(weight + "\t" + height + "\t" + bmi + "\t\t" + status[i]);
        }
        input.close();
    }
}
