package dsaLinkedlist;

public class OnlineTicketReservationSystem {
	public static void main(String[] args) {

	    TicketReservationSystem system = new TicketReservationSystem();

	    system.addTicket(101, "Amit", "RRR", "A1", "10:00 AM");
	    system.addTicket(102, "Priya", "KGF 2", "B3", "10:15 AM");
	    system.addTicket(103, "Rohan", "RRR", "A2", "10:30 AM");
	    system.addTicket(104, "Sneha", "Pushpa", "C1", "10:45 AM");
	    system.addTicket(105, "Vikram", "KGF 2", "B4", "11:00 AM");

	    System.out.println("All Booked Tickets:");
	    system.displayTickets();

	    System.out.println("\nSearch by Customer Name: Priya");
	    system.searchByCustomer("Priya");

	    System.out.println("\nSearch by Movie Name: RRR");
	    system.searchByMovie("RRR");

	    System.out.println("\nRemoving Ticket ID 103 (Rohan)");
	    system.removeTicket(103);

	    System.out.println("\nTickets after removal:");
	    system.displayTickets();

	    System.out.println("\nTotal Booked Tickets: " + system.totalTickets());
	}


}

class TicketNode {
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    TicketNode head;

    // method to Add ticket at end
    void addTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            TicketNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Ticket booked: " + id + " for " + customer);
    }

    // method to Remove ticket by ID
    void removeTicket(int id) {
        if (head == null) {
        	return;
        }

        TicketNode temp = head, prev = null;
        do {
            if (temp.ticketId == id) {
                if (prev != null) {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next; 
                } else { 
                	// removing head
                    TicketNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                System.out.println("Ticket removed: " + id);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket ID " + id + " not found.");
    }

    // method to Display all tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        do {
            System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName +
                    " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // method to Search by Customer Name
    void searchByCustomer(String name) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName +
                        " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
        	System.out.println("No tickets found for " + name);
        }
    }

    // method to Search by Movie Name
    void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName +
                        " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
        	System.out.println("No tickets found for movie " + movie);
        }
    }

    // method to Total booked tickets
    int totalTickets() {
        if (head == null) {
        	return 0;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

