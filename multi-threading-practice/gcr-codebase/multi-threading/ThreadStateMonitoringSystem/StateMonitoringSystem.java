package ThreadStateMonitoringSystem;

import java.time.LocalTime;

public class StateMonitoringSystem {
    public static void main(String[] args) {

        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");

        // Monitor observes states
        StateMonitor monitor = new StateMonitor(task1, task2);
        monitor.start();

        System.out.println("[Monitor] " + task1.getName() + " is in " + task1.getState() + " state at " + LocalTime.now());
        System.out.println("[Monitor] " + task2.getName() + " is in " + task2.getState() + " state at " + LocalTime.now());

        task1.start();
        task2.start();
    }
}