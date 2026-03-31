/*Invoice Generator for Freelancers
Focus: Strings, Methods, Exception Handling
Scenario:
You're building an app for freelancers to generate invoice descriptions.
 Requirements:
Accept input like: "Logo Design - 3000 INR, Web Page - 4500 INR"

Split the string to extract task names and amounts
Calculate total invoice amount
If the input format is invalid (missing dash or amount), throw
InvalidInvoiceFormatException.

Example Methods:
● parseInvoice(String input)
● getTotalAmount(String[] tasks)*/

package classandobject;

import java.util.Scanner;

public class InvoiceGeneratorWithException {

    //parse invoice string into tasks
    static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input cannot be empty.");
        }

        String[] tasks = input.split(",\\s*"); // Split by comma and optional spaces

        //validate each task
        for (String task : tasks) {
            if (!task.contains(" - ")) {
                throw new InvalidInvoiceFormatException("Task format invalid: " + task);
            }
            String[] parts = task.split(" - ");
            if (parts.length != 2 || !parts[1].trim().matches("\\d+\\s*INR")) {
                throw new InvalidInvoiceFormatException("Amount missing or invalid input: " + task);
            }
        }

        return tasks;
    }

    //calculate total invoice amount
    static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split(" - ");
            String amountString = parts[1].split(" ")[0]; // Extract digits before INR
            total += Integer.parseInt(amountString);
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter invoice details (e.g. Logo Design - 3000 INR, Web Page - 4500 INR):");
        String invoice = input.nextLine();

        try {
            String[] tasks = parseInvoice(invoice);

            System.out.println("\nInvoice Items:");
            for (String task : tasks) {
                System.out.println(task);
            }

            int total = getTotalAmount(tasks);
            System.out.println("\nTotal Invoice Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}


//custom exception
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}
