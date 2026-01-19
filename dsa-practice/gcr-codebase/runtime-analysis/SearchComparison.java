package dsaProblems;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchComparison {

    public static int linearSearch(int[] data , int target) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] data , int target) {
        int low = 0, high = data.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(data[mid] == target) {
                return mid;
            } else if(data[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter the array size : ");
        int n = input.nextInt();
        
        int[] data = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            data[i] = rand.nextInt(n*10);
        }

        int target = data[rand.nextInt(n)];

        long startLinear = System.nanoTime();
        linearSearch(data,target);
        long endLinear = System.nanoTime();
        
        Arrays.sort(data);

        long startBinary = System.nanoTime();
        binarySearch(data,target);
        long endBinary = System.nanoTime();
        
        System.out.println("Dataset : "+ n);
        System.out.println("Linear Search : "+(endLinear-startLinear)/1000000.0 +" ms");
        System.out.println("Binary Search : "+(endBinary-startBinary)/1000000.0 +" ms");
        input.close();
    }
}
