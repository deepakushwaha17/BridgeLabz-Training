package BookShelf;

import java.util.*;

public class Library {
    private Map<String, LinkedList<Book>> catalog; // genre → list of books
    private Map<String, HashSet<Book>> genreSet;   // optional: prevent duplicates

    public Library() {
        catalog = new HashMap<>();
        genreSet = new HashMap<>();
    }

    // Add book to library
    public void addBook(String genre, Book book) {
        catalog.putIfAbsent(genre, new LinkedList<>());
        genreSet.putIfAbsent(genre, new HashSet<>());

        // prevent duplicate
        if (!genreSet.get(genre).contains(book)) {
            catalog.get(genre).add(book);
            genreSet.get(genre).add(book);
            System.out.println(book + " added to genre: " + genre);
        } else {
            System.out.println(book + " already exists in genre: " + genre);
        }
    }

    // Remove book from library 
    public void removeBook(String genre, Book book) {
        if (!catalog.containsKey(genre)) {
            System.out.println("Genre " + genre + " not found.");
            return;
        }

        if (catalog.get(genre).remove(book)) {
            genreSet.get(genre).remove(book);
            System.out.println(book + " removed from genre: " + genre);
        } else {
            System.out.println(book + " not found in genre: " + genre);
        }
    }

    // Borrow book (removes from catalog)
    public void borrowBook(String genre, Book book) {
        removeBook(genre, book);
    }

    // Return book (adds back to catalog)
    public void returnBook(String genre, Book book) {
        addBook(genre, book);
    }

    // Display library state
    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\n====== Library Catalog =======");
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            LinkedList<Book> books = catalog.get(genre);
            if (books.isEmpty()) {
                System.out.println("  No books available.");
            } else {
                for (Book b : books) {
                    System.out.println("  - " + b);
                }
            }
        }
        System.out.println("================================\n");
    }
}