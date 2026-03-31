package dsaProblems;

import java.util.*;

public class ZeoSumSubarrays {

	public static void findZeroSum(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0,1);
		
		for(int num : arr) {
			sum += num;
			if(map.containsKey(sum)) {
				System.out.println("Zero sum subarray exists.");
				return;
			}
			map.put(sum,map.getOrDefault(sum,0) + 1);
		}
		System.out.println("No zero sum subarray");		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter size : ");
		int n = input.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter elements : ");
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		findZeroSum(arr);
		
		input.close();
	}

}
