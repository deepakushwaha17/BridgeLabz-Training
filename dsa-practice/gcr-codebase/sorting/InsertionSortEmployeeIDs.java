package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortEmployeeIDs {
	
	public static void sortIDs(int[] employeeIDs , int length) {
		for(int i = 1; i < length; i++) {
			int key = employeeIDs[i];
			int j = i-1;
			while(j >= 0 && employeeIDs[j] > key) {
				employeeIDs[j+1] = employeeIDs[j];
				j--;
			}
			employeeIDs[j+1] = key;
		}
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of employees : ");
		int n = input.nextInt();
		
		System.out.println("Enter the employee IDs : ");
		int[] employeeIDs = new int[n];
		for(int i = 0; i < n; i++) {
			employeeIDs[i] = input.nextInt();
		}
		
		sortIDs(employeeIDs,n);
		System.out.println("Employee IDs in Ascending order : " +Arrays.toString(employeeIDs));
		
		input.close();

	}

}
