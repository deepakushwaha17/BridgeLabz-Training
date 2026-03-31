package dsaProblems;

import java.util.Stack;
import java.util.Scanner;

public class StockSpan {
	
	public static int[] calculateSpan(int[] prices) {
		int n = prices.length;
		int[] span = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			span[i] = (stack.isEmpty()) ? (i+1) : (i-stack.peek());
			stack.push(i);
		}
		return span;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number of days: ");
        int n = input.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = input.nextInt();
        }

        int[] span = calculateSpan(prices);

        System.out.println("Stock spans for each day:");
        for (int s : span) {
            System.out.print(s + " ");
        }
        
        input.close();
	}
}