package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSortJobApplicants {
	
	public static void heapify(int[] salaries, int n, int  i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < n && salaries[left] > salaries[largest]) {
			largest = left;
		}
		
		if(right < n && salaries[right] > salaries[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp =  salaries[i];
			salaries[i] = salaries[largest];
			salaries[largest] = temp;
			
			heapify(salaries , n ,largest);
		}
	}

	public static void sortApplicants(int salaries[] , int n) {
		
		//find max heap
		for(int i = n/2-1; i >= 0; i--) {
			heapify(salaries , n ,i);
		}
		
		for(int i = n-1; i > 0; i--) {
			int temp = salaries[0];
			salaries[0] = salaries[i];
			salaries[i] = temp;
			
			heapify(salaries , i ,0);
		}
	}
	public static void main(String[] args) {
		 	Scanner input = new Scanner(System.in);

	        System.out.print("Enter number of job applicants : ");
	        int n = input.nextInt();

	        int[] salaries = new int[n];
	        System.out.println("Enter expected salaries :");
	        for (int i = 0; i < n; i++) {
	            salaries[i] = input.nextInt();
	        }

	        sortApplicants(salaries, n);
	        System.out.println("Job Applicants Salaries in Ascending order : " +Arrays.toString(salaries));
			
			input.close();

	}

}
