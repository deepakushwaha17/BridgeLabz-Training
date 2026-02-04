package functionalInterface;

interface Vehicles {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery percentage not available for this vehicle.");
    }
}
class Car implements Vehicles {

    @Override
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }

}

class ElectricCar implements Vehicles {

    @Override
    public void displaySpeed() {
        System.out.println("Electric Car speed: 60 km/h");
    }

    @Override
    public void displayBattery() {
        System.out.println("Battery percentage: 75%");
    }
}

public class VehicleDashboard {
    public static void main(String[] args) {
        Vehicles car = new Car();
        Vehicles ev = new ElectricCar();

        car.displaySpeed();
        car.displayBattery(); 

        ev.displaySpeed();
        ev.displayBattery(); 
    }
}
