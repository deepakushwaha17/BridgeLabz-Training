package BookShelf;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b2 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book b3 = new Book("1984", "George Orwell");
        Book b4 = new Book("Animal Farm", "George Orwell");
        Book b5 = new Book("The Hobbit", "J.R.R. Tolkien"); // duplicate

        // Add books
        library.addBook("Fantasy", b1);
        library.addBook("Fantasy", b2);
        library.addBook("Dystopian", b3);
        library.addBook("Dystopian", b4);
        library.addBook("Fantasy", b5); // duplicate prevention

        library.displayCatalog();

        // Borrow a book
        library.borrowBook("Dystopian", b3);
        library.displayCatalog();

        // Return a book
        library.returnBook("Dystopian", b3);
        library.displayCatalog();

        // Remove a book
        library.removeBook("Fantasy", b2);
        library.displayCatalog();
    }
}