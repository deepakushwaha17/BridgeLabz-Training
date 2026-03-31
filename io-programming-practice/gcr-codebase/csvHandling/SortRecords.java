package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortRecords {
	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\employees.csv";
		ArrayList<Employee> employee = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				
				//Adding employee data to arraylist
				employee.add(new Employee(columns[0],columns[1],columns[2],Integer.parseInt(columns[3])));
			}
			System.out.println("Data added successfully to list.\n");
			Collections.sort(employee);
			System.out.println("ID\tName\tDepartment\tSalary");
			
			int count = 0;
			for(Employee e : employee) {
				if(count == 5) {
					break;
				}
				System.out.println(e.id + "\t" + e.name + "\t" + e.department + "\t\t" + e.salary);
				count++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

class Employee implements Comparable<Employee>{
	String id;
	String name;
	String department;
	int salary;
	
	public Employee(String id, String name, String department, int salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	@Override
	public int compareTo(Employee e) {
		return e.salary - this.salary;
	}
}
