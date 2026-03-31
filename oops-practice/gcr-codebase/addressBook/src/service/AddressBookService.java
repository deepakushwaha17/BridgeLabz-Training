package service;

import dao.*;
import model.AddressBook;
import model.Contact;
import java.util.List;

public class AddressBookService {
    private AddressBookDAO addressBookDAO;
    private ContactDAO contactDAO;
    private AddressBookIOService ioService;

    public AddressBookService(AddressBookDAO addressBookDAO, ContactDAO contactDAO) {
        this.addressBookDAO = addressBookDAO;
        this.contactDAO = contactDAO;
    }

    public void createAddressBook(String name) {
        if(addressBookDAO.doesBookExist(name)) {
            System.out.println("Address Book already exists.");
            return;
        }
        AddressBook book = new AddressBook(name);
        addressBookDAO.createAddressBook(book);
        System.out.println("Address Book created successfully.");
    }

    public String addContact(String bookName, Contact contact) {
        if(!addressBookDAO.doesBookExist(bookName)) {
        	return "Address Book not found.";
        }
        AddressBook book = addressBookDAO.getAddressBook(bookName);
        if(book.getContacts().contains(contact)) {
        	return "Duplicate Entry!";
        }
        contactDAO.saveContact(book, contact);
        return "Contact added successfully.";
    }

    public String editContact(String bookName, String firstName, String lastName, Contact newDetails) {
        if(!addressBookDAO.doesBookExist(bookName)) {
        	return "Address Book not found.";
        }
        AddressBook book = addressBookDAO.getAddressBook(bookName);
        List<Contact> list = book.getContacts();
        for(int i=0;i<list.size();i++){
            Contact c = list.get(i);
            if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)){
                contactDAO.updateContact(book, i, newDetails);
                return "Contact updated successfully.";
            }
        }
        return "Contact not found.";
    }

    public String deleteContact(String bookName, String firstName, String lastName) {
        if(!addressBookDAO.doesBookExist(bookName)) {
        	return "Address Book not found.";
        }
        AddressBook book = addressBookDAO.getAddressBook(bookName);
        List<Contact> list = book.getContacts();
        Contact target = null;
        for(Contact c:list){
            if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)){
                target=c; break;
            }
        }
        if(target!=null){
            contactDAO.deleteContact(book, target);
            return "Contact deleted successfully.";
        }
        return "Contact not found.";
    }

    public void setIOService(AddressBookIOService ioService) { this.ioService = ioService; }

    public void writeAddressBook(String bookName){
        if(ioService==null){
        	System.out.println("IO Strategy not set.");
        	return; 
        }
        AddressBook book = addressBookDAO.getAddressBook(bookName);
        if(book!=null) {
        	ioService.writeData(book.getContacts());
        }
        else {
        	System.out.println("Address Book not found.");
        }
    }

    public void readAddressBook(){
        if(ioService==null){ 
        	System.out.println("IO Strategy not set."); 
        	return; 
        }
        List<Contact> contacts = ioService.readData();
        if(contacts.isEmpty()) {
        	System.out.println("No contacts found in the file.");
        }
        else { 
        	System.out.println("--- Contacts from File ---"); 
        	contacts.forEach(System.out::println);
        }
    }
}
