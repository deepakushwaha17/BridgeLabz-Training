//Rewrite the program 10(SumUntilZero) to find the sum until the user enters 0 or a negative number using while loop and break statement

import java.util.Scanner;

public class SumUntilZeroBreak{
    public static void main(String[] args){
	    
		double totalOfNumber = 0.0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		double enteredValue = input.nextDouble();
		while(true){
			if(enteredValue <= 0){
				break;
			}
			else{
				totalOfNumber += enteredValue;
				System.out.print("Enter a number : ");
				enteredValue = input.nextDouble();
			}
		}
		System.out.println("Sum of numbers is " + totalOfNumber);
		input.close();
	}
}	