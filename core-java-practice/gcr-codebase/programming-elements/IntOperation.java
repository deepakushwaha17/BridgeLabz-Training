/*Write an IntOperation program by taking a, b, and c as input values and print the following integer operations a + b *c, a * b + c, c + a / b, 
and a % b + c. Please also understand the precedence of the operators. */

import java.util.Scanner;

public class IntOperation{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter value of a : ");
		int a = input.nextInt();
		System.out.print("Enter value of b : ");
		int b = input.nextInt();
		System.out.print("Enter value of c : ");
		int c = input.nextInt();
		int intOperationResult1 = a + b * c;
		int intOperationResult2 = a * b + c;
		int intOperationResult3 = c + a / b;
		int intOperationResult4 = a % b + c;
		System.out.println("The results of Int Operations are " + intOperationResult1 + " , " + intOperationResult2 + " , " + intOperationResult3 + " and " + intOperationResult4);
		input.close();
	}
}
