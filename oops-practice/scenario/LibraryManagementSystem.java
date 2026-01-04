/*Library Management System – Book Search and Checkout
Scenario: You’re designing a system for a small library to manage books and track checkouts.
Problem Requirements:
● Store book details (title, author, status) in a Array.
● Allow searching by partial title using String operations.
● Store book data in an Array.
● Use methods for searching, displaying, and updating book status (checked out or available).*/

package classandobject;

import java.util.Scanner;

public class LibraryManagementSystem {

    // Display all books
    public static void displayBooks(String[] titles, String[] authors, boolean[] isAvailable) {
        System.out.println("\nLibrary Books:");
        for (int i = 0; i < titles.length; i++) {
            System.out.println((i + 1) + ". " + titles[i] + " by " + authors[i]
                    + " - " + (isAvailable[i] ? "Available" : "Checked Out"));
        }
    }

    // Search book by partial title
    public static void searchBook(String[] titles, String[] authors, boolean[] isAvailable, String keyword) {
        boolean found = false;
        System.out.println("\nSearch Results:");
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println((i + 1) + ". " + titles[i] + " by " + authors[i]
                        + " - " + (isAvailable[i] ? "Available" : "Checked Out"));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with given title.");
        }
    }

    // Checkout or return book
    public static void updateBookStatus(boolean[] isAvailable, int index) {
        if (index < 0 || index >= isAvailable.length) {
            System.out.println("Invalid book number.");
            return;
        }

        if (isAvailable[index]) {
            isAvailable[index] = false;
            System.out.println("Book successfully checked out.");
        } else {
            isAvailable[index] = true;
            System.out.println("Book successfully returned.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Book data stored in arrays
        String[] titles = {"Java Programming","Data Structures",
                "Operating Systems","Database Management"};

        String[] authors = {"James Gosling","Mark Weiss",
                "Abraham Silberschatz","Raghu Ramakrishnan"};

        boolean[] isAvailable = {true, true, true, true};

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display all books");
            System.out.println("2. Search book by title");
            System.out.println("3. Checkout / Return book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayBooks(titles, authors, isAvailable);
                    break;

                case 2:
                    System.out.print("Enter partial title to search: ");
                    String keyword = input.nextLine();
                    searchBook(titles, authors, isAvailable, keyword);
                    break;

                case 3:
                    displayBooks(titles, authors, isAvailable);
                    System.out.print("Enter book number: ");
                    int bookNo = input.nextInt();
                    updateBookStatus(isAvailable, bookNo - 1);
                    break;

                case 4:
                    System.out.println("Exiting Library System...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        input.close();
    }
}
