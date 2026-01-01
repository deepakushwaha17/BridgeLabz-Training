package classandobject;

public class Employee {
	static String companyName = "Tech Solutions Inc."; // static variable
	final int id;
	private String name;
	private String designation;
	static int totalEmployee = 0;
	
	public Employee(int id, String name , String designation) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		totalEmployee++;
	}
	
	//static method
	public static void displayTotalEmployees() {
		System.out.println("Total Employee : " +totalEmployee);
	}

	public void displayEmployeeDetails() {
		if(this instanceof Employee) {
			System.out.println("Company Name : "+companyName);
			System.out.println("Employee ID : "+id);
			System.out.println("Name : "+name);
			System.out.println("Designation : "+designation);
		}
		else {
			System.out.println("Invalid Employee instance!");
		}
	}
	
	//getters and setters
	public String getEmployeeName() {
		return name;
	}
	public void setEmployeeName(String name) {
		this.name = name;
	}
	public String getEmployeeDesignation() {
		return designation;
	}
	public void setEmployeeDesignation(String designation) {
		this.designation = designation;
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee(101 , "Thamarai","Software Engineer");
		Employee emp2 = new Employee(102,"Rohan","Project Manager");
		
		displayTotalEmployees();
		emp1.displayEmployeeDetails();
		emp2.displayEmployeeDetails();
	}
}
