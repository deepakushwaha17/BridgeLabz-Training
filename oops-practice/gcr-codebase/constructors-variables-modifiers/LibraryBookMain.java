package classandobject;

public class LibraryBookMain {

	public static void main(String[] args) {
		LibraryBook b1 = new LibraryBook("Java Programming", "James Gosling", 450);
		b1.display();
        b1.borrowBook();
        b1.display();

	}
}

class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry, book is not available.");
        }
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author +
            ", Price: ₹" + price + ", Available: " + isAvailable);
    }
}

