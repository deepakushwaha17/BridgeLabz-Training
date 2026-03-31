package dsaProblems;

import java.util.*;

public class TwoSumProblem {

    static void findIndices(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int remainder = target - arr[i];
            if (map.containsKey(remainder)) {
                System.out.println(map.get(remainder) + " " + i);
                return;
            }
            map.put(arr[i], i);
        }
        System.out.println("No solution");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        System.out.print("Enter target: ");
        int target = input.nextInt();

        findIndices(arr, target);
        
        input.close();
    }
}

