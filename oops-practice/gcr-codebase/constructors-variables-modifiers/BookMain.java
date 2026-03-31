package classandobject;

public class BookMain {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.display();
		Book book2 = new Book("Macbeth","William Shakespeare",400.0);
		book2.display();
	}

}

class Book{
	String title;
	String author;
	double price;
	
	Book(){
		title = "Wings of fire";
		author = "APJ Abdul Kalam";
		price = 500.0;
	}
	
	public Book(String title , String author , double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public void display() {
		System.out.println("Title : " +title);
		System.out.println("Author : " +author);
		System.out.println("Price : " +price);
		System.out.println("------------------");
	}
}