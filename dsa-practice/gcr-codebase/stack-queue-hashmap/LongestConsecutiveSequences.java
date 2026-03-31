package dsaProblems;

import java.util.*;

public class LongestConsecutiveSequences {

    public static int longestSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
        	set.add(num);
        }

        int longest = 0;

        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        System.out.println("Longest sequence length: " + longestSequence(arr));
        
        input.close();

    }
}

