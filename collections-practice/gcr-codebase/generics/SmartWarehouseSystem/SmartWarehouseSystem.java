package generics.SmartWarehouseSystem;

import java.util.Scanner;

public class SmartWarehouseSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        while (true) {
            System.out.println("\n---- Smart Warehouse System ----");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Groceries");
            System.out.println("3. Add Furniture");
            System.out.println("4. Display All Items");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter electronics name: ");
                    String eName = input.nextLine();
                    System.out.print("Enter price: ");
                    double ePrice = input.nextDouble();
                    electronicsStorage.addItem(new Electronics(eName, ePrice));
                    break;

                case 2:
                    System.out.print("Enter grocery name: ");
                    String gName = input.nextLine();
                    System.out.print("Enter price: ");
                    double gPrice = input.nextDouble();
                    groceriesStorage.addItem(new Groceries(gName, gPrice));
                    break;

                case 3:
                    System.out.print("Enter furniture name: ");
                    String fName = input.nextLine();
                    System.out.print("Enter price: ");
                    double fPrice = input.nextDouble();
                    furnitureStorage.addItem(new Furniture(fName, fPrice));
                    break;

                case 4:
                    WarehouseUtil.displayItems(electronicsStorage.getItems());
                    WarehouseUtil.displayItems(groceriesStorage.getItems());
                    WarehouseUtil.displayItems(furnitureStorage.getItems());
                    break;

                case 5:
                    System.out.println("Exiting Smart Warehouse System...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
