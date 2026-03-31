package presentation;

import dao.*;
import model.AddressBook;
import model.Contact;
import service.*;

import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AddressBookDAO bookDAO = new AddressBookDAO();
        ContactDAO contactDAO = new ContactDAO();
        AddressBookService bookService = new AddressBookService(bookDAO, contactDAO);
        SearchService searchService = new SearchService();
        SortService sortService = new SortService();

        while(true){
            System.out.println("\n==========================================");
            System.out.println("   WELCOME TO ADDRESS BOOK SYSTEM ");
            System.out.println("==========================================");
            System.out.println("----------- MAIN MENU -----------");
            System.out.println("1. Address Book Operations (Create/Add/Edit/Delete)");
            System.out.println("2. Search & View Operations (City/State)");
            System.out.println("3. Analysis Operations (Count by City/State)");
            System.out.println("4. Sorting Operations");
            System.out.println("5. File IO Operations");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch(mainChoice){
                case 1:
                    addressBookMenu(sc, bookDAO, contactDAO, bookService);
                    break;
                case 2:
                    searchMenu(sc, bookDAO, searchService);
                    break;
                case 3:
                    analysisMenu(bookDAO);
                    break;
                case 4:
                    sortingMenu(sc, bookDAO, sortService);
                    break;
                case 5:
                    fileIOMenu(sc, bookService);
                    break;
                case 6:
                    System.out.println("Exiting System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid Option! Try again.");
            }
        }
    }

    private static void addressBookMenu(Scanner sc, AddressBookDAO bookDAO, ContactDAO contactDAO, AddressBookService bookService){
        System.out.println("\n--- ADDRESS BOOK MANAGEMENT ---");
        System.out.println("1. Create New Address Book");
        System.out.println("2. Add Contact");
        System.out.println("3. Edit Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter Choice: ");
        String choice = sc.nextLine();

        switch(choice){
            case "1":
                System.out.print("Enter Unique Name for new Address Book: ");
                String name = sc.nextLine();
                bookService.createAddressBook(name);
                break;
            case "2":
                System.out.print("Enter Address Book Name: ");
                String bookName = sc.nextLine();
                if(!bookDAO.doesBookExist(bookName)){
                    System.out.println("Address Book not found!");
                    break;
                }
                Contact contact = getContactFromUser(sc);
                System.out.println(bookService.addContact(bookName, contact));
                break;
            case "3":
                System.out.print("Enter Address Book Name: ");
                String bookEdit = sc.nextLine();
                System.out.print("Enter First Name of Contact to Edit: ");
                String fNameEdit = sc.nextLine();
                System.out.print("Enter Last Name of Contact to Edit: ");
                String lNameEdit = sc.nextLine();
                Contact newContact = getContactFromUser(sc);
                System.out.println(bookService.editContact(bookEdit, fNameEdit, lNameEdit, newContact));
                break;
            case "4":
                System.out.print("Enter Address Book Name: ");
                String bookDel = sc.nextLine();
                System.out.print("Enter First Name of Contact to Delete: ");
                String fNameDel = sc.nextLine();
                System.out.print("Enter Last Name of Contact to Delete: ");
                String lNameDel = sc.nextLine();
                System.out.println(bookService.deleteContact(bookDel, fNameDel, lNameDel));
                break;
            case "5":
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static Contact getContactFromUser(Scanner sc){
        System.out.print("First Name: "); String fn = sc.nextLine();
        System.out.print("Last Name: "); String ln = sc.nextLine();
        System.out.print("Address: "); String add = sc.nextLine();
        System.out.print("City: "); String city = sc.nextLine();
        System.out.print("State: "); String state = sc.nextLine();
        System.out.print("ZIP: "); String zip = sc.nextLine();
        System.out.print("Phone: "); String phone = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        return new Contact(fn, ln, add, city, state, zip, phone, email);
    }

    private static void searchMenu(Scanner sc, AddressBookDAO bookDAO, SearchService searchService){
        System.out.print("Enter Address Book Name to Search: ");
        String bookName = sc.nextLine();
        if(!bookDAO.doesBookExist(bookName)){
            System.out.println("Address Book not found!");
            return;
        }
        AddressBook book = bookDAO.getAddressBook(bookName);
        System.out.println("Search by: 1. City  2. State");
        int ch = sc.nextInt(); sc.nextLine();
        if(ch==1){
            System.out.print("Enter City: "); String city = sc.nextLine();
            List<Contact> result = searchService.searchByCity(book, city);
            result.forEach(System.out::println);
        } else if(ch==2){
            System.out.print("Enter State: "); String state = sc.nextLine();
            List<Contact> result = searchService.searchByState(book, state);
            result.forEach(System.out::println);
        } else System.out.println("Invalid Option!");
    }

    private static void analysisMenu(AddressBookDAO bookDAO){
        System.out.println("--- Analysis ---");
        for(AddressBook book: bookDAO.getAllAddressBooks()){
            System.out.println("Address Book: "+book.getBookName()+" | Total Contacts: "+book.getContacts().size());
        }
    }

    private static void sortingMenu(Scanner sc, AddressBookDAO bookDAO, SortService sortService){
        System.out.print("Enter Address Book Name to Sort: ");
        String bookName = sc.nextLine();
        if(!bookDAO.doesBookExist(bookName)){ System.out.println("Address Book not found!"); return; }
        AddressBook book = bookDAO.getAddressBook(bookName);
        System.out.println("Sort by: 1. Name 2. City 3. State 4. ZIP");
        int ch = sc.nextInt(); sc.nextLine();
        switch(ch){
            case 1: sortService.sortByName(book); break;
            case 2: sortService.sortByCity(book); break;
            case 3: sortService.sortByState(book); break;
            case 4: sortService.sortByZip(book); break;
            default: System.out.println("Invalid Option!"); return;
        }
        System.out.println("--- Sorted Contacts ---");
        book.getContacts().forEach(System.out::println);
    }

    private static void fileIOMenu(Scanner sc, AddressBookService bookService){
        System.out.println("\n--- FILE IO OPERATIONS ---");
        System.out.println("1. Write to Text File");
        System.out.println("2. Read from Text File");
        System.out.println("3. Write to CSV File");
        System.out.println("4. Read from CSV File");
        System.out.println("5. Back");
        System.out.print("Enter Choice: ");
        int ch = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Address Book Name to Read/Write: ");
        String bookName = sc.nextLine();

        switch(ch){
            case 1:
                bookService.setIOService(new FileIOService());
                bookService.writeAddressBook(bookName);
                break;
            case 2:
                bookService.setIOService(new FileIOService());
                bookService.readAddressBook();
                break;
            case 3:
                bookService.setIOService(new CSVService());
                bookService.writeAddressBook(bookName);
                break;
            case 4:
                bookService.setIOService(new CSVService());
                bookService.readAddressBook();
                break;
            case 5: return;
            default: System.out.println("Invalid Option!");
        }
    }
}
