package inheritance;

public class RestaurantManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chef chef = new Chef("Abc", 101);
	    Waiter waiter = new Waiter("X", 102);

	    chef.displayInfo();
	    waiter.displayInfo();

	    chef.performDuties();
	    waiter.performDuties();

	}

}

//Interface
interface Worker {
	void performDuties();
}

//Superclass Person
class Person1 {
	 String name;
	 int id;

	 public Person1(String name, int id) {
	     this.name = name;
	     this.id = id;
	 }
	
	 public void displayInfo() {
	     System.out.println("Name: " + name + ", ID: " + id);
	 }
}

//Chef class inherits Person and implements Worker
class Chef extends Person1 implements Worker {

	 public Chef(String name, int id) {
	     super(name, id);
	 }
	
	 @Override
	 public void performDuties() {
	     System.out.println(name + " is cooking delicious meals.");
	 }
}

//Waiter class inherits Person and implements Worker
class Waiter extends Person1 implements Worker {

	 public Waiter(String name, int id) {
	     super(name, id);
	 }
	
	 @Override
	 public void performDuties() {
	     System.out.println(name + " is serving food to customers.");
	 }
}

