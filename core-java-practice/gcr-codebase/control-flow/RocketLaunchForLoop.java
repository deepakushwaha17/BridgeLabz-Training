//Rewrite program 8(rocket launch count down) to do the countdown using the for-loop

import java.util.Scanner;

public class RocketLaunchForLoop{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter count down number : ");
		int counter = input.nextInt();
		for(int i=counter; i>=1; i--){
		    System.out.println(i);
		}
		input.close();
	}
}	
