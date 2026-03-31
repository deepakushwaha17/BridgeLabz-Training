package LibraryManagementSystem;

public class FacultyReservation implements ReservationStrategy {
    public void reserveBook(String bookTitle, String userName) {
        System.out.println(userName + " reserved book for 30 days: " + bookTitle);
    }
}
