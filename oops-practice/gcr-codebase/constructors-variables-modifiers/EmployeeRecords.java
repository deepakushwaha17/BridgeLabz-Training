package classandobject;

public class EmployeeRecords {

	public static void main(String[] args) {
		Employee e1 = new Employee("EMP101", "IT", 60000);
        e1.displayEmployee();

        e1.setSalary(65000);
        System.out.println("Updated Salary: ₹" + e1.getSalary());

        Manager m1 = new Manager("EMP201", "HR", 80000, "Recruitment");
        m1.displayManager();

	}

}

class Employee {

	 public String employeeID;
	 protected String department;
	 private double salary;
	
	 Employee(String employeeID, String department, double salary) {
	     this.employeeID = employeeID;
	     this.department = department;
	     this.salary = salary;
	 }
	
	 // Public getter and setter for private salary
	 public double getSalary() {
	     return salary;
	 }
	
	 public void setSalary(double salary) {
	     if (salary >= 0)
	         this.salary = salary;
	     else
	         System.out.println("Invalid salary.");
	 }
	
	 public void displayEmployee() {
	     System.out.println( "Employee ID: " + employeeID + ", Department: " + department +", Salary: ₹" + salary);
	 }
}


//Subclass to access public and protected members
class Manager extends Employee {

	 String teamName;
	
	 Manager(String employeeID, String department, double salary, String teamName) {
	     super(employeeID, department, salary);
	     this.teamName = teamName;
	 }
	
	 void displayManager() {
	     System.out.println("Employee ID: " + employeeID + ", Department: " + department + ", Salary: ₹" + getSalary() +  ", Team: " + teamName);
	 }
}
