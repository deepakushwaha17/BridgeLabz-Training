//Create a program to find the bonuses of employees based on their years of service.

import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter salary : ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service : ");
        int yearsOfService = input.nextInt();
	    double bounusAmount = 0.0;
        if (yearsOfService > 5){
			bounusAmount = salary * 0.05;
            System.out.println("Bonus Amount on " + yearsOfService + " years of service is " + bounusAmount);
		}
        else{
            System.out.println("Years of service is less than 5 . No Bonus Amount");
		}
        input.close();
    }
}
