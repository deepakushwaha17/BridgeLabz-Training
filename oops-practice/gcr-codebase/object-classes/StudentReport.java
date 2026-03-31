package classandobject;

public class StudentReport {

	public static void main(String[] args) {
		Student student1 = new Student("Thamarai" , "ECE001" , 80 , 70 , 75);
		student1.displayReport();
		Student student2 = new Student("Kannan" , "CSC002" , 60 , 65 , 50);
		student2.displayReport();

	}

}

class Student{
	private String name;
	private String rollNumber;
	private int marks1;
	private int marks2;
	private int marks3;
	
	public Student(String name , String rollNumber , int marks1 , int marks2 , int marks3) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}
	
	public void calculateGrade() {
		double average =(double) (marks1 + marks2 + marks3) / 3;
		if(average >= 90) {
			System.out.println("Grade A");
		}else if(average >= 75) {
			System.out.println("Grade B");

		}else if(average >= 50) {
			System.out.println("Grade C");
		}else {
			System.out.println("Grade D");
		}
	}
	
	public void displayReport() {
		System.out.println("Student Name : " + name);
		System.out.println("Student RollNumber : " + rollNumber);
		System.out.println("Student Marks : ");
		System.out.println("Marks1 : " + marks1);
		System.out.println("Marks2 : " + marks2);
		System.out.println("Marks3 : " + marks3);
		calculateGrade();
	}
}

