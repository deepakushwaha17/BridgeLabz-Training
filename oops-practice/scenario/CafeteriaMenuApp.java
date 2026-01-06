/*Cafeteria Menu App
Focus: Arrays, Methods
● Scenario: The campus cafeteria offers 10 fixed items daily. You need to build a system to display menu items and take orders based on user input.
● Requirements:
● Store items in a string[] array.
● Print the menu with index numbers.
● Allow the user to select an item by index.
● Use methods like DisplayMenu(), GetItemByIndex().*/

package classandobject;

import java.util.Scanner;

public class CafeteriaMenuApp {

    // Fixed menu items
    static String[] menuItems = {"Tea", "Coffee", "Sandwich","Burger", "Momo",
            "Pizza", "Pasta", "Samosa", "Fries","Ice Cream"};

    //display menu
    static void displayMenu() {
        System.out.println("\n--- Cafeteria Menu ---");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i+1 + ". " + menuItems[i]);
        }
    }

    //get item by index
    static String getItemByIndex(int index) {
        if (index >= 1 && index <= menuItems.length) {
            return menuItems[index-1];
        } else {
            return "Invalid item index!";
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        displayMenu();

        System.out.print("\nEnter item index to order: ");
        int choice = input.nextInt();

        String selectedItem = getItemByIndex(choice);

        System.out.println("You ordered: " + selectedItem);

        input.close();
    }
}
