/*Problem 2: Date Arithmetic Create a program that:
➢ Takes a date input and adds 7 days, 1 month, and 2 years to it.
➢ Then subtracts 3 weeks from the result.*/

import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a date (yyyy-mm-dd): ");
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input);

        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("Updated Date after arithmetic: " + updatedDate);
    }
}
