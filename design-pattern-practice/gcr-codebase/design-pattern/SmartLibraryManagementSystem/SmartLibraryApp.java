package SmartLibraryManagementSystem;

public class SmartLibraryApp {

	public static void main(String[] args) {
		// Singleton Pattern
		LibraryCatalog catalog = LibraryCatalog.getInstance();
		
		// Factory Pattern
		User student = UserFactory.createUser("Student", "Deepa");
		User faculty = UserFactory.createUser("Faculty", "Prof. Sahil");
		User librarian = UserFactory.createUser("Librarian", "Amit");
		Librarian lib = (Librarian) librarian;
		
		// Observer Pattern
		catalog.addObserver(student);
		catalog.addObserver(faculty);
		catalog.addObserver(librarian);
		
		// Show roles and privileges
		student.showRole();
		System.out.println("Borrow limit: " + student.getBorrowLimit() + " days\n");
		faculty.showRole();
		System.out.println("Borrow limit: " + faculty.getBorrowLimit() + " days\n");
		librarian.showRole();
		//System.out.println("Borrow limit: " + librarian.getBorrowLimit() + " days\n");
		
		// Builder Pattern
		Book book1 = new Book.BookBuilder("Design Patterns")
					.author("GoF").edition("1st")
					.genre("Non-Fiction").subGenre("Software Engineering")
					.publisher("Addison-Wesley").build();
		
		// Adding book		
		lib.addBookToCatalog(book1);
	}

}
