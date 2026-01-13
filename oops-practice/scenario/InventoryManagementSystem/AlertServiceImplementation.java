package InventoryManagementSystem;

public class AlertServiceImplementation implements AlertService {

    private static final int LOW_STOCK_LIMIT = 5;

    @Override
    public void checkLowStock(Product product) {
        if (product.getQuantity() <= LOW_STOCK_LIMIT) {
            System.out.println(
                "⚠ ALERT: Low stock for product " + product.getProductName()
            );
        }
    }
}