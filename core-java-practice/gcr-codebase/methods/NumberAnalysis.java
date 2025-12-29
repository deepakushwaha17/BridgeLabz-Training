/*Write a program to take user input for 5 numbers and check whether a number is positive or negative.
 Further for positive numbers check if the number is even or odd. Finally compare the first and last 
 elements of the array and display if they are equal, greater, or less */
 
import java.util.Scanner;

public class NumberAnalysis {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Returns 1 if num1 > num2, 0 if equal, -1 if num1 < num2
    public static int compare(int num1, int num2) {
        if (num1 > num2){
            return 1;
        } else if (num1 == num2){ 
            return 0;
        } else{ 
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\nAnalysis of numbers:");
        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                System.out.print("Number " + numbers[i] + " is positive and ");
                if (isEven(numbers[i])) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else {
                System.out.println("Number " + numbers[i] + " is negative.");
            }
        }

        // Compare first and last elements
        int comparison = compare(numbers[0], numbers[4]);
        System.out.print("\nComparison of first and last elements: ");
        if (comparison == 1){
            System.out.println(numbers[0] + " is greater than " + numbers[4]);
        } else if (comparison == 0){
            System.out.println(numbers[0] + " is equal to " + numbers[4]);
        } else{
            System.out.println(numbers[0] + " is less than " + numbers[4]);
        }
        input.close();
    }
}
