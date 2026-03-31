package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
	String name;
	String department;
	double salary;
	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
}

public class EmployeeSalaryCategorization {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Deepa" ,"MCA", 45000),new Employee("Mahi" ,"MCA", 46000),
				new Employee("Rahul" ,"CSE", 46000),new Employee("Amit" ,"MCA", 32000),new Employee("Aarav" ,"CSE", 21000),
				new Employee("Saloni" ,"BSc", 35000));
		Map<String, Double> avgSalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.averagingDouble(Employee::getSalary)));
		
		avgSalaryByDept.forEach((name, total) ->
        System.out.println(name + " -> " + total));	
	}
}