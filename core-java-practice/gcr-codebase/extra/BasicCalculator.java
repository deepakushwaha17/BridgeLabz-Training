//Write a program that performs basic mathematical operations (addition, subtraction, multiplication, division) based on user input.

import java.util.Scanner;

public class BasicCalculator {

    public static int add(int a, int b) { 
        return a + b; 
    }
    public static int subtract(int a, int b) {
        return a - b; 
    }
    public static int multiply(int a, int b) { 
        return a * b; 
    }
    public static double divide(int a, int b) { 
        return (double) a / b; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Choose operation: 1) Add 2) Subtract 3) Multiply 4) Divide");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 : 
                System.out.println("Result: " + add(a, b));
                break;
            case 2 : 
                System.out.println("Result: " + subtract(a, b));
                break;
            case 3 : 
                System.out.println("Result: " + multiply(a, b));
                break;
            case 4 :
                if (b != 0)
                    System.out.println("Result: " + divide(a, b));
                else
                    System.out.println("Cannot divide by zero!");
                break;
            default :
                System.out.println("Invalid choice!");
        }
    }
}
