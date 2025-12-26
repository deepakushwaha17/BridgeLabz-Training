/*Rewrite the above program using multi-dimensional array to store height, weight, 
and BMI in 2D array for all the persons */

import java.util.Scanner;
public class BMI2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        //Input weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details of person " + (i + 1));
            System.out.print("Weight in kg : ");
            personData[i][0] = input.nextDouble();
            System.out.print("Height in m : ");
            personData[i][1] = input.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.err.println("Invalid input! Enter positive values.");
                i--; 
            }
        }

        for (int i = 0; i < number; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]); 

            if (personData[i][2] < 18.5){
                weightStatus[i] = "Underweight";
            }else if (personData[i][2] < 25){
                weightStatus[i] = "Normal weight";
            }else if (personData[i][2] < 30){
                weightStatus[i] = "Overweight";
            }else{
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nWeight\tHeight\t\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.println(personData[i][0] + "\t" + personData[i][1] + "\t" + personData[i][2] + "\t" + weightStatus[i]);
        }
        input.close();
    }
    
}
