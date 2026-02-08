package LibraryManagementSystem;

import java.util.*;

public class LibraryCatalog {
    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private Logger logger = Logger.getInstance();

    private LibraryCatalog() {}

    public static synchronized LibraryCatalog getInstance() {
        if (instance == null)
            instance = new LibraryCatalog();
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        logger.log("Book added: " + book.getTitle());
        notifyObservers(book.getTitle());
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    private void notifyObservers(String bookTitle) {
        for (Observer o : observers) {
            o.update("New book available: " + bookTitle);
        }
    }
}
