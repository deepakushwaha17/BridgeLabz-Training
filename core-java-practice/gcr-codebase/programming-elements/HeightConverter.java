//Write a program that takes your height in centimeters and converts it into feet and inches

import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightInCm = input.nextDouble();
        double totalInches = heightInCm / 2.54;
        double heightinFeet = totalInches / 12;
        double heightInInches = totalInches % 12;
        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + heightinFeet + " and inches is " + heightInInches);
        input.close();
    }
}
