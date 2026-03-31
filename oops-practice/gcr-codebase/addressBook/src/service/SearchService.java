package service;

import model.AddressBook;
import model.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public List<Contact> searchByCity(AddressBook book, String city){
        return book.getContacts().stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contact> searchByState(AddressBook book, String state){
        return book.getContacts().stream()
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }
}
