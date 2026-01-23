package collections.set;
import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {

    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // 1️ Display all unique policies
    public void displayAllPolicies(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    // 2️ Policies expiring within next 30 days
    public void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Policy p : treeSet) {
            if (!p.expiryDate.isAfter(next30Days)) {
                System.out.println(p);
            }
        }
    }

    // 3️ Policies by coverage type
    public void policiesByCoverage(String coverage) {
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(coverage)) {
                System.out.println(p);
            }
        }
    }

    // Detect duplicate policy numbers
    public void findDuplicates(List<Policy> policies) {
        Set<Integer> seen = new HashSet<>();
        System.out.println("Duplicate Policies:");
        for (Policy p : policies) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }

    // Performance comparison
    public void performanceTest(Set<Policy> set, String setName) {
        long start, end;

        Policy temp = new Policy(999, "Test User",
                LocalDate.now().plusDays(10), "Health", 5000);

        start = System.nanoTime();
        set.add(temp);
        end = System.nanoTime();
        System.out.println(setName + " Add: " + (end - start) + " ns");

        start = System.nanoTime();
        set.contains(temp);
        end = System.nanoTime();
        System.out.println(setName + " Search: " + (end - start) + " ns");

        start = System.nanoTime();
        set.remove(temp);
        end = System.nanoTime();
        System.out.println(setName + " Remove: " + (end - start) + " ns");
    }

    public static void main(String[] args) {

        InsurancePolicyManager manager = new InsurancePolicyManager();

        Policy p1 = new Policy(101, "John",
                LocalDate.now().plusDays(10), "Health", 12000);
        Policy p2 = new Policy(102, "Alice",
                LocalDate.now().plusDays(40), "Auto", 8000);
        Policy p3 = new Policy(103, "Bob",
                LocalDate.now().plusDays(20), "Home", 15000);
        Policy p4 = new Policy(101, "John Duplicate",
                LocalDate.now().plusDays(15), "Health", 12000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4); // duplicate

        System.out.println("\nAll Policies (LinkedHashSet):");
        manager.displayAllPolicies(manager.linkedHashSet);

        System.out.println("\nPolicies Expiring Soon:");
        manager.policiesExpiringSoon();

        System.out.println("\nHealth Coverage Policies:");
        manager.policiesByCoverage("Health");

        System.out.println("\nDuplicate Detection:");
        manager.findDuplicates(Arrays.asList(p1, p2, p3, p4));

        System.out.println("\nPerformance Comparison:");
        manager.performanceTest(manager.hashSet, "HashSet");
        manager.performanceTest(manager.linkedHashSet, "LinkedHashSet");
        manager.performanceTest(manager.treeSet, "TreeSet");
    }
}



class Policy implements Comparable<Policy> {

    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(int policyNumber, String policyHolderName,
                  LocalDate expiryDate, String coverageType,
                  double premiumAmount) {

        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // TreeSet sorting by expiry date
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // Uniqueness based on policy number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (!(obj instanceof Policy)) {
        	return false;
        }
        Policy p = (Policy) obj;
        return this.policyNumber == p.policyNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(policyNumber);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " +
               expiryDate + " | " + coverageType + " | ₹" + premiumAmount;
    }
}
