/*Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their 
ages and tallest among the friends based on their heights and display it */

import java.util.Scanner;

public class YoungestAndTallestFriend {

    public static int findYoungest(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findTallest(double[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take input for ages and heights
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height (in cm) of " + friends[i] + ": ");
            heights[i] = input.nextDouble();
        }

        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        System.out.println("\nYoungest friend is " + friends[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend is " + friends[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");

        input.close();
    }
}
