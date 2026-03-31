package TrafficManager;

import java.util.LinkedList;
import java.util.Queue;

class WaitingQueue {
    private Queue<String> queue;
    private int capacity;

    public WaitingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    // Add vehicle to waiting queue
    public void enqueue(String plateNumber) {
        if (queue.size() >= capacity) {
            System.out.println("Queue Overflow! Cannot add " + plateNumber);
            return;
        }
        queue.add(plateNumber);
        System.out.println("Vehicle " + plateNumber + " is waiting to enter.");
    }

    // Remove vehicle from waiting queue 
    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }

    // Show waiting queue
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("No vehicles waiting.");
            return;
        }
        System.out.println("Waiting Queue: " + queue);
    }
}