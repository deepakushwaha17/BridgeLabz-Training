/*Phone Contact Organizer
Focus: ArrayList, Strings, Methods, Exception

Scenario:
You are designing a contact organizer for a mobile app.
Requirements:
● Each contact includes Name and Phone Number Handling
● Store contacts in a List<Contact>.
● Allow adding, deleting, and searching.
● If the phone number is not exactly 10 digits, throw InvalidPhoneNumberException.
● Prevent duplicate contacts based on phone number.*/

package classandobject;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneContactOrganizer {

    static ArrayList<Contact> contacts = new ArrayList<>();

    //validate phone number
    static void validatePhoneNumber(String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
        }
    }

    //add contact
    static void addContact(String name, String phone) {
        try {
            validatePhoneNumber(phone);

            for (Contact c : contacts) {
                if (c.getPhoneNumber().equals(phone)) {
                    System.out.println("Duplicate contact not allowed.");
                    return;
                }
            }

            contacts.add(new Contact(name, phone));
            System.out.println("Contact added successfully.");

        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //delete contact
    static void deleteContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                contacts.remove(c);
                System.out.println("Contact deleted.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    //search contact
    static void searchContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Contact Found : " + c);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Phone Contact Organizer ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = input.nextLine();
                    addContact(name, phone);
                    break;

                case 2:
                    System.out.print("Enter phone number to delete: ");
                    deleteContact(input.nextLine());
                    break;

                case 3:
                    System.out.print("Enter phone number to search: ");
                    searchContact(input.nextLine());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}


//custom exception class
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

//contact class to get phone number and name 
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}
