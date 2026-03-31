package EmployeeRole;

import java.util.Scanner;

public class EmployeeRoleMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the employee name : ");
		String name = input.nextLine();
		System.out.print("Enter the salary : ");
		int salary = input.nextInt();
		System.out.print("Enter 1.Manager / 2.Developer : ");
		int type = input.nextInt();
		
		if(type == 1) {
			Employee manager = new Manager(name,salary); 
			manager.display();
		}
		else if(type == 2) {
			Employee developer = new Developer(name,salary); 
			developer.display();
		}
		else {
			System.out.println("Invalid Type!");
		}
		input.close();

	}
}