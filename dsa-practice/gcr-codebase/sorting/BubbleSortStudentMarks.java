package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortStudentMarks {
	
	public static void sortMarks(int[] marks , int length) {
		boolean swapped;
		for(int i = 0; i < length-1; i++) {
			swapped = false;
			for(int j = 0; j < length-i-1; j++) {
				if(marks[j] > marks[j+1]) {
					int temp = marks[j];
					marks[j] = marks[j+1];
					marks[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of students : ");
		int n = input.nextInt();
		
		System.out.println("Enter the students marks : ");
		int[] marks = new int[n];
		for(int i = 0; i < n; i++) {
			marks[i] = input.nextInt();
		}
		
		sortMarks(marks,n);
		System.out.println("Students marks in Ascending order : " +Arrays.toString(marks));
		
		input.close();
	}
}