package classandobject;

public class Book {
	
	// static variable shared across all books
	static String libraryName = "Egmore Library"; 
	String title , author;
	final String isbn;
	
	// this keyword to initialize the instance variable
	public Book(String title , String author , String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;// final variable assigned only once
	}
	
	//static method
	public static void displayLibraryName() {
		System.out.println("Library Name : " +libraryName);
	}
	
	public void displayDetails() {
		// using instanceof to verify object of Book class
		if(this instanceof Book) {
			System.out.println("Title : "+ title);
			System.out.println("Author : "+ author);
			System.out.println("ISBN : "+ isbn);
		}
		else {
			System.out.println("Invalid Book instance!");
		}
	}
	
	public static void main(String[] args) {
		Book book1  = new Book("Effective Java" , "Joshua Bloch" , "978-0134685991");
		displayLibraryName();
		book1.displayDetails();
	}
}
