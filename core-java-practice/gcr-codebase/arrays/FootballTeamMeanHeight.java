//Create a program to find the mean height of players present in a football team.

import java.util.Scanner;

public class FootballTeamMeanHeight{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;
		
		System.out.println("Enter heights of 11 players : ");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = input.nextDouble();
        }
		
		//loop to add all 11 players heights
		for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        double mean = sum / 11;
        System.out.println("Mean Height of Football Team is " + mean);
		input.close();
    }
	
}
