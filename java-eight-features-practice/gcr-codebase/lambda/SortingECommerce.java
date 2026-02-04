package lambda;

import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " [Price: " + price + ", Rating: " + rating + ", Discount: " + discount + "%]";
    }
}


public class SortingECommerce {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 25000.0, 4.5, 20.0));
        products.add(new Product("Smartphone", 15000.0, 4.8, 10.0));
        products.add(new Product("Tablet", 12000.0, 4.2, 15.0));

        System.out.println("Original List:");
        products.forEach(System.out::println);

        // Sort by Price (ascending)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("\nSorted by Price:");
        products.forEach(System.out::println);

        // Sort by Rating (descending)
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);

        // Sort by Discount (descending)
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}
