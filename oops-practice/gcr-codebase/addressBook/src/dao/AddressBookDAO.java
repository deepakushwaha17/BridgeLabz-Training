package dao;

import model.AddressBook;
import model.Contact;
import java.util.*;

public class AddressBookDAO {
    static HashMap<String, AddressBook> addressBookSystem = new HashMap<>();

    public void createAddressBook(AddressBook addressBook) {
        addressBookSystem.put(addressBook.getBookName(), addressBook);
    }

    public void addContactToBook(String bookName, Contact contact) {
        addressBookSystem.get(bookName).getContacts().add(contact);
    }

    public AddressBook getAddressBook(String bookName) {
        return addressBookSystem.get(bookName);
    }

    public boolean doesBookExist(String bookName) {
        return addressBookSystem.containsKey(bookName);
    }

    public List<AddressBook> getAllAddressBooks() {
        return new ArrayList<>(addressBookSystem.values());
    }

    public void updateContact(String bookName, int index, Contact contact) {
        addressBookSystem.get(bookName).getContacts().set(index, contact);
    }

    public void deleteContact(String bookName, Contact contact) {
        addressBookSystem.get(bookName).getContacts().remove(contact);
    }
}
