package EmployeeRole;

public class Developer extends Employee{

	public Developer(String name,int salary) {
		super(name,salary);
	}
	
	@Override
	public double getBonus() {
		if(super.getSalary() > 50000) {
			return super.getSalary() * 0.05;
		}
		return 0.0;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("Developer Bonus :%.2f%n " +getBonus());
	}
}
