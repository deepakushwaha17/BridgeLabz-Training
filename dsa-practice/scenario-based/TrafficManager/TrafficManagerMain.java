package TrafficManager;

public class TrafficManagerMain {
    public static void main(String[] args) {
        TrafficManager manager = new TrafficManager(3); // queue capacity 3

        manager.vehicleArrives("VA01AB1234");
        manager.vehicleArrives("VA02CD5678");
        manager.vehicleArrives("VA03EF9012");
        manager.vehicleArrives("VA04GH3456"); // queue overflow

        manager.showRoundabout();
        manager.showWaitingQueue();

        manager.vehicleExits("VA02CD5678");
        manager.showRoundabout();
        manager.showWaitingQueue();

        manager.vehicleExits("VA01AB1234");
        manager.vehicleExits("VA03EF9012");
        manager.vehicleExits("VA04GH3456"); // vehicle not on roundabout
    }
}