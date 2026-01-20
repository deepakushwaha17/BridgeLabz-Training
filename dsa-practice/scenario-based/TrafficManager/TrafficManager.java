package TrafficManager;

public class TrafficManager {
    private RoundAbout roundabout;
    private WaitingQueue waitingQueue;

    public TrafficManager(int queueCapacity) {
        roundabout = new RoundAbout();
        waitingQueue = new WaitingQueue(queueCapacity);
    }

    // Vehicle tries to enter roundabout
    public void vehicleArrives(String plateNumber) {
        waitingQueue.enqueue(plateNumber);
        processQueue();
    }

    // Process waiting queue and enter roundabout 
    private void processQueue() {
        String nextVehicle = waitingQueue.dequeue();
        if (nextVehicle != null) {
            roundabout.enterVehicle(nextVehicle);
        }
    }

    // Vehicle exits roundabout 
    public void vehicleExits(String plateNumber) {
        roundabout.exitVehicle(plateNumber);
        processQueue(); // next waiting vehicle enters
    }

    // Show roundabout state 
    public void showRoundabout() {
        roundabout.printRoundabout();
    }

    // Show waiting queue
    public void showWaitingQueue() {
        waitingQueue.printQueue();
    }
}