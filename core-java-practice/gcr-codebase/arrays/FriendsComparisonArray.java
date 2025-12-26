/*Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on 
their ages and the tallest among the friends based on their heights */

import java.util.Scanner;

public class FriendsComparisonArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height of " + names[i]);
            age[i] = input.nextInt();
            height[i] = input.nextDouble();
        }

        int youngestIndex = 0, tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex])
                youngestIndex = i;

            if (height[i] > height[tallestIndex])
                tallestIndex = i;
        }

        System.out.println("Youngest Friend is " + names[youngestIndex] + "\nTallest Friend is " + names[tallestIndex]);
        input.close();
    }
}
