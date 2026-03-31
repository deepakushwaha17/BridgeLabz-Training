package LibraryManagementSystem;

public class Guest implements User {
    private String name;

    public Guest(String name) {
        this.name = name;
    }

    public void showRole() {
        System.out.println(name + " is a Guest.");
    }

    public void update(String msg) {
        System.out.println(name + " notified: " + msg);
    }

    public void reserveBook(String bookTitle) {
        System.out.println("Guest cannot reserve books.");
    }
}
