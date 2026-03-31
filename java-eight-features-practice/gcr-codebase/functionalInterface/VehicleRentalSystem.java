package functionalInterface;

interface Vehicle{
	void rent();
	void returnVehicle();
}

class Cars implements Vehicle{
	@Override
	public void rent() {
		System.out.println("Car Rent : $2000");
	}
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle Type : Car");
	}
}

class Bikes implements Vehicle{
	@Override
	public void rent() {
		System.out.println("Bike Rent : $1000");
	}
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle Type : Bike");
	}
}

class Buses implements Vehicle{
	@Override
	public void rent() {
		System.out.println("Bus Rent : $20000");
	}
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle Type : Bus");
	}
}

public class VehicleRentalSystem {

	public static void main(String[] args) {
		Cars cars = new Cars();
		cars.rent();
		cars.returnVehicle();
		
		Bikes bikes = new Bikes();
		bikes.rent();
		bikes.returnVehicle();
		
		Buses buses = new Buses();
		buses.rent();
		buses.returnVehicle();
	}

}
