package dao;

import model.Contact;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CSVService implements AddressBookIOService {
    private static final String CSV_FILE_PATH = "D:\\Eclipse-Java-Worksapce\\addressBook\\src\\addressbook.csv";

    @Override
    public void writeData(List<Contact> contacts) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE_PATH))) {
            writer.write("FirstName,LastName,Address,City,State,Zip,Phone,Email");
            writer.newLine();
            for(Contact c: contacts) {
                writer.write(c.toFileString());
                writer.newLine();
            }
            System.out.println("Data successfully written to CSV file.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> readData() {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))) {
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null) {
                Contact c = Contact.fromFileString(line);
                if(c != null) contacts.add(c);
            }
            System.out.println("Data successfully read from CSV file.");
        } catch(IOException e) {
            System.out.println("CSV file not found or empty.");
        }
        return contacts;
    }
}
