package dao;

import model.AddressBook;
import model.Contact;
import java.util.List;

public class ContactDAO {
    public List<Contact> getContactsFromBook(AddressBook addressBook) {
        return addressBook.getContacts();
    }

    public void saveContact(AddressBook addressBook, Contact contact) {
        addressBook.getContacts().add(contact);
    }

    public void updateContact(AddressBook addressBook, int index, Contact contact) {
        addressBook.getContacts().set(index, contact);
    }

    public void deleteContact(AddressBook addressBook, Contact contact) {
        addressBook.getContacts().remove(contact);
    }
}
