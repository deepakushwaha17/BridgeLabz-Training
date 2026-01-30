package com.junit.practice;

public class PerformanceTask {

    // Long-running task (sleeps 3 seconds)
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task Interrupted");
        }
        return "Completed";
    }
}

