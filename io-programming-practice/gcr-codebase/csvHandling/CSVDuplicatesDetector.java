package csvHandling;

import java.io.*;
import java.util.*;

public class CSVDuplicatesDetector {

    public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\mergeStudents.csv";
        Set<String> ids = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String header = br.readLine(); 
            System.out.println("Header: " + header);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();

                if (!ids.add(id)) {
                    duplicates.add(line);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records:");
                duplicates.forEach(System.out::println);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

