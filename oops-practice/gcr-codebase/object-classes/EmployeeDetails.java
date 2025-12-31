package classandobject;

public class EmployeeDetails {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Rohan" , 1, 500000);
		employee1.displayDetails();

	}

}

class Employee{
	private String name;
	private int id;
	private int salary;
	
	public Employee(String name , int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public void displayDetails() {
		System.out.println("Employee Name : " +name);
		System.out.println("Employee Id : " +id);
		System.out.println("Employee Salary : " +salary);
	}
}