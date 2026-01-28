package scenario;
import java.util.*;

class Customer {
    String name;
    List<String> items;

    Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}

public class SmartCheckout {

    // Calculate bill for a customer
    static int calculateBill(Customer c, HashMap<String, Integer> priceMap,
                             HashMap<String, Integer> stockMap) {

        int total = 0;

        for (String item : c.items) {
            if (!priceMap.containsKey(item)) {
                System.out.println(item + " not found!");
                continue;
            }

            int stock = stockMap.get(item);

            if (stock > 0) {
                int price = priceMap.get(item);
                total += price;
                stockMap.put(item, stock - 1); // update stock
            } else {
                System.out.println(item + " is out of stock!");
            }
        }
        return total;
    }

    // Process checkout queue
    static void processQueue(Queue<Customer> queue,
                             HashMap<String, Integer> priceMap,
                             HashMap<String, Integer> stockMap) {

        while (!queue.isEmpty()) {
            Customer c = queue.poll(); // remove customer
            System.out.println("\nServing Customer: " + c.name);

            int bill = calculateBill(c, priceMap, stockMap);
            System.out.println("Total Bill = " + bill);
        }
    }

    public static void main(String[] args) {

        // Price Map
        HashMap<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Milk", 50);
        priceMap.put("Bread", 30);
        priceMap.put("Rice", 60);
        priceMap.put("Eggs", 120);

        // Stock Map
        HashMap<String, Integer> stockMap = new HashMap<>();
        stockMap.put("Milk", 2);
        stockMap.put("Bread", 1);
        stockMap.put("Rice", 2);
        stockMap.put("Eggs", 4);

        // Queue of Customers
        Queue<Customer> queue = new LinkedList<>();

        queue.add(new Customer("Deepa", Arrays.asList("Milk", "Bread")));
        queue.add(new Customer("Aman", Arrays.asList("Rice", "Milk")));
        queue.add(new Customer("Rajiv", Arrays.asList("Eggs", "Bread")));

        // Process billing
        processQueue(queue, priceMap, stockMap);
    }
}