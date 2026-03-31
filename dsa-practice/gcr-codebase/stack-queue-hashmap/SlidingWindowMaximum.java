package dsaProblems;

import java.util.Scanner;
import java.util.ArrayDeque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) {
        	return new int[0];
        }
        
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = input.nextInt();

        int[] maxInWindows = maxSlidingWindow(arr, k);

        System.out.println("Maximum in each sliding window:");
        for (int max : maxInWindows) {
            System.out.print(max + " ");
        }

        input.close();
    }
}