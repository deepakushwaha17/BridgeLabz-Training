package EmployeeRole;

public class Manager extends Employee{

	public Manager(String name,int salary) {
		super(name,salary);
	}
	
	@Override
	public double getBonus() {
		return super.getSalary()*0.1;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("Manager Bonus : " +getBonus());
	}
}