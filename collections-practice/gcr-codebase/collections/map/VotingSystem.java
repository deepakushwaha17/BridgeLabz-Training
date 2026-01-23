package collections.map;

import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {

        // HashMap – store votes
        HashMap<String, Integer> votes = new HashMap<>();

        votes.put("Alice", 120);
        votes.put("Bob", 95);
        votes.put("Charlie", 150);

        // LinkedHashMap – order of voting
        LinkedHashMap<String, Integer> votingOrder = new LinkedHashMap<>(votes);

        // TreeMap – sorted result
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votes);

        System.out.println("Voting Order:");
        votingOrder.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nSorted Results:");
        sortedResults.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
