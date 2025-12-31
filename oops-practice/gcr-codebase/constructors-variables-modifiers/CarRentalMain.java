package classandobject;

public class CarRentalMain {

	public static void main(String[] args) {
		CarRental carRental1 = new CarRental();
		carRental1.display();
		
        CarRental carRental2 = new CarRental("Deepa", "Sedan", 5);
        carRental2.display();

	}

}

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double rentPerDay;

    public CarRental() {
        customerName = "Customer";
        carModel = "Hatchback";
        rentalDays = 1;
        rentPerDay = 1000;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.rentPerDay = 1000;
    }

    public double calculateTotalCost() {
        return rentalDays * rentPerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car Model: " + carModel +
            ", Days: " + rentalDays + ", Total Cost: ₹" + calculateTotalCost());
    }
}
