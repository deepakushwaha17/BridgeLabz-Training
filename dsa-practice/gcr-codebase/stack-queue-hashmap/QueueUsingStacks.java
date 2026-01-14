package dsaProblems;

import java.util.Stack;
import java.util.Scanner;

public class QueueUsingStacks {

	Stack<Integer> stackEnqueue = new Stack<>();
	Stack<Integer> stackDequeue = new Stack<>();

	//Enqueue
	public void enqueue(int data) {
		stackEnqueue.push(data);
		System.out.println(data + " is inserted to queue.");
	}
	
	//Dequeue
	public void dequeue() {
		if(stackDequeue.isEmpty()) {
			if(stackEnqueue.isEmpty()) {
				System.out.println("Queue is empty!");
				return;
			}
			while(!stackEnqueue.isEmpty()) {
				stackDequeue.push(stackEnqueue.pop());
			}
		}
		int removed = stackDequeue.pop();
		System.out.println(removed + " is removed from queue.");
	}
	
	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n----Queue using Stacks----");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Exit");
			System.out.print("Enter the choice : ");
			int choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
				case 1:
					System.out.print("Enter the data : ");
					int data = input.nextInt();
					input.nextLine();
					queue.enqueue(data);
					break;
				case 2 :
					queue.dequeue();
					break;
				case 3 :
					System.out.print("Exiting...");
					input.close();
					return;
				default : 
					System.out.print("Invalid Choice!");
			}
		}
	}
}