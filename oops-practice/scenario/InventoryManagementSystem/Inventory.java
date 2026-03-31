package InventoryManagementSystem;

public class Inventory {

    private Product[] products;
    private int count;
    private static final int MAX_PRODUCTS = 5;

    public Inventory() {
        products = new Product[MAX_PRODUCTS];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < MAX_PRODUCTS) {
            products[count++] = product;
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Inventory full!");
        }
    }

    public Product searchProduct(int productId) {
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId() == productId) {
                return products[i];
            }
        }
        return null;
    }

    public void updateStock(int productId, int quantity) throws OutOfStockException {
        Product product = searchProduct(productId);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        if (quantity < 0 && product.getQuantity() + quantity < 0) {
            throw new OutOfStockException("Stock cannot go below zero!");
        }

        product.setQuantity(product.getQuantity() + quantity);
        System.out.println("Stock updated successfully!");
    }

    public void displayProducts() {
        if (count == 0) {
            System.out.println("No products in inventory.");
            return;
        }

        System.out.println("\nID | Name | Quantity");
        for (int i = 0; i < count; i++) {
            products[i].display();
        }
    }
}