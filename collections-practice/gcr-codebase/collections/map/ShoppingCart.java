package collections.map;

import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {

        // HashMap – product prices
        HashMap<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Laptop", 60000);
        priceMap.put("Mouse", 800);
        priceMap.put("Keyboard", 1500);

        // LinkedHashMap – order added
        LinkedHashMap<String, Integer> cartOrder = new LinkedHashMap<>(priceMap);

        // TreeMap – sorted by price
        TreeMap<Integer, String> sortedByPrice = new TreeMap<>();
        priceMap.forEach((k, v) -> sortedByPrice.put(v, k));

        System.out.println("Cart Order:");
        cartOrder.forEach((k, v) -> System.out.println(k + " : ₹" + v));

        System.out.println("\nSorted by Price:");
        sortedByPrice.forEach((k, v) -> System.out.println(v + " : ₹" + k));
    }
}
