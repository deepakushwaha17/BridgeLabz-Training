package LibraryManagementSystem;

public class Student implements User {
    private String name;
    private ReservationStrategy strategy = new StudentReservation();

    public Student(String name) {
        this.name = name;
    }

    public void showRole() {
        System.out.println(name + " is a Student.");
    }

    public void update(String msg) {
        System.out.println(name + " notified: " + msg);
    }

    public void reserveBook(String bookTitle) {
        strategy.reserveBook(bookTitle, name);
    }
}
