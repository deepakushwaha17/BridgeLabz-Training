package collections.map;

import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String text = "Hello world, hello Java!";

        Map<String, Integer> freqMap = new HashMap<>();

        // Normalize text
        text = text.toLowerCase().replaceAll("[^a-z ]", "");

        String[] words = text.split("\\s+");

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(freqMap);
    }
}
