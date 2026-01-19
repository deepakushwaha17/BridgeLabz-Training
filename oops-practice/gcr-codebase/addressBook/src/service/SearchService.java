package service;

import dao.AddressBookDAO;
import model.AddressBook;
import model.Contact;
import java.util.*;

public class SearchService {
    private AddressBookDAO dao;

    public SearchService(AddressBookDAO dao) {
        this.dao = dao;
    }

    //UC 8 : Search by City
    public List<Contact> searchByCity(String city) {
        List<Contact> matchingContacts = new ArrayList<>();
        List<AddressBook> allBooks = dao.getAllAddressBooks();

        // Iterate through every book and every contact
        for (AddressBook book : allBooks) {
            for (Contact c : book.getContacts()) {
                if (c.getCity().equalsIgnoreCase(city)) {
                    matchingContacts.add(c);
                }
            }
        }
        return matchingContacts;
    }

    //UC 8 : Search by State
    public List<Contact> searchByState(String state) {
        List<Contact> matchingContacts = new ArrayList<>();
        List<AddressBook> allBooks = dao.getAllAddressBooks();

        for (AddressBook book : allBooks) {
            for (Contact c : book.getContacts()) {
                if (c.getState().equalsIgnoreCase(state)) {
                    matchingContacts.add(c);
                }
            }
        }
        return matchingContacts;
    }

    //UC 9 : View/Group Persons by City
    public Map<String, List<Contact>> viewPersonsByCity() {
        Map<String, List<Contact>> cityMap = new HashMap<>();
        List<AddressBook> allBooks = dao.getAllAddressBooks();

        for (AddressBook book : allBooks) {
            for (Contact c : book.getContacts()) {
                String city = c.getCity();
                
                // If the key (City) doesn't exist, create a new list for it
                if (!cityMap.containsKey(city)) {
                    cityMap.put(city, new ArrayList<>());
                }
                
                // Add the contact to the list associated with that city
                cityMap.get(city).add(c);
            }
        }
        return cityMap;
    }

    //UC 9 : View/Group Persons by State
    public Map<String, List<Contact>> viewPersonsByState() {
        Map<String, List<Contact>> stateMap = new HashMap<>();
        List<AddressBook> allBooks = dao.getAllAddressBooks();

        for (AddressBook book : allBooks) {
            for (Contact c : book.getContacts()) {
                String state = c.getState();

                // If the key (State) doesn't exist, create a new list for it
                if (!stateMap.containsKey(state)) {
                    stateMap.put(state, new ArrayList<>());
                }

                // Add the contact to the list associated with that state
                stateMap.get(state).add(c);
            }
        }
        return stateMap;
    }
    
    //UC 10: Count Persons contact by city
    public Map<String, Integer> countPersonsByCity() {
        Map<String, Integer> countMap = new HashMap<>();
        for (AddressBook book : dao.getAllAddressBooks()) {
            for (Contact c : book.getContacts()) {
                String city = c.getCity();
                if (countMap.containsKey(city)) {
                    countMap.put(city, countMap.get(city) + 1);
                } else {
                    countMap.put(city, 1);
                }
            }
        }
        return countMap;
    }

    //UC 10: Count Persons contact by state
    public Map<String, Integer> countPersonsByState() {
        Map<String, Integer> countMap = new HashMap<>();
        for (AddressBook book : dao.getAllAddressBooks()) {
            for (Contact c : book.getContacts()) {
                String state = c.getState();
                if (countMap.containsKey(state)) {
                    countMap.put(state, countMap.get(state) + 1);
                } else {
                    countMap.put(state, 1);
                }
            }
        }
        return countMap;
    }
}