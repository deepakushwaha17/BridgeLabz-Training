package dao;

import model.Contact;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileIOService implements AddressBookIOService {
    private static final String FILE_PATH = "D:\\Eclipse-Java-Worksapce\\addressBook\\src\\addressbook-data.txt";

    @Override
    public void writeData(List<Contact> contacts) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            for(Contact c: contacts) {
                writer.write(c.toFileString());
                writer.newLine();
            }
            System.out.println("Data successfully written to Text File.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> readData() {
        List<Contact> contacts = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for(String line: lines) {
                Contact c = Contact.fromFileString(line);
                if(c != null) contacts.add(c);
            }
            System.out.println("Data successfully read from Text File.");
        } catch(IOException e) {
            System.out.println("Text file not found or empty.");
        }
        return contacts;
    }
}
