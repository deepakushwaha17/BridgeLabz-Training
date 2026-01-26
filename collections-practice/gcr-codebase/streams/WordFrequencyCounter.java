package streams;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String fileName = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\SourceFile.txt"; // your text file
        HashMap<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split line into words using non-word characters as delimiter
                String[] words = line.split("\\W+"); 

                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // case-insensitive
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort words by frequency in descending order
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Display total word count
            int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total words in file: " + totalWords);

            // Display top 5 frequent words
            System.out.println("\nTop 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println((i + 1) + ". " + entry.getKey() + " → " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
