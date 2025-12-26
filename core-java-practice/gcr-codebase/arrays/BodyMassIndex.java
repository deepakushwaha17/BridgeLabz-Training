/*An organization took up an exercise to find the Body Mass Index (BMI) of all the persons in the team. For this 
create a program to find the BMI and display the height, weight, BMI and status of each individual */

import java.util.Scanner;

public class BodyMassIndex {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details of person " + (i + 1));
            System.out.print("Weight in kg : ");
            weight[i] = input.nextDouble();
            System.out.print("Height in m: ");
            height[i] = input.nextDouble();
        }

        for (int i = 0; i < number; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5){
                status[i] = "Underweight";
            }else if (bmi[i] < 25){
                status[i] = "Normal weight";
            }else if (bmi[i] < 30){
                status[i] = "Overweight";
            }else{
                status[i] = "Obese";
            }
        }
        
        System.out.println("\nHeight\tWeight\t\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.println(height[i] + "\t" + weight[i] + "\t" + bmi[i] + "\t" + status[i]);
        }
        input.close();
    }
    
}
