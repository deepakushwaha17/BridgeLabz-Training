package inheritance;

public class LibraryManagement {

	public static void main(String[] args) {
		Author myAuth = new Author("Wings of Fire",1999 , "APJ Abdul Kalam",
				"Kalam's life story, focusing on his rise as a scientist and his vision for India.");
		
		myAuth.displayInfo();
	}

}

//Superclass
class Book{
	
	String title;
	int publicationYear;
	
	Book(String title, int publicationYear){
		this.title = title;
		this.publicationYear = publicationYear;
	}
}

//Subclass
class Author extends Book{
	
	String name;
	String bio;
	
	Author(String title , int publicationYear , String name , String bio){
		super(title,publicationYear);
		this.name = name;
		this.bio = bio;
	}
	
	void displayInfo() {
		System.out.println("Book Title : " +title);
		System.out.println("Book PublicationYear : "+publicationYear);
		System.out.println("Author name : " +name);
		System.out.println("Book Bio : " +bio);
	}
}