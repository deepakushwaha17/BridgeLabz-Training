package presentation;

import dao.AddressBookDAO;
import model.Contact;
import service.AddressBookService;
import service.SearchService;
import service.SortService;

import java.util.*;

public class AddressBookMain {
	
    // Scanner and Services are static so they can be used across helper methods
    private static Scanner input = new Scanner(System.in);
    private static AddressBookService crudService;
    private static SearchService searchService;
    private static SortService sortService;

    public static void main(String[] args) {
        // Initialize DAO
        AddressBookDAO dao = new AddressBookDAO();

        // Inject DAO into Services
        crudService = new AddressBookService(dao);
        searchService = new SearchService(dao);
        sortService = new SortService(dao);

        System.out.println("==========================================");
        System.out.println("   WELCOME TO ADDRESS BOOK SYSTEM ");
        System.out.println("==========================================");

        boolean running = true;
        while (running) {
            System.out.println("\n----------- MAIN MENU -----------");
            System.out.println("1. Address Book Operations (Create/Add/Edit/Delete)");
            System.out.println("2. Search & View Operations (City/State)");
            System.out.println("3. Analysis Operations (Count by City/State)");
            System.out.println("4. Sorting Operations");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    handleCRUDOperations();
                    break;
                case 2:
                    handleSearchAndViewOperations();
                    break;
                case 3:
                    handleCountOperations();
                    break;
                case 4:
                    handleSortOperations();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    // SUB-MENU: CRUD Operations
    private static void handleCRUDOperations() {
        System.out.println("\n--- ADDRESS BOOK MANAGEMENT ---");
        System.out.println("1. Create New Address Book");
        System.out.println("2. Add Contact");
        System.out.println("3. Edit Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter Choice: ");
        int choice = getIntInput();

        switch (choice) {
            case 1:
                System.out.print("Enter Unique Name for new Address Book: ");
                String newBook = input.nextLine();
                crudService.createAddressBook(newBook);
                System.out.println("Address Book '" + newBook + "' created (if it didn't exist).");
                break;
            case 2:
                addContactUI();
                break;
            case 3:
                editContactUI();
                break;
            case 4:
                deleteContactUI();
                break;
            case 5:
                return; // Go back
            default:
                System.out.println("Invalid choice.");
        }
    }

    // SUB-MENU: Search & View 
    private static void handleSearchAndViewOperations() {
        System.out.println("\n--- SEARCH & VIEW ---");
        System.out.println("1. Search Person by City");
        System.out.println("2. Search Person by State");
        System.out.println("3. View All Persons Grouped by City");
        System.out.println("4. View All Persons Grouped by State");
        System.out.println("5. Back");
        System.out.print("Enter Choice: ");
        int choice = getIntInput();

        switch (choice) {
            case 1:
                System.out.print("Enter City Name to Search: ");
                List<Contact> cityRes = searchService.searchByCity(input.nextLine());
                displayList(cityRes);
                break;
            case 2:
                System.out.print("Enter State Name to Search: ");
                List<Contact> stateRes = searchService.searchByState(input.nextLine());
                displayList(stateRes);
                break;
            case 3:
                System.out.println("--- Persons Grouped by City ---");
                searchService.viewPersonsByCity().forEach((city, list) -> {
                    System.out.println(">> City: " + city);
                    list.forEach(c -> System.out.println("   " + c));
                });
                break;
            case 4:
                System.out.println("--- Persons Grouped by State ---");
                searchService.viewPersonsByState().forEach((state, list) -> {
                    System.out.println(">> State: " + state);
                    list.forEach(c -> System.out.println("   " + c));
                });
                break;
            case 5: return;
            default: System.out.println("Invalid choice.");
        }
    }

    //SUB-MENU: Count Operations
    private static void handleCountOperations() {
        System.out.println("\n--- ANALYSIS (COUNTS) ---");
        System.out.println("1. Count Persons by City");
        System.out.println("2. Count Persons by State");
        System.out.println("3. Back");
        System.out.print("Enter Choice: ");
        int choice = getIntInput();

        if (choice == 1) {
            System.out.println("Counts per City:");
            searchService.countPersonsByCity().forEach((k, v) -> System.out.println(" - " + k + ": " + v));
        } else if (choice == 2) {
            System.out.println("Counts per State:");
            searchService.countPersonsByState().forEach((k, v) -> System.out.println(" - " + k + ": " + v));
        } else if (choice != 3) {
            System.out.println("Invalid Choice");
        }
    }

    // SUB-MENU: Sorting
    private static void handleSortOperations() {
        System.out.print("\nEnter Address Book Name to Sort: ");
        String bookName = input.nextLine();
        
        System.out.println("Sort by: 1. Name  2. City  3. State  4. Zip");
        System.out.print("Enter Choice: ");
        int choice = getIntInput();
        
        List<Contact> sorted = null;
        switch (choice) {
            case 1: 
            	sorted = sortService.sortContacts(bookName, "name"); 
            	break;
            case 2: 
            	sorted = sortService.sortContacts(bookName, "city"); 
            	break;
            case 3: 
            	sorted = sortService.sortContacts(bookName, "state"); 
            	break;
            case 4: 
            	sorted = sortService.sortContacts(bookName, "zip"); 
            	break;
            default: 
            	System.out.println("Invalid criteria."); 
            	return;
        }

        if (sorted != null && !sorted.isEmpty()) {
            System.out.println("--- Sorted Contacts ---");
            sorted.forEach(System.out::println);
        } else {
            System.out.println("No records found or Book does not exist.");
        }
    }

    // UI HELPERS for Add/Edit/Delete

    private static void addContactUI() {
        System.out.print("Enter Address Book Name: ");
        String book = input.nextLine();

        System.out.println("Enter New Contact Details:");
        Contact c = getContactInput();

        String result = crudService.addContact(book, c);
        System.out.println("Result: " + result);
    }

    private static void editContactUI() {
        System.out.print("Enter Address Book Name: ");
        String book = input.nextLine();
        System.out.print("Enter First Name of person to edit: ");
        String fName = input.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();

        System.out.println("Enter NEW Details for this person:");
        Contact newDetails = getContactInput();
        // Maintain the original name to identify the record
        String result = crudService.editContact(book, fName, lName, newDetails);
        System.out.println("Result: " + result);
    }

    private static void deleteContactUI() {
        System.out.print("Enter Address Book Name: ");
        String book = input.nextLine();
        System.out.print("Enter First Name to delete: ");
        String fName = input.nextLine();
        System.out.print("Enter Last Name to delete: ");
        String lName = input.nextLine();

        String result = crudService.deleteContact(book, fName, lName);
        System.out.println("Result: " + result);
    }

    // UTILITY METHODS

    private static Contact getContactInput() {
        System.out.print("  First Name: "); 
        String fn = input.nextLine();
        System.out.print("  Last Name:  "); 
        String ln = input.nextLine();
        System.out.print("  Address:    "); 
        String addr = input.nextLine();
        System.out.print("  City:       "); 
        String city = input.nextLine();
        System.out.print("  State:      "); 
        String state = input.nextLine();
        System.out.print("  Zip:        "); 
        String zip = input.nextLine();
        System.out.print("  Phone:      "); 
        String ph = input.nextLine();
        System.out.print("  Email:      "); 
        String email = input.nextLine();

        return new Contact(fn, ln, addr, city, state, zip, ph, email);
    }

    private static int getIntInput() {
        try {
            int getInput = input.nextInt();
            input.nextLine(); // Consume newline
            return getInput;
        } catch (InputMismatchException e) {
        	input.nextLine(); // Clear buffer
            return -1; // Return invalid indicator
        }
    }

    private static void displayList(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("  No records found.");
        } else {
            contacts.forEach(System.out::println);
        }
    }
}