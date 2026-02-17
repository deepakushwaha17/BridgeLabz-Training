package dao;

import model.Contact;
import java.util.List;

public interface AddressBookIOService {
    List<Contact> readData();
    void writeData(List<Contact> contacts);
}
