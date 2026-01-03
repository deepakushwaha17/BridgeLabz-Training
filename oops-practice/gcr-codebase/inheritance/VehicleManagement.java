package inheritance;

public class VehicleManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250);
	     PetrolVehicle pv = new PetrolVehicle("Honda Civic", 180);

	     ev.displayInfo();
	     pv.displayInfo();

	     ev.charge();
	     pv.refuel();

	}

}
//Interface defining refueling behavior
interface Refuelable {
	void refuel(); 
}

//Superclass Vehicle
class Vehicle {
	String model;
	 int maxSpeed;
	
	 public Vehicle(String model, int maxSpeed) {
	     this.model = model;
	     this.maxSpeed = maxSpeed;
	 }
	
	 public void displayInfo() {
	     System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
	 }
}

//ElectricVehicle inherits Vehicle
class ElectricVehicle extends Vehicle {
	
	 public ElectricVehicle(String model, int maxSpeed) {
	     super(model, maxSpeed);
	 }

	 public void charge() {
	     System.out.println(model + " is charging its battery.");
	 }
}

//PetrolVehicle inherits Vehicle and implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {

	 public PetrolVehicle(String model, int maxSpeed) {
	     super(model, maxSpeed);
	 }

	 @Override
	 public void refuel() {
	     System.out.println(model + " is refueling at the petrol station.");
	 }
}

