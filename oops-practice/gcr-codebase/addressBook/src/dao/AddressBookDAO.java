package dao;

import model.AddressBook;
import model.Contact;
import java.util.*;

//DAO(Data Access Object) Layer - handles data storage and retrieval
public class AddressBookDAO {

	//UC 6 : maintain dictionary of address book name to Address Book
	static HashMap<String ,AddressBook> addressBookSystem = new HashMap<>();
	
	// CREATE new contact to Address Book
	public void createAddressBook(AddressBook addressBook) {
		addressBookSystem.put(addressBook.getBookName(), addressBook);
	}
	
	// Add contact to book
	public void addContactToBook(String bookName , Contact contact) {
		addressBookSystem.get(bookName).getContacts().add(contact);
	}
	
	// READ conatct from Address Book
	public AddressBook getAddressBook(String bookName) {
		return addressBookSystem.get(bookName);
	}
	
	public boolean doesBookExist(String bookName) {
		return addressBookSystem.containsKey(bookName);
	}
	
	public List<AddressBook> getAllAddressBooks(){
		return new ArrayList<>(addressBookSystem.values());
	}
	
	// UPDATE contact of Address Book
	public void updateContact(String bookName , int index , Contact contact) {
		addressBookSystem.get(bookName).getContacts().set(index, contact);
	}
	
	// DELETE contact from Address Book
	public void deleteContact(String bookName, Contact contact) {
		addressBookSystem.get(bookName).getContacts().remove(contact);
	}
}
