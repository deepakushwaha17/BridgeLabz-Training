package classandobject;

public class Student {
	
	static String universityName = "Global University"; //static variable
	static int totalStudents = 0;
	final int rollNumber;
	private String name;
	private char grade;
	
	public Student(int rollNumber, String name, char grade) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.grade = grade;
		totalStudents++;
	}
	
	
	//static method
	public static void displayTotalStudents() {
		System.out.println("Total Students Enrolled : " +totalStudents);
	}

	public void updateGrade(char newGrade) {
		if(this instanceof Student) {
			grade = newGrade;
			System.out.println("Grade update to : " + grade);
		}
		else {
			System.out.println("Invalid object of Student!");
		}
		
	}
	
	public void displayDetails() {
		if(this instanceof Student) {
			System.out.println("University Name : " + universityName);
			System.out.println("Roll Number : " + rollNumber);
			System.out.println("Name : " + name);
			System.out.println("Grade : " + grade);
		}
		else {
			System.out.println("Invalid object of Student!");
		}
	}
	
	
	public static void main(String[] args) {
		Student student1 = new Student(101,"Hemashree",'A');
		Student student2 = new Student(102,"Sharmila",'B');
		
		displayTotalStudents();
		student1.displayDetails();
		student2.displayDetails();
		student2.updateGrade('A');
		student2.displayDetails();
	}

}
