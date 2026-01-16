package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortProductPrices {
	
	public static void sortPrices(int[] prices , int low, int high) {
		if(low < high) {
			int pivot = partition(prices, low, high);
			sortPrices(prices, low, pivot-1);
			sortPrices(prices, pivot+1, high);
		}
		
	}
	
	public static int partition(int[] prices, int low, int high) {
		int pivot = prices[high];
		int i = low-1;
		for(int j = low; j < high; j++) {
			if(prices[j] < pivot) {
				i++;
				int temp = prices[i];
				prices[i] = prices[j];
				prices[j] = temp;
			}
		}
		int temp = prices[i+1];
		prices[i+1] = prices[high];
		prices[high] = temp;
		
		return i+1;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of products : ");
		int n = input.nextInt();
		
		System.out.println("Enter the product prices : ");
		int[] prices = new int[n];
		for(int i = 0; i < n; i++) {
			prices[i] = input.nextInt();
		}
		
		sortPrices(prices,0,n-1);
		System.out.println("Product Prices in Ascending order : " +Arrays.toString(prices));
		
		input.close();

	}

}
