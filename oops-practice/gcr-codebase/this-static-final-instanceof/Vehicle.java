package classandobject;

public class Vehicle {

	static double registrationFee = 0.0; // static variable
	private String ownerName;
	private String vehicleType;
	final String registrationNumber;
	
	public Vehicle(String ownerName , String vehicleType , String registrationNumber) {
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
		this.registrationNumber = registrationNumber;
	}
	
	//static method
	public static void updateRegistrationFee(double newRegistrationFee) {
		registrationFee = newRegistrationFee;
	}
	
	public void displayDetails() {
		if(this instanceof Vehicle) {
			System.out.println("Owner Name : " +ownerName);
			System.out.println("Vehicle Type : " +vehicleType);
			System.out.println("Registration Number : " +registrationNumber);
			System.out.println("Registration Fee : $" +registrationFee);	
		}
		else {
			System.out.println("Invalid Vehicle instance!");
		}
	}
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle("Honest raj","Sedan","ABC123");
		Vehicle vehicle2 = new Vehicle("Price danish","SUV","XYZ789");
		
		updateRegistrationFee(150.0);
		vehicle1.displayDetails();
		vehicle2.displayDetails();
	}

}
