package exceptions;

import java.util.Scanner;

public class NestedTryCatch {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the array length: ");
			int n = input.nextInt();
			int[] arr = new int[n];
			
			System.out.println("Enter the array elements:");
			for(int i = 0; i < n; i++) {
				arr[i] = input.nextInt();
			}
			
			System.out.print("Enter the index value to retrieve element: ");
			int index = input.nextInt();
				
			try {
				int element = arr[index];
				System.out.print("Enter the divisor: ");
				int divisor = input.nextInt();
				
				int result = element / divisor;
				System.out.println("Division result: "+result);
			}catch(ArithmeticException e) {
				System.out.println("Cannot divide by zero!");
			}
			
			input.close();

		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("Invalid array index!");
		}
	}
}