package oopsPillars;

public class RideHailingApplication {
	
	 public static void calculateRideFare(Vehicles[] vehicles, double distance) {

		 for (Vehicles v : vehicles) {
			 v.getVehicleDetails();

	         double fare = v.calculateFare(distance);
	         System.out.println("Distance: " + distance + " km");
	         System.out.println("Total Fare: ₹" + fare);

	         if (v instanceof GPS) {
	        	 GPS g = (GPS) v;
	             System.out.println("Current Location: " + g.getCurrentLocation());
	         }

	         System.out.println("---------------------------");
	     }
	 }
	 public static void main(String[] args) {

		 Vehicles[] vehicles = new Vehicles[3];

		 Cars car = new Cars("C101", "Rahul", 15);
	     car.updateLocation("Sector 18");

	     Bikes bike = new Bikes("B201", "Aman", 8);
	     bike.updateLocation("MG Road");

	     Autos auto = new Autos("A301", "Suresh", 10);
	     auto.updateLocation("Railway Station");
	     
	     vehicles[0] = car;
	     vehicles[1] = bike;
	     vehicles[2] = auto;
	
	     calculateRideFare(vehicles, 10);
	 }
}

//abstract method
abstract class Vehicles {

    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicles(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // public getters for attributes
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);
    
    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per KM: ₹" + ratePerKm);
    }

    
}

//interface 
interface GPS {
    void updateLocation(String location);
    String getCurrentLocation();
}

//subclasses
class Cars extends Vehicles implements GPS {

    private String location;

    public Cars(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // base charge
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }
}

class Bikes extends Vehicles implements GPS {

    private String location;

    public Bikes(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }
}

class Autos extends Vehicles implements GPS {

    private String location;

    public Autos(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // auto service charge
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }
}
