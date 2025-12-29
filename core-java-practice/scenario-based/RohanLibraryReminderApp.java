/*Rohan’s Library Reminder App 📚
Rohan wants a fine calculator:
● Input return date and due date.
● If returned late, calculate fine: ₹5/day.
● Repeat for 5 books using for-loop. */

import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RohanLibraryReminderApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to, Library Fine Calculator App!");

        final int FINE_PER_DAY = 5;

        for(int i = 0; i < 5 ; i++){
            System.out.println("\nBook " + (i+1));
            System.out.print("Enter the due date (yyyy-mm-dd) : ");
            LocalDate duDate = LocalDate.parse(input.next());
            System.out.print("Enter the return date (yyyy-mm-dd) : ");
            LocalDate returnDate = LocalDate.parse(input.next());

            if(returnDate.isAfter(duDate)){
                long lateDays = ChronoUnit.DAYS.between(duDate, returnDate);
                long fine = lateDays * FINE_PER_DAY;

                System.out.println("Returned book after " + lateDays + " days ");
                System.out.println("Fine to be paid is " + fine);
            }
            else{
                System.out.println("Returned on time. No fine to be paid .");
            }
        }
        System.out.println("All book is processed. Thank you !");
        input.close();
    }
    
}
