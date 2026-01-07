/*Cab Booking / Ride Management System : Key Features (CRUD)
Real Scenario
Users book rides, drivers accept, and fare is calculated.Key Features
  - Ride booking
  - Driver assignment
  - Fare calculation
  - Ride history*/

package classandobject;

import java.util.Scanner;
import java.util.ArrayList;

public class CabBooking {
	
	static ArrayList<Driver> drivers = new ArrayList<>();
	static ArrayList<Ride> rides = new ArrayList<>();
	static int rideCounter = 1;
	
	// method to assign driver if available or throw NoDriverAvailableException if no driver available
	public static Driver assignDriver()throws NoDriverAvailableException{
		for(Driver d : drivers) {
			if(d.isAvailable()) {
				d.setAvailable(false);
				return d;
			}
		}
		throw new NoDriverAvailableException("No driver avialable!");
	}
	
	// method to book ride
	public static void bookRide(Scanner input) {
		try {
			System.out.print("User Id : ");
			int userId = input.nextInt();
			input.nextLine(); // to consume the line
			System.out.print("User Name : ");
			String userName = input.nextLine();
			System.out.print("Distance (in km) : ");
			double distance = input.nextDouble();		
			System.out.print("Pricing (1-Normal / 2-Peak) : ");
			int priceType = input.nextInt();
			
			//calculate fare
			FareCalculator fareCalculator = (priceType == 1) ? new NormalFare() : new PeakFare();
			
			//assign driver if available
			Driver driver = assignDriver();
			double fare = fareCalculator.calculateFare(distance);
			
			User user = new User(userId,userName);
			Ride ride = new Ride(rideCounter++ , user, driver, distance, fare, "Completed");
			
			rides.add(ride);
			System.out.println("Ride booked successfully");
			System.out.println("Driver : " +driver.getDriverName());
			System.out.println("Fare $: "+fare);
			
		}catch(NoDriverAvailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// method to view ride history
	public static void viewRideHistory() {
		if(rides.isEmpty()) {
			System.out.println("No rides found.");
			return;
		}
		for(Ride r : rides) {
			System.out.println("\nRide Id : " +r.getRideId());
			System.out.println("User : " +r.getUser().getUserName());
			System.out.println("Driver : " +r.getDriver().getDriverName());
			System.out.println("Fare : $" +r.getFare());
			System.out.println("Status : " +r.getStatus());
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		drivers.add(new Driver(1,"Amit"));
		drivers.add(new Driver(2,"Rohit"));
		
		while(true) {
			System.out.println("\n-----Cab Booking System-----");
			System.out.println("1. Book Ride");
			System.out.println("2. View Ride History");
			System.out.println("3. Exit");
			
			System.out.print("\nEnter the choice : ");
			int choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
				case 1:
					bookRide(input);
					break;
				case 2:
					viewRideHistory();
					break;
				case 3:
					System.out.println("Thank you for using.");
					System.exit(0);
				default:
					System.out.println("Invalid Choice!");
			}
		}

	}

}

// interface to calculate fare
interface FareCalculator{
	double calculateFare(double distance);
}

// polymorphism to calculate peak and normal pricing 
class NormalFare implements FareCalculator{
	public double calculateFare(double distance) {
		return distance * 10; // $10/km normal price
	}
}

class PeakFare implements FareCalculator{
	public double calculateFare(double distance) {
		return distance * 15; // $15/km peak price
	}
}

// custom exception if no driver available
class NoDriverAvailableException extends Exception{
	public NoDriverAvailableException(String message) {
		super(message);
	}
}

// User class
class User{
	private int userId;
	private String userName;
	
	//constructor
	User(int userId , String userName){
		this.userId = userId;
		this.userName = userName;
	}
	
	// public getter for userId
	public int getUserId() {
		return userId;
	}
	
	//public getter for userName
	public String getUserName() {
		return userName;
	}
}

// Driver class
class Driver{
	private int driverId;
	private String driverName;
	private boolean available ;
	
	// constructor
	Driver(int driverId , String driverName){
		this.driverId = driverId;
		this.driverName = driverName;
		this.available = true;
	}
	
	//public getter for driverName
	public String getDriverName() {
		return driverName;
	}
	
	//public getter for isAvailable
	public boolean isAvailable() {
		return available;
	}
	
	//public setter for isAvailable
	public void setAvailable(boolean available) {
		this.available = available;
	}
}

//Ride class
class Ride{
	private int rideId;
	private User user;
	private Driver driver;
	private double distance;
	private double fare;
	private String status;
	
	//constructor
	Ride(int rideId , User user , Driver driver , double distance , double fare , String status){
		this.rideId = rideId;
		this.user = user;
		this.driver = driver;
		this.distance = distance;
		this.fare = fare;
		this.status = status;
	}
	
	// public getter for rideId
	public int getRideId() {
		return rideId;
	}
	
	// public getter for user
	public User getUser() {
		return user;
	}
	
	// public getter for driver
	public Driver getDriver() {
		return driver;
	}
	
	// public getter for fare
	public double getFare() {
		return fare;
	}
	
	// public getter for status
	public String getStatus() {
		return status;
	}
}