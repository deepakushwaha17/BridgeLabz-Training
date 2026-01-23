package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        q1.add(x);
    }

    // Pop operation
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move all but last element to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Last element is the stack top
        int top = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Top operation
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.remove();
        q2.add(top); // Keep it in the stack

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); 
        System.out.println("Popped: " + stack.pop());     
        System.out.println("Popped: " + stack.pop());     
        System.out.println("Top element: " + stack.top());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

