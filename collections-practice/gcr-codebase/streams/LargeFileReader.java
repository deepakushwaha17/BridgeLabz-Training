package streams;

import java.io.*;

public class LargeFileReader {

    public static void main(String[] args) {

        String fileName = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\LargeFile.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                // Check if line contains "error" (case insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }

            System.out.println("\nFinished scanning the file.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
