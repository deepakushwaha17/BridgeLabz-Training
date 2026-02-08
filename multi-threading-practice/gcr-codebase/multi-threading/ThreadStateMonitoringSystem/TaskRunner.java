package ThreadStateMonitoringSystem;

public class TaskRunner extends Thread {

    TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            // RUNNABLE state
        	double result = 0;
        	for (long i = 0; i < 200000000L; i++) {
                result += Math.sqrt(i);
            }
        	
            for (int i = 0; i < 3; i++) {
                Thread.sleep(2000); // TIMED_WAITING
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}