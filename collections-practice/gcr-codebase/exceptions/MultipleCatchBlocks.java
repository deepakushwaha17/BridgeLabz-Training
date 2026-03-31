package exceptions;

import java.util.Scanner;

public class MultipleCatchBlocks {

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
			System.out.println("Value at index " +index+ ": " + arr[index]);
			input.close();

		}
		catch(NullPointerException e) {
			System.out.print("Array is not initialized!");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("Invalid index!");
		}
		
	}

}
