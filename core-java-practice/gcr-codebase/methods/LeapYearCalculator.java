//Write a program that takes a year as input and outputs the Year is a Leap Year or not 

import java.util.Scanner;

public class LeapYearCalculator {

    public static boolean isLeapYear(int year) {
        if (year < 1582) return false; 
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year : ");
        int year = input.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }
        input.close();
    }
}
