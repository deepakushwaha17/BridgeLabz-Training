package dsaProblems;

import java.util.Arrays;
import java.util.Scanner;

public class LinearBinaryChallenge {

    // Linear Search to find first missing positive integer
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n) {
                arr[val - 1] = -Math.abs(arr[val - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1; 
            }
        }

        return n + 1;
    }

    // Binary Search to find index of target in sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int missing = firstMissingPositive(Arrays.copyOf(arr, n));
        System.out.println("First Missing Positive Integer: " + missing);

        System.out.print("Enter the target value to search: ");
        int target = input.nextInt();

        Arrays.sort(arr);
        int targetIndex = binarySearch(arr, target);

        if (targetIndex != -1) {
            System.out.println("Target " + target + " found at index (in sorted array): " + targetIndex);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }

        input.close();
    }
}
