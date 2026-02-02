package reflection;

@Author(name = "Shakespeare")
class Book { 
	String book = "Macbeth";
}

public class AuthorAnnotationUse {

	public static void main(String[] args) {
        Class<Book> cls = Book.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}
