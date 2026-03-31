package collections.set;

import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        //Create a copy for union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2); // {1, 2, 3, 4, 5}

        //Find intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // {3}

        //Symmetric Difference = Union - Intersection
        union.removeAll(intersection);

        System.out.println("Symmetric Difference: " + union);
    }
}
