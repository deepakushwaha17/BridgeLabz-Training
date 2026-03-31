package classandobject;

public class BookDetails {

	public static void main(String[] args) {
		Book book1 = new Book("2States" , "Chetan Bhagat" , 500);
		book1.displayDetails();
		Book book2 = new Book("Wings Of Fire" , "Abdul Kalam APJ" , 500);
		book2.displayDetails();

	}

}

class Book{
	private String title;
	private String author;
	private int price;
	
	public Book(String title , String author , int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public void displayDetails() {
		System.out.println("Title of the book : "+title);
		System.out.println("Author of the book : "+author);
		System.out.println("Price of the book : "+price);		
	}
}
