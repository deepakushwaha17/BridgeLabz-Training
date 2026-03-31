package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortExamScores {
	
	public static void sortScores(int[] scores , int length) {
		for(int i = 0; i < length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j < length; j++) {
				if(scores[j] < scores[minIndex]) {
					minIndex = j;
				}
			}
			int temp = scores[i];
			scores[i] = scores[minIndex];
			scores[minIndex] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of students : ");
		int n = input.nextInt();
		
		System.out.println("Enter the students exam scores : ");
		int[] scores = new int[n];
		for(int i = 0; i < n; i++) {
			scores[i] = input.nextInt();
		}
		
		sortScores(scores,n);
		System.out.println("Exam Scores in Ascending order : " +Arrays.toString(scores));
		
		input.close();

	}

}
