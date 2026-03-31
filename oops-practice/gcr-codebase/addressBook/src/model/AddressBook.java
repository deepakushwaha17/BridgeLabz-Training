package model;

import java.util.ArrayList;

public class AddressBook {
    private String bookName;
    private ArrayList<Contact> contacts;

    public AddressBook(String bookName) {
        this.bookName = bookName;
        this.contacts = new ArrayList<>();
    }

    public String getBookName() { return bookName; }
    public ArrayList<Contact> getContacts() { return contacts; }
}
