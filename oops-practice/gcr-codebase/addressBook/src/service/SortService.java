package service;

import model.AddressBook;
import model.Contact;

import java.util.Comparator;
import java.util.List;

public class SortService {

    public void sortByName(AddressBook book){
        List<Contact> list = book.getContacts();
        list.sort(Comparator.comparing(Contact::getFirstName)
                .thenComparing(Contact::getLastName));
    }

    public void sortByCity(AddressBook book){
        book.getContacts().sort(Comparator.comparing(Contact::getCity));
    }

    public void sortByState(AddressBook book){
        book.getContacts().sort(Comparator.comparing(Contact::getState));
    }

    public void sortByZip(AddressBook book){
        book.getContacts().sort(Comparator.comparing(Contact::getZip));
    }
}
