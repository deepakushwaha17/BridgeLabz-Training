package collections.map;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {

    // 1. HashMap – quick lookup
    static Map<Integer, Policy> policyMap = new HashMap<>();

    // 2. LinkedHashMap – insertion order
    static Map<Integer, Policy> insertionOrderMap = new LinkedHashMap<>();

    // 3. TreeMap – sorted by expiry date
    static TreeMap<LocalDate, Policy> expiryMap = new TreeMap<>();

    // Add policy
    static void addPolicy(Policy p) {
        policyMap.put(p.policyNumber, p);
        insertionOrderMap.put(p.policyNumber, p);
        expiryMap.put(p.expiryDate, p);
    }

    // Retrieve policy by number
    static Policy getPolicy(int policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Policies expiring in next 30 days
    static void policiesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate next30 = now.plusDays(30);

        for (Policy p : expiryMap.subMap(now, true, next30, true).values()) {
            System.out.println(p);
        }
    }

    // Policies by policyholder
    static void policiesByHolder(String name) {
        for (Policy p : policyMap.values()) {
            if (p.policyHolder.equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    // Remove expired policies
    static void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        policyMap.values().removeIf(p -> p.expiryDate.isBefore(today));
        insertionOrderMap.values().removeIf(p -> p.expiryDate.isBefore(today));
        expiryMap.headMap(today).clear();
    }

    public static void main(String[] args) {
        addPolicy(new Policy(101, "Amit", LocalDate.now().plusDays(10), "Health", 5000));
        addPolicy(new Policy(102, "Neha", LocalDate.now().plusDays(40), "Auto", 3000));
        addPolicy(new Policy(103, "Amit", LocalDate.now().minusDays(2), "Home", 7000));

        System.out.println("Policy 101: " + getPolicy(101));
        System.out.println("\nExpiring Soon:");
        policiesExpiringSoon();

        System.out.println("\nPolicies of Amit:");
        policiesByHolder("Amit");

        removeExpiredPolicies();
    }
}



class Policy {
    int policyNumber;
    String policyHolder;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policy(int policyNumber, String policyHolder, LocalDate expiryDate,
           String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyHolder + " | " + expiryDate +
               " | " + coverageType + " | ₹" + premium;
    }
}
