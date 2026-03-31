package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortBookPrices {
	public static void sortPrices(int[] prices , int left , int right) {
		if(left <  right) {
			int mid = left + (right - left)/2;
			sortPrices(prices, left, mid);
			sortPrices(prices, mid+1, right);
			mergePrices(prices, left, mid, right);
		}
	}
	
	public static void mergePrices(int[] prices , int left , int mid , int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		
		System.arraycopy(prices, left, leftArr, 0, n1);
		System.arraycopy(prices, mid+1, rightArr, 0, n2);
		
		int i = 0, j = 0, k = left;
		while(i < n1 && j < n2) {
			if(leftArr[i] <= rightArr[j]) {
				prices[k++] = leftArr[i++];
			}else {
				prices[k++] = rightArr[j++];
			}
		}
		while(i < n1) {
			prices[k++] = leftArr[i++];
		}
		while(j < n2) {
			prices[k++] = rightArr[j++];
		}
				
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of books : ");
		int n = input.nextInt();
		
		System.out.println("Enter the book prices : ");
		int[] prices = new int[n];
		for(int i = 0; i < n; i++) {
			prices[i] = input.nextInt();
		}
		
		sortPrices(prices,0,n-1);
		System.out.println("Book Prices in Ascending order : " +Arrays.toString(prices));
		
		input.close();
	}

}
