package dsaLinkedlist;

public class MovieManagementSystem {

	public static void main(String[] args) {

        MovieLinkedList list = new MovieLinkedList();

        list.addAtBeginning("3 Idiots", "Rajkumar Hirani", 2009, 9.1);
        list.addAtEnd("Dangal", "Nitesh Tiwari", 2016, 8.8);
        list.addAtEnd("PK", "Rajkumar Hirani", 2014, 8.1);
        list.addAtPosition(2, "Lagaan", "Ashutosh Gowariker", 2001, 8.2);
        list.addAtEnd("Bajrangi Bhaijaan", "Kabir Khan", 2015, 8.0);

        list.displayForward();
        list.displayBackward();

        list.searchByDirector("Rajkumar Hirani");
        list.updateRating("PK", 8.5);
        list.removeByTitle("Lagaan");

        list.displayForward();
    }
}

class MovieNode{
	String title;
	String director;
	int yearOfRelease;
	double rating;
	MovieNode next , prev;
	
	MovieNode(String title , String director,int yearOfRelease , double rating ){
		this.title = title;
		this.director = director;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
		this.next = null;
		this.prev = null;
	}
}

class MovieLinkedList {
	MovieNode head , tail;
	
	// method to add at beginning
	void addAtBeginning(String title , String director,int yearOfRelease , double rating ) {
		MovieNode newNode = new MovieNode(title,director,yearOfRelease,rating);
		if(head == null) {
			head = tail = newNode;
		}else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}		
	}
	
	// method to add at end
	void addAtEnd(String title , String director,int yearOfRelease , double rating ) {
		MovieNode newNode = new MovieNode(title,director,yearOfRelease,rating);
		if(tail == null) {
			head = tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	// method to add at specific position
	void addAtPosition(int position , String title , String director,int yearOfRelease , double rating ) {
		if(position == 1) {
			addAtBeginning(title , director , yearOfRelease , rating);
			return;
		}
		
		MovieNode newNode = new MovieNode(title , director , yearOfRelease , rating);
		MovieNode temp = head;
		for(int i = 1; i < position-1 && temp != null ; i++) {
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("Invalid position!");
			return;
		}
		
		newNode.next = temp.next;
		newNode.prev = temp;
		if(temp.next != null) {
			temp.next.prev = newNode;
		}else {
			tail = newNode;
		}
		temp.next = newNode;
		
	}
	
	// method to remove by title
	void removeByTitle(String title) {
		MovieNode temp = head;
		while(temp != null) {
			if(temp.title.equalsIgnoreCase(title)) {
				if(temp.prev != null) {
					temp.prev.next = temp.next;
				}else {
					head = temp.next;
				}
				
				if(temp.next != null) {
					temp.next.prev = temp.prev;
				}else {
					tail = temp.prev;
				}
				
				System.out.println("Movie removed successfully.");
				return;
			}
			
			temp = temp.next;
		}
		System.out.println("Movie not found.");
	}
	
	// method to search by director
	void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.yearOfRelease + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by this director.");
    }

    // method to search by rating
	void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.yearOfRelease + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with this rating.");
    }
	

    // method to update Rating by title
    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
    
    // method to display all movies forward
    void displayForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode temp = head;
        System.out.println("\nMovies (Forward):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.yearOfRelease + " | " + temp.rating);
            temp = temp.next;
        }
    }
    
    // method to display all movies backward
    void displayBackward() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode temp = tail;
        System.out.println("\nMovies (Backward):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.yearOfRelease + " | " + temp.rating);
            temp = temp.prev;
        }
    }
  
}