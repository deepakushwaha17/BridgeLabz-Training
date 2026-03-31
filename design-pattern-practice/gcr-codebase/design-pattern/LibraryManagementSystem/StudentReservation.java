package LibraryManagementSystem;

public class StudentReservation implements ReservationStrategy {
    public void reserveBook(String bookTitle, String userName) {
        System.out.println(userName + " reserved book for 7 days: " + bookTitle);
    }
}
