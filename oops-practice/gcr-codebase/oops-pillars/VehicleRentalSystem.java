package oopsPillars;

public class VehicleRentalSystem {
	
	 public static void calculateTotalCost(Vehicle vehicle, int days) {
		 double rentalCost = vehicle.calculateRentalCost(days);
		 double insuranceCost = 0;

		 if (vehicle instanceof Insurable) {
			 Insurable ins = (Insurable) vehicle;
			 insuranceCost = ins.calculateInsurance();
			 System.out.println(ins.getInsuranceDetails());
		 }

	    vehicle.displayVehicle();
	    System.out.println("Rental Cost (" + days + " days): " + rentalCost);
	    System.out.println("Insurance Cost: " + insuranceCost);
	    System.out.println("Total Cost: " + (rentalCost + insuranceCost));

	}

	public static void main(String[] args) {
		 Vehicle[] vehicles = new Vehicle[3];

		 vehicles[0] = new Car("CAR101", 1000, "CAR-INS-01", 500);
	     vehicles[1] = new Bike("BIKE202", 300, "BIKE-INS-02", 200);
	     vehicles[2] = new Truck("TRUCK303", 2000, "TRUCK-INS-03", 800);

	     int days = 5;

	     for (Vehicle v : vehicles) {
	    	 calculateTotalCost(v, days);
	     }
	}
}

//abstract method
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // per day

    //constructor
    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        setRentalRate(rentalRate);
    }

    //public getter for vehicle number
    public String getVehicleNumber() {
        return vehicleNumber;
    }

  //public getter for vehicle type
    public String getType() {
        return type;
    }

    //public getter for vehicle rent rate
    public double getRentalRate() {
        return rentalRate;
    }

    //public setter for rent rate with validation
    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0)
            this.rentalRate = rentalRate;
        else
            System.out.println("Invalid rental rate");
    }

    //abstract method
    abstract double calculateRentalCost(int days);

    public void displayVehicle() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Rate/day: " + rentalRate);
    }
}

//interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

//subclasses
class Car extends Vehicle implements Insurable {

    String insurancePolicyNumber; 
    double insuranceRate;

    public Car(String number, double rate, String policy, double insuranceRate) {
        super(number, "Car", rate);
        this.insurancePolicyNumber = policy;
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Applied";
    }
}

class Bike extends Vehicle implements Insurable {

    String insurancePolicyNumber;
    double insuranceRate;

    public Bike(String number, double rate, String policy, double insuranceRate) {
        super(number, "Bike", rate);
        this.insurancePolicyNumber = policy;
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; // discount for bikes
    }

    @Override
    public double calculateInsurance() {
        return insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "\nBike Insurance Applied";
    }
}

class Truck extends Vehicle implements Insurable {

    String insurancePolicyNumber;
    double insuranceRate;

    public Truck(String number, double rate, String policy, double insuranceRate) {
        super(number, "Truck", rate);
        this.insurancePolicyNumber = policy;
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; 
    }

    @Override
    public double calculateInsurance() {
        return insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "\nTruck Insurance Applied";
    }
}


