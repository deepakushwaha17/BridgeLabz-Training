package dsaProblems;

import java.util.*;

public class CheckPairSum {

    static void checkPair(int[] arr, int target) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(target - num)) {
                System.out.println("Pair exists");
                return;
            }
            map.put(num, true);
        }
        System.out.println("Pair does not exist");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        System.out.print("Enter target sum: ");
        int target = input.nextInt();

        checkPair(arr, target);
        
        input.close();
    }
}

