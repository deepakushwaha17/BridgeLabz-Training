package classandobject;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalApplication {
	static List<Vehicle> vehicles = new ArrayList<>();

	public static void main(String[] args) {
		vehicles.add(new Bike(1, " Pasion Pro", 300));
		vehicles.add(new Car(2, " Toyota", 1500));
		vehicles.add(new Truck(3, "Tata", 2500));
		
		System.out.println("-----Available Vehicles-----");
		for(Vehicle v : vehicles) {
			v.displayInfo();
		}
		
        vehicles.get(0).rentPerDay = 350;
        
        vehicles.removeIf(v ->v.getVehicleId() == 2);

        System.out.println("--Rent calculation for 5 Days--");
        for(Vehicle v : vehicles) {
        	System.out.println("Vehicle ID: " + v.vehicleId + " Total Rent: " + v.calculateRent(3));
        }
	}

}

//Parent abstract class Vehicle
abstract class Vehicle implements IRentable{
	protected int vehicleId;
	protected String brand;
	protected double rentPerDay;
	
	public Vehicle(int vehicleId, String brand, double rentPerDay){
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.rentPerDay = rentPerDay;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}
	
	public abstract void displayInfo();
}

//Bike class
class Bike extends Vehicle{
	public Bike(int id , String brand , double rentPerDay) {
		super(id, brand, rentPerDay);
	}
	
	@Override
	public double calculateRent(int days) {
		return rentPerDay * days;
	}
	@Override
	public void displayInfo() {
		System.out.println("Bike ID: " + vehicleId + ", Brand: " + brand + ", Rent/day: " + rentPerDay);
	}
}

//Sub Class car
class Car extends Vehicle{
	public Car(int id , String brand , double rentPerDay) {
		super(id, brand, rentPerDay);
	}
	
	@Override
	public double calculateRent(int days) {
		
		// Service charge 500
		return (rentPerDay * days) + 500;
	}
	@Override
	public void displayInfo() {
		System.out.println("Car ID: " + vehicleId + ", Brand: " + brand + ", Rent/day: " + rentPerDay);
	}
}

//Sub class truck
class Truck extends Vehicle{
	public Truck(int id , String brand , double rentPerDay) {
		super(id, brand, rentPerDay);
	}
	
	@Override
	public double calculateRent(int days) {
		// heavy vehicle charge
		return (rentPerDay * days) + 1000;
	}
	@Override
	public void displayInfo() {
		System.out.println("Truck ID: " + vehicleId + ", Brand: " + brand + ", Rent/day: " + rentPerDay);
	}
}

//Customer class
class Customer{
	private String name;
	private int customerId;
	Customer(String name, int customerId){
		this.name = name;
		this.customerId = customerId;
	}
		
	public String getName() {
		return name;
	}
}

interface IRentable{
	 double calculateRent(int days);
}