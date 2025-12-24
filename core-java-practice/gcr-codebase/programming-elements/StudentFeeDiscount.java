//Write a new program similar to the program # 6 but take user input for Student Fee and University Discount

import java.util.Scanner;

public class StudentFeeDiscount {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the student fee: ");
        double fee = input.nextDouble();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();
        double discount = (fee * discountPercent) / 100;
        double discountFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountFee);
        input.close();
    }
}
