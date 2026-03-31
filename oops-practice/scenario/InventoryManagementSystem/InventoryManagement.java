package InventoryManagementSystem;

import java.util.Scanner;

public class InventoryManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();
        AlertService alertService = new AlertServiceImplementation();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n---- INVENTORY MANAGEMENT SYSTEM ----");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. View Products");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Initial Quantity: ");
                    int qty = input.nextInt();

                    Product product = new Product(id, name, qty);
                    inventory.addProduct(product);
                    alertService.checkLowStock(product);
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int pid = input.nextInt();

                    System.out.print("Enter Quantity to Add/Remove: ");
                    int updateQty = input.nextInt();

                    try {
                        inventory.updateStock(pid, updateQty);
                        Product p = inventory.searchProduct(pid);
                        if (p != null) {
                            alertService.checkLowStock(p);
                        }
                    } catch (OutOfStockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    inventory.displayProducts();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting Inventory System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}
