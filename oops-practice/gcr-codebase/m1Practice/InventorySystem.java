package m1Practice;
import java.util.*;

abstract class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void display();

    double getTotalValue() {
        return price * quantity;
    }
}

class Electronics extends Product {
    int warranty; // months

    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    @Override
    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
    }
}

class Clothing extends Product {
    String size;

    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = Integer.parseInt(sc.nextLine());

        List<Product> inventory = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim(); // trim spaces

            if (line.isEmpty()) {
            	continue;
            }
            
            String[] parts = line.split(",\\s*");

            String type = parts[0];
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            int quantity = Integer.parseInt(parts[3]);

            if (type.equalsIgnoreCase("Electronics")) {
                int warranty = Integer.parseInt(parts[4]);
                Product p = new Electronics(name, price, quantity, warranty);
                inventory.add(p);
                System.out.println("Product added to inventory: " + name);
            } else if (type.equalsIgnoreCase("Clothing")) {
                String size = parts[4];
                Product p = new Clothing(name, price, quantity, size);
                inventory.add(p);
                System.out.println("Product added to inventory: " + name);
            }
        }

        // Display inventory
        System.out.println("Inventory:");
        for (Product p : inventory) {
            p.display();
        }

        // Calculate total value
        double totalValue = 0;
        for (Product p : inventory) {
            totalValue += p.getTotalValue();
        }

        System.out.printf("Total value of the inventory: %.2f\n", totalValue);
    }
}