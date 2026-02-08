package LibraryManagementSystem;

public class Faculty implements User {
    private String name;
    private ReservationStrategy strategy = new FacultyReservation();

    public Faculty(String name) {
        this.name = name;
    }

    public void showRole() {
        System.out.println(name + " is a Faculty.");
    }

    public void update(String msg) {
        System.out.println(name + " notified: " + msg);
    }

    public void reserveBook(String bookTitle) {
        strategy.reserveBook(bookTitle, name);
    }
}
