/*Invoice Generator for Freelancers
Focus: Strings, Methods
● Scenario: You're building an app for freelancers to generate invoice descriptions.
 Requirements:
● Accept input like: "Logo Design - 3000 INR, Web Page - 4500 INR".
● Split the string to extract task names and amounts.
● Calculate total invoice amount.
● Example Methods:
● ParseInvoice(string input)
● GetTotalAmount(string[] tasks)*/

package classandobject;

import java.util.Scanner;

public class InvoiceGenerator {

    //split invoice string into individual tasks
    static String[] parseInvoice(String input) {
        return input.split(", ");
    }

    //calculate total amount
    static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            //ex- "Logo Design - 3000 INR"
            String[] parts = task.split(" - ");
            String amountPart = parts[1];          // "3000 INR"
            String amountString = amountPart.split(" ")[0]; // "3000"

            int amount = Integer.parseInt(amountString);
            total += amount;
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter invoice details:");
        String invoice = input.nextLine();

        String[] tasks = parseInvoice(invoice);

        System.out.println("\nInvoice Items:");
        for (String task : tasks) {
            System.out.println(task);
        }

        int totalAmount = getTotalAmount(tasks);

        System.out.println("\nTotal Invoice Amount: " + totalAmount + " INR");

        input.close();
    }
}
