package classandobject;

public class BookLibrarySystem {

	public static void main(String[] args) {
		BookLibrary b1 = new BookLibrary("978-0135166307", "Java Programming", "James Gosling");
        b1.displayBook();

        // Update author using setter
        b1.setAuthor("Joshua Bloch");
        System.out.println("Updated Author: " + b1.getAuthor());

        EBook eb1 = new EBook("978-0321356680", "Effective Java", "Joshua Bloch", 5.6);
        eb1.displayEBook();

	}

}

class BookLibrary {

	public String ISBN;
	protected String title;
	private String author;

	BookLibrary(String ISBN, String title, String author) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}

	// Public getter for private author
	public String getAuthor() {
		return author;
	}

	// Public setter for private author
	public void setAuthor(String author) {
		this.author = author;
	}

	// Display book details
	public void displayBook() {
		System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + author);
	}
}


//Subclass to demonstrate access to public and protected members
class EBook extends BookLibrary {

	double fileSize; 

	EBook(String ISBN, String title, String author, double fileSize) {
		super(ISBN, title, author);
		this.fileSize = fileSize;
	}

	void displayEBook() {
		// Can access public and protected members directly
		System.out.println( "ISBN: " + ISBN + ", Title: " + title + ", Author: " + getAuthor() +  ", File Size: " + fileSize + "MB");
	}
}
