//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods

import java.util.Scanner;

public class NumberChecker2 {

    // find count of digits
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // store digits in an array
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        int temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    // check Duck Number
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    // check Armstrong Number
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;

        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    // find largest and second largest digits
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    // find smallest and second smallest digits
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number);

        System.out.println("\nNumber of digits: " + count);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.println("\nDuck Number: " + isDuckNumber(digits));
        System.out.println("Armstrong Number: " + isArmstrongNumber(number, digits));

        int[] large = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + large[0]);
        System.out.println("Second Largest digit: " + large[1]);

        int[] small = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + small[0]);
        System.out.println("Second Smallest digit: " + small[1]);

        input.close();
    }
}
