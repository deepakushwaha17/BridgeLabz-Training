package dsaProblems;

import java.util.Stack;
import java.util.Scanner;

public class SortStackUsingRecursion {
	
	//Insert in sorted stack
	public static void sortedInsert(Stack<Integer> stack , int element) {
		if(stack.isEmpty() || element > stack.peek()) {
			stack.push(element);
			return;
		}
		
		int top = stack.pop();
		sortedInsert(stack,element);
		stack.push(top);
	}
	
	//Sort the stack
	public static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int top = stack.pop();
			sortStack(stack);
			sortedInsert(stack,top);
		}
	}
	
	//Display stack
	public static void displayStack(Stack<Integer> stack) {
		System.out.println(stack);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		System.out.print("Enter the size of stack : ");
		int size = input.nextInt();
		
		System.out.println("Enter stack elements : ");
		for(int i = 0; i < size; i++) {
			stack.push(input.nextInt());
		}
		
		System.out.println("Original Stack : ");
		displayStack(stack);
		
		sortStack(stack);
		System.out.println("Sorted Stack in ascending order : ");
		displayStack(stack);
		
		input.close(); 
	}

}
