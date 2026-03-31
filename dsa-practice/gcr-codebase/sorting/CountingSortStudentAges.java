package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortStudentAges {

	public static int[] sortAges(int[] ages) {
		int minAge = 10;
		int maxAge = 18;
		int range = maxAge - minAge + 1;
		
		int[] count = new int[range];
		
		int[] sortedAges = new int [ages.length];
		
		//count frequencies
		for(int age : ages) {
			count[age-minAge]++;
		}
		
		//compute prefixSum or cumulative frequencies
		for(int i = 1; i < range; i++) {
			count[i] += count[i-1];
		}
		
		//build output array
		for(int i = ages.length-1; i >= 0; i--) {
			int age = ages[i];
			sortedAges[count[age-minAge] -1] = age;
			count[age-minAge]--;
		}
		
		return sortedAges;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of students : ");
		int n = input.nextInt();
		
		System.out.println("Enter the students ages : ");
		int[] ages = new int[n];
		for(int i = 0; i < n; i++) {
			ages[i] = input.nextInt();
		}
		
		int[] sortedAges = sortAges(ages);
		System.out.println("Student Ages in Ascending order : " +Arrays.toString(sortedAges));
		
		input.close();
	}

}
