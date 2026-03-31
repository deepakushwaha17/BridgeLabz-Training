package oopsPillars;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book("B001", "Java Programming", "Author A");
        items[1] = new Magazine("M001", "Time Magazine", "Author B");
        items[2] = new DVD("D001", "Inception", "Christopher Nolan");

        //display details and loan duration
        for(LibraryItem item : items) {
            item.getItemDetails();

            //reserve item if available
            if(item instanceof Reservable) {
                Reservable resItem = (Reservable) item;
                if(resItem.checkAvailability()) {
                    resItem.reserveItem("Deepa"); // Example borrower
                } else {
                    System.out.println("Item is not available for reservation.");
                }
            }

        }
    }
}


//abstract class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    //public getter for attributes
    public String getItemId() {
    	return itemId; 
    }
    public String getTitle() { 
    	return title; 
    }
    public String getAuthor() {
    	return author; 
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days

    // Concrete method
    public void getItemDetails() {
        System.out.println("\nItem ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

//interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

//subclasses
class Book extends LibraryItem implements Reservable {
    boolean isAvailable;
    String borrowerName;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(isAvailable) {
            this.borrowerName = borrowerName;
            this.isAvailable = false;
            System.out.println("Book reserved by: " + borrowerName);
        } else {
            System.out.println("Book already reserved!");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {
	boolean isAvailable;
    String borrowerName;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(isAvailable) {
            this.borrowerName = borrowerName;
            this.isAvailable = false;
            System.out.println("Magazine reserved by: " + borrowerName);
        } else {
            System.out.println("Magazine already reserved!");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
	boolean isAvailable;
    String borrowerName;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(isAvailable) {
            this.borrowerName = borrowerName;
            this.isAvailable = false;
            System.out.println("DVD reserved by: " + borrowerName);
        } else {
            System.out.println("DVD already reserved!");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}
