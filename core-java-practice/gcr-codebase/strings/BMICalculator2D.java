/*An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a team of 10 members. For this create 
a program to find the BMI and display the height, weight, BMI, and status of each individual*/

import java.util.Scanner;

public class BMICalculator2D {

    public static String[] calculateBMIStatus(double weight, double heightCm) {

        double heightMeter = heightCm / 100;   // 1m = 100cm
        double bmi = weight / (heightMeter * heightMeter);
        bmi = Math.round(bmi * 100.0) / 100.0; // round to 2 decimals

        String status;
        if (bmi < 18.5){
            status = "Underweight";
        } else if (bmi < 24.9){
            status = "Normal";
        } else if (bmi < 39.9){
            status = "Overweight";
        }else{
            status = "Obese";
		}
        return new String[] {String.valueOf(heightCm),String.valueOf(weight),String.valueOf(bmi),status};
    }

    public static String[][] generateBMITable(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            result[i] = calculateBMIStatus(data[i][0], data[i][1]);
        }
        return result;
    }

    public static void displayBMITable(String[][] table) {

        System.out.println("\nID\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < table.length; i++) {
            System.out.println((i + 1) + "\t" + table[i][0] + "\t\t" + table[i][1] + "\t\t" + table[i][2] + "\t" + table[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int members = 10;
        double[][] data = new double[members][2]; // weight, height

        for (int i = 0; i < members; i++) {
            System.out.print("\nEnter weight (in kg) of person " + (i + 1) + ": ");
            data[i][0] = input.nextDouble();

            System.out.print("Enter height (in cm) of person " + (i + 1) + ": ");
            data[i][1] = input.nextDouble();
        }
        String[][] bmiTable = generateBMITable(data);
        displayBMITable(bmiTable);
    }
}
