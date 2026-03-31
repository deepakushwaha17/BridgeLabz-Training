package ThreadStateMonitoringSystem;

import java.time.LocalTime;

public class StateMonitor extends Thread {
    private Thread[] threads;

    StateMonitor(Thread... threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        boolean allTerminated = false;

        while (!allTerminated) {
            allTerminated = true;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                System.out.println("[Monitor] " + t.getName() + " is in " + state + " state at " + LocalTime.now());

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500); // check every 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
        }

        System.out.println("Summary: All threads went through 4 states");
    }
}
