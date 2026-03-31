package oopsPillars;

import java.util.Scanner;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of employee : ");
		int empNum = input.nextInt();
		input.nextLine();
		
		Employee[] employee = new Employee[empNum];
		
		//employees input from user
		for(int i = 0 ; i < empNum ; i++) {
			System.out.println("------Employee "+(i+1)+"------");
			System.out.print("Enter Employee ID : ");
			String employeeID = input.nextLine();
			
			System.out.print("Enter Employee Name : ");
			String name = input.nextLine();
			System.out.print("Enter 1 - Full-time/ 2 - Part-time: ");
			int type  = input.nextInt();
			
			//check type
			if(type == 1) {
				System.out.print("Enter Fixed Salary : ");
				double baseSalary = input.nextDouble();
				
				employee[i] = new FullTimeEmployee(employeeID , name , baseSalary);
				
			}else if(type == 2) {
				System.out.print("Enter Hourly Salary : ");
				double hourlySalary = input.nextDouble();
				System.out.print("Enter Hours Worked : ");
				double hoursWorked = input.nextDouble();
				
				employee[i] = new PartTimeEmployee(employeeID , name , hourlySalary , hoursWorked);
				
			}else {
				System.out.print("Invalid Type!");
			}
			
			input.nextLine();
			
			//assign department
			System.out.print("Enter Department : ");
			String department = input.nextLine();
			
			((Department)employee[i]).assignDepartment(department);
			
			
		}
		//print employee details
		System.out.print("\n------Employee Details------");
		for(Employee emp : employee) {
			emp.displayDetails();
			System.out.println("Department : " +((Department)emp).getDepartmentDetails());	
		}
		input.close();
	}

}

//Abstract class Employee
abstract class Employee{
	
	private String employeeId,name;
	private double baseSalary;
	
	//constructor
	Employee(String employeeId, String name , double baseSalary){
		this.employeeId = employeeId;
		this.name = name;
		setBaseSalary(baseSalary);
	}

	//public getter for employee id
	public String getEmployeeID() {
		return employeeId;
	}
	
	//public getter for employee name
	public String getName() {
		return name;
	}
	
	//public getter for employee base salary
	public double getBaseSalary() {
		return baseSalary;	
	}
	
	// public setter for base salary with validation
	public void setBaseSalary(double baseSalary) {
		if(baseSalary >= 0) {
			this.baseSalary = baseSalary;
		}else {
			System.out.println("Salary cannot be negative.");
		}
	}
	
	//abstract method
	abstract double calculateSalary();
		
	//concrete method
	public void displayDetails() {
		System.out.println("\nEmployee Id : " +employeeId);
		System.out.println("Employee Name : " +name);
		System.out.println("Employee base salary : " +calculateSalary());
	}
}

//interface Department
interface Department{
	void assignDepartment(String department);
	String getDepartmentDetails();
	
}

//subclasses
class FullTimeEmployee extends Employee implements Department{
	
	String department;
	
	//constructor
	FullTimeEmployee(String employeeId, String name , double baseSalary){
		super(employeeId,name,baseSalary);
	}
	
	//calculating salary of Full time employee
	@Override
	double calculateSalary() {
		return getBaseSalary();
	}
	
	//assign department
	@Override
	public void assignDepartment(String department) {
		this.department = department;
	}
	
	//getting department details
	@Override
	public String getDepartmentDetails() {
		return department;
	}
}

class PartTimeEmployee extends Employee implements Department{
	double hourlySalary;
	double hoursWorked;
	String department;
	
	//constructor
	PartTimeEmployee(String employeeId, String name , double hourlySalary , double hoursWorked){
		super(employeeId,name,0);
		this.hourlySalary = hourlySalary;
		this.hoursWorked = hoursWorked;
	}
	
	//calculating salary of Part time employee
	@Override
	double calculateSalary() {
		return hourlySalary * hoursWorked;
	}
	
	//assign department
	@Override
	public void assignDepartment(String department) {
		this.department = department;
	}
	
	//getting department details
	@Override
	public String getDepartmentDetails() {
		return department;
	}
}