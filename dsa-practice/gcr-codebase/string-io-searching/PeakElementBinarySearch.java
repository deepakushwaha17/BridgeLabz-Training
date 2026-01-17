package dsaProblems;

import java.util.Scanner;

public class PeakElementBinarySearch {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int leftNeighbor = (mid == 0) ? Integer.MIN_VALUE : arr[mid - 1];
            int rightNeighbor = (mid == arr.length - 1) ? Integer.MIN_VALUE : arr[mid + 1];

            if (arr[mid] >= leftNeighbor && arr[mid] >= rightNeighbor) {
                return mid; 
            }

            else if (arr[mid] < leftNeighbor) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return -1; 
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

        int peakIndex = findPeakElement(arr);

        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + arr[peakIndex]);

        input.close();
    }
}
