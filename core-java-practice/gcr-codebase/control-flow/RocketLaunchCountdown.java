//Write a program to count down the number from the user input value to 1 using a while loop for a rocket launch

import java.util.Scanner;

public class RocketLaunchCountdown{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter count down number : ");
		int counter = input.nextInt();
		while(counter >= 1){
		    System.out.println(counter);
			counter -= 1;
		}
		input.close();
	}
}	