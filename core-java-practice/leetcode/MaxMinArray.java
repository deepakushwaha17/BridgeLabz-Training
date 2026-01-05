// Problem no. 414 : Find Maximum and Minimum Element

import java.util.Scanner;

public class MaxMinArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("Max Array Element " + max);
        System.out.println("Min Array Element " + min);
    }
}
