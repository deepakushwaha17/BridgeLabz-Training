package RestaurantOrderSystem;

public class RestaurantKitchenSystem {
	
	public static void main(String[] args) throws InterruptedException {

		Thread chef1 = new Thread(new Chef("Chef-1", "Pizza", 3));
        Thread chef2 = new Thread(new Chef("Chef-2", "Pasta", 2));
        Thread chef3 = new Thread(new Chef("Chef-3", "Salad", 1));
        Thread chef4 = new Thread(new Chef("Chef-4", "Burger", 2.5));

        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        // Wait for all chefs to finish
        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();

        System.out.println("\nKitchen closed - All orders completed");
    }
}