package dsaProblems;

import java.util.*;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter the dataset size : ");
        int n = input.nextInt(); 
        input.close();
        Random rand = new Random();

        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(n * 10); 
            array[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }

        int target = array[rand.nextInt(n)];

        // Array search
        long startArray = System.nanoTime();
        boolean foundArray = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                foundArray = true;
                break;
            }
        }
        long endArray = System.nanoTime();
        System.out.println("Array search found: " + foundArray + " , Time: " + (endArray - startArray)/1000000.0 + " ms");

        // HashSet search
        long startHashSet = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet search found: " + foundHashSet + " , Time: " + (endHashSet - startHashSet)/1000000.0 + " ms");

        // TreeSet search
        long startTreeSet = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet search found: " + foundTreeSet + " , Time: " + (endTreeSet - startTreeSet)/1000000.0 + " ms");
    }
}
