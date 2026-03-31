package exceptions;

import java.util.Scanner;

public class FinallyBlockExecution {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter number1: ");
			int num1 = input.nextInt();
			System.out.print("Enter number2: ");
			int num2 = input.nextInt();
			
			int result = num1/num2;
			System.out.println("Division Result: "+result);
			
			input.close();
		}
		catch(ArithmeticException e) {
			System.out.println("ArithmeticException: Divide by zero.");
		}
		finally {
			System.out.println("Operation completed");
		}

	}

}
