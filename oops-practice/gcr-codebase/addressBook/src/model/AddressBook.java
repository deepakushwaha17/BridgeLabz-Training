package model;
import java.util.ArrayList;

//Model Layer - Contact POJO Class
//UC 6 :  Each address book has unique name
public class AddressBook {

	private String bookName;
	private ArrayList<Contact> contacts;
	
	public AddressBook(String bookName) {
		this.bookName = bookName;
		this.contacts = new ArrayList<>();
	}
	
	public String getBookName() {
		return bookName;
	}
	
	//UC 5 : collection class to maintain multiple contact person
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
}
