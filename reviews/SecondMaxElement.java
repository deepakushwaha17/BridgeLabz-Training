package classandobject;

import java.util.Scanner;

public class SecondMaxElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter array size : ");
		int n = input.nextInt();
		System.out.println("Enter array elements : ");
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = input.nextInt();
		}
		
		int largest = arr[0];
		for(int i = 1; i < n ; i++) {
			if(arr[i] > largest) {
				largest = arr[i];
			}
		}
		
		int secondLargest = arr[0];
		for(int i = 1; i < n; i++) {
			if(arr[i] > secondLargest && arr[i] != largest) {
				secondLargest = arr[i];
			}
		}
		
		System.out.println("Second Largest Element is : " +secondLargest);

	}

}
