// Problem no. 26 : Remove Duplicates from Sorted Array

import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of sorted array: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int index = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index++] = arr[i];
            }
        }

        System.out.print("After removing duplicates: ");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
