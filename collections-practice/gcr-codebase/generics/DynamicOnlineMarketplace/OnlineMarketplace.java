package generics.DynamicOnlineMarketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineMarketplace {
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Product<?>> catalog = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Online Marketplace System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Clothing");
            System.out.println("3. Add Gadget");
            System.out.println("4. Display All Products");
            System.out.println("5. Apply Discount");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Name: ");
                    String bookName = input.nextLine();
                    System.out.print("Enter Price: ");
                    double bookPrice = input.nextDouble();
                    catalog.add(new Product<>(bookName, bookPrice, new Book()));
                    System.out.println("Book added to catalog.");
                    break;

                case 2:
                    System.out.print("Enter Clothing Name: ");
                    String clothName = input.nextLine();
                    System.out.print("Enter Price: ");
                    double clothPrice = input.nextDouble();
                    catalog.add(new Product<>(clothName, clothPrice, new Clothing()));
                    System.out.println("Clothing added to catalog.");
                    break;

                case 3:
                    System.out.print("Enter Gadget Name: ");
                    String gadgetName = input.nextLine();
                    System.out.print("Enter Price: ");
                    double gadgetPrice = input.nextDouble();
                    catalog.add(new Product<>(gadgetName, gadgetPrice, new Gadget()));
                    System.out.println("Gadget added to catalog.");
                    break;

                case 4:
                    System.out.println("\n--- Product Catalog ---");
                    if(catalog.isEmpty()) {
                    	System.out.println("No product in catalog.");
                    }else {
	                    for (Product<?> p : catalog) {
	                        System.out.println(p.getDetails());
	                    }
                    }
                    System.out.println("-------------------------");
                    break;

                case 5:
                    System.out.print("Enter product name for discount: ");
                    String pname = input.nextLine();
                    System.out.print("Enter discount percentage: ");
                    double percentage = input.nextDouble();

                    boolean found = false;
                    for (Product<?> p : catalog) {
                        if (p.getName().equalsIgnoreCase(pname)) {
                            MarketplaceUtil.applyDiscount(p, percentage);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Marketplace...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}