package dsaProblems;

import java.util.Scanner;

public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = input.nextInt();
        input.close();

        long startRec = System.nanoTime();
        fibonacciRecursive(n);
        long endRec = System.nanoTime();
       	System.out.println("Fibonacci Recursive Time: " + (endRec - startRec)/1000000.0 + " ms");
        
        long startIter = System.nanoTime();
        fibonacciIterative(n);
        long endIter = System.nanoTime();
        System.out.println("Fibonacci Iterative Time: " + (endIter - startIter)/1000000.0 + " ms");
    }
}

