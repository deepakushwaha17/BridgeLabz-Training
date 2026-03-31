package LibraryManagementSystem;

// Strategy Pattern – Book Reservation
public interface ReservationStrategy {
    void reserveBook(String bookTitle, String userName);
}
