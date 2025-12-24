//Write a program to calculate simple interest using the formula

import java.util.Scanner;

class SimpleInterest {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double principal = input.nextDouble();
        System.out.print("Enter Rate: ");
        double rate = input.nextDouble();
        System.out.print("Enter Time: ");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest: " + simpleInterest);
		input.close();
    }
}
