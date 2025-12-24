/*The University is charging the student a fee of INR 125000 for the course. The University is willing to offer a discount of 10%. 
Write a program to find the discounted amount and discounted price the student will pay for the course.*/

public class CalculateDiscountOnFees{
    public static void main(String[] args){
	    int fees = 125000 , discountPercent = 10;
		int discount = (fees * discountPercent) / 100;
		int discountFees = fees - discount;
		System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountFees);
    }
}