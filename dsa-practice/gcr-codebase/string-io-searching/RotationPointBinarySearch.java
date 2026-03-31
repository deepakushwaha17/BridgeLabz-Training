package dsaProblems;

import java.util.Scanner;

public class RotationPointBinarySearch {
	
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        if (arr[left] <= arr[right]) {
            return left;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int rotationIndex = findRotationPoint(arr);

        System.out.println("Rotation Point Index: " + rotationIndex);
        System.out.println("Smallest Element: " + arr[rotationIndex]);

        input.close();
    }
}

