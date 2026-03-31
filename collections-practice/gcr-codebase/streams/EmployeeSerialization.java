package streams;

import java.io.*;
import java.util.*;

public class EmployeeSerialization {

	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\EmployeeInformation.txt";
		List<Employee> employees = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        //Take employee input
        System.out.print("Enter number of employees: ");
        int n = input.nextInt();
        for(int i = 0; i < n ; i++) {
        	System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = input.nextInt();
            input.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Department: ");
            String dept = input.nextLine();

            System.out.print("Salary: ");
            double salary = input.nextDouble();
            input.nextLine(); // consume newline

            employees.add(new Employee(id, name, dept, salary));
        }
        
        // Serialize objects
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
        	oos.writeObject(employees);
        	System.out.println("Employees saved successfully in EmployeeInformation file");     	
        }
        catch(IOException e) {
			System.out.println("Error saving employees: " + e.getMessage());
		}
        
        //Deserialize objects
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
        	List<Employee> savedEmployees = (List<Employee>) ois.readObject();
        	System.out.println("\nEmployees retrieved from file:");
        	for(Employee emp : savedEmployees) {
        		System.out.println(emp);
        	}  	
        }
        catch (IOException e) {
            System.out.println("Error reading employees: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        
        input.close();
	}
}


// Employee class
class Employee implements Serializable{
	private int id;
	private String name;
	private String department;
	private double salary;
	
	// Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee {id=" + id + ", name=" + name +
               ", department=" + department + ", salary=" + salary + "}";
    }
}