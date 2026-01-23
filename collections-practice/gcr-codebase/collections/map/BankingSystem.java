package collections.map;

import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {

        // HashMap – AccountNumber -> Balance
        HashMap<Integer, Integer> accounts = new HashMap<>();
        accounts.put(1001, 50000);
        accounts.put(1002, 20000);
        accounts.put(1003, 75000);

        // TreeMap – sort by balance
        TreeMap<Integer, Integer> balanceSorted = new TreeMap<>();
        accounts.forEach((k, v) -> balanceSorted.put(v, k));

        System.out.println("Accounts sorted by balance:");
        balanceSorted.forEach((k, v) ->
                System.out.println("Account " + v + " : ₹" + k));

        // Queue – withdrawal requests
        Queue<Integer> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add(1001);
        withdrawalQueue.add(1003);

        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            int acc = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account " + acc);
        }
    }
}
