package service;

import dao.AddressBookDAO;
import model.Contact;
import java.util.*;
import java.util.stream.Collectors;

public class SortService {
    private AddressBookDAO dao;

    public SortService(AddressBookDAO dao) {
        this.dao = dao;
    }

    // UC 11 & 12 : Sort contacts by name,city,state or zip
    public List<Contact> sortContacts(String bookName, String criteria) {
        if (!dao.doesBookExist(bookName)) return new ArrayList<>();
        
        List<Contact> contacts = dao.getAddressBook(bookName).getContacts();
        Comparator<Contact> comparator = null;

        if (criteria.equalsIgnoreCase("name")) 
            comparator = Comparator.comparing(c -> c.getFirstName() + c.getLastName());
        else if (criteria.equalsIgnoreCase("city")) 
            comparator = Comparator.comparing(Contact::getCity);
        else if (criteria.equalsIgnoreCase("state")) 
            comparator = Comparator.comparing(Contact::getState);
        else if (criteria.equalsIgnoreCase("zip")) 
            comparator = Comparator.comparing(Contact::getZip);

        if (comparator != null) {
            return contacts.stream().sorted(comparator).collect(Collectors.toList());
        }
        return contacts;
    }
}