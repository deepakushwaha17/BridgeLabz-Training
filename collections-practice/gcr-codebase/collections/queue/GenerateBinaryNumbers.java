package collections.queue;

import java.util.*;

public class GenerateBinaryNumbers {
    
    public static void generateBinary(int N) {
        Queue<String> queue = new LinkedList<>();

        // Add first binary number
        queue.add("1");

        // Generate N binary numbers
        for (int i = 0; i < N; i++) {
            String current = queue.remove();
            System.out.print(current + " ");

            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
    
    public static void main(String[] args) {
        int N = 7;
        generateBinary(N);
    }

}
