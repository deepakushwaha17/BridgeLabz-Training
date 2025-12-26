/*Create a program to find the bonus of 10 employees based on their years of service and the total bonus amount the company Zara has to pay, 
along with the old and new salary.*/

import java.util.Scanner;

public class CalculateBonus{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);     
		double[] yearOfService = new double[10];
		double[] salary = new double[10];
		double[] bonusAmount = new double[10];
		double[] newSalary = new double[10];
		
		double totalBonus = 0.0 , totalOldSalary = 0.0 , totalNewSalary = 0.0;
		System.out.print("Enter the salary and year of service : ");
		for(int i = 0 ; i < 10 ; i++){
			salary[i] = input.nextDouble();
			yearOfService[i] = input.nextDouble();
			if (salary[i] <= 0 || yearOfService[i] <= 0) {
				System.err.println("Invalid input.Enter again");
				i--;
				continue;
			}
		}
		
		for(int i = 0 ; i < 10 ; i++){
			if(yearOfService[i] > 5){
				bonusAmount[i] = salary[i] * 0.05;
				newSalary[i] = salary[i] + bonusAmount[i];
			}else{
				bonusAmount[i] = salary[i] * 0.02;
				newSalary[i] = salary[i] + bonusAmount[i];
			}
			totalBonus += bonusAmount[i];
			totalOldSalary += salary[i];
			totalNewSalary += newSalary[i];
		}
		System.out.println("Total bonus amount of all employees is " + totalBonus + "\nTotal old salary of all employees is " + totalOldSalary +
		     "\nTotal new salary of all employees is " + totalNewSalary);
		input.close();
	}
}
