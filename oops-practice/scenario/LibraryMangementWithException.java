/**/
package classandobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryMangementWithException {

    //array to store book details
    static Book[] books;

    //list to store checked out books
    static List<Book> checkedOutBooks = new ArrayList<>();

    //display all books
    static void displayBooks(Book[] books) {
        System.out.println("\nLibrary Books:");
        System.out.printf("%-35s %-20s %-10s\n", "Title", "Author", "Status");
        System.out.println("---------------------------------------------------------");
        for (Book b : books) {
            String status = b.isAvailable ? "Available" : "Checked Out";
            System.out.printf("%-35s %-20s %-10s\n", b.title, b.author, status);
        }
    }

    //search books by partial title
    static void searchBooks(Book[] books, String keyword) {
        System.out.println("\nSearch results for: \"" + keyword + "\"");
        boolean found = false;
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                String status = b.isAvailable ? "Available" : "Checked Out";
                System.out.printf("%-35s %-20s %-10s\n", b.title, b.author, status);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the given keyword.");
        }
    }

    //checkout book
    static void checkoutBook(Book[] books, String title) throws BookNotAvailableException {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                found = true;
                if (b.isAvailable) {
                    b.isAvailable = false;
                    checkedOutBooks.add(b);
                    System.out.println("Book \"" + b.title + "\" checked out successfully!");
                } else {
                    throw new BookNotAvailableException("Book \"" + b.title + "\" is already checked out!");
                }
            }
        }
        if (!found) {
            System.out.println("Book not found in library.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //initialize book array
        books = new Book[]{
                new Book("The Alchemist", "Paulo Coelho"),
                new Book("Harry Potter and Sorcerer's Stone", "J.K. Rowling"),
                new Book("Think and Grow Rich", "Napoleon Hill"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("To Kill a Mockingbird", "Harper Lee")
        };

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display all books");
            System.out.println("2. Search books by title");
            System.out.println("3. Checkout a book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayBooks(books);
                    break;

                case 2:
                    System.out.print("Enter keyword to search: ");
                    String keyword = input.nextLine();
                    searchBooks(books, keyword);
                    break;

                case 3:
                    System.out.print("Enter book title to checkout: ");
                    String title = input.nextLine();
                    try {
                        checkoutBook(books, title);
                    } catch (BookNotAvailableException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting library system...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        input.close();
    }
}


//custom exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

//Book class
class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // All books start as available
    }
}
