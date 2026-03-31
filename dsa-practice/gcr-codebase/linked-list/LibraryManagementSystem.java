package dsaLinkedlist;

public class LibraryManagementSystem {
	 public static void main(String[] args) {
		 LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

	    library.addAtBeginning(101, "1984", "George Orwell", "Dystopian", true);
	    library.addAtEnd(102, "Pride and Prejudice", "Jane Austen", "Romance", true);
	    library.addAtEnd(103, "The Alchemist", "Paulo Coelho", "Fiction", false);
	    library.addAtPosition(2, 104, "To Kill a Mockingbird", "Harper Lee", "Classic", true);

	    library.displayForward();
	    library.displayBackward();

	    library.searchByTitle("1984");
	    library.searchByAuthor("Paulo Coelho");

	    library.updateAvailability(103, true);

	    library.removeById(102);
	    library.displayForward();

	    System.out.println("\nTotal books in library: " + library.countBooks());
	 }

}

class BookNode {
    int bookId;
    String title, author, genre;
    boolean isAvailable;
    BookNode next, prev;

    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class LibraryDoublyLinkedList {
    BookNode head, tail;

    // method to Add at beginning
    void addAtBeginning(int id, String title, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(id, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // method to Add at end
    void addAtEnd(int id, String title, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(id, title, author, genre, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // method to Add at specific position
    void addAtPosition(int pos, int id, String title, String author, String genre, boolean isAvailable) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, isAvailable);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
        	temp = temp.next;
        }
           
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, isAvailable);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        else {
            tail = newNode;
        }

        temp.next = newNode;
    }

    // method to Remove book by ID
    void removeById(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }

                System.out.println("Book removed: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found: " + id);
    }

    // method to Search by Title
    void searchByTitle(String title) {
        BookNode temp = head;
        System.out.println("\nSearch results for Title: " + title);
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
            }
            temp = temp.next;
        }
    }

    // method to Search by Author
    void searchByAuthor(String author) {
        BookNode temp = head;
        System.out.println("\nSearch results for Author: " + author);
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
            }
            temp = temp.next;
        }
    }

    // method to Update availability
    void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated for Book ID: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found: " + id);
    }

    // method to Display forward
    void displayForward() {
        BookNode temp = head;
        System.out.println("\nBooks in Library (Forward):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display backward
    void displayBackward() {
        BookNode temp = tail;
        System.out.println("\nBooks in Library (Reverse):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // method to Count total books
    int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // method to Display a single book
    void displayBook(BookNode b) {
        System.out.println(b.bookId + " | " + b.title + " | " + b.author +
                " | " + b.genre + " | " + (b.isAvailable ? "Available" : "Not Available"));
    }
}