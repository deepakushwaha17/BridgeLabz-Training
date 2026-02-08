package LibraryManagementSystem;

public interface User extends Observer {
    void showRole();
    void reserveBook(String bookTitle);
}
