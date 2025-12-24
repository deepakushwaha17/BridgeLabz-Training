//write the DoubleOpt program by taking double values and doing the same operations.

import java.util.Scanner;

public class DoubleOpt{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter value of a : ");
		double a = input.nextDouble();
		System.out.print("Enter value of b : ");
		double b = input.nextDouble();
		System.out.print("Enter value of c : ");
		double c = input.nextDouble();
		double doubleOperationResult1 = a + b * c;
		double doubleOperationResult2 = a * b + c;
		double doubleOperationResult3 = c + a / b;
		double doubleOperationResult4 = a % b + c;
		System.out.println("The results of Int Operations are " + doubleOperationResult1 + " , " + doubleOperationResult2 + " , " + doubleOperationResult3 + " and " + doubleOperationResult4);
		input.close();
	}
}
