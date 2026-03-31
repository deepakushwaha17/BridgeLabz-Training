package collections.queue;

import java.util.Arrays;

public class CircularBuffer {

    private int[] queue;
    private int size;
    private int front = 0;   // points to oldest element
    private int rear = 0;    // points to next insertion position
    private int count = 0;   // number of elements in buffer

    public CircularBuffer(int size) {
        this.size = size;
        queue = new int[size];
    }

    // Insert element into circular buffer
    public void insert(int value) {
        queue[rear] = value;
        rear = (rear + 1) % size;

        if (count < size) {
            count++;
        } else {
            // Buffer full - overwrite oldest
            front = (front + 1) % size;
        }
    }

    // Display buffer elements in correct order
    public void display() {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = queue[(front + i) % size];
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display(); 

        buffer.insert(4);
        buffer.display(); 
    }
}
