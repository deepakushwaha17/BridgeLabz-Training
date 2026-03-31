package classandobject;

public class UniversityManagement {

	public static void main(String[] args) {
		
        Student s1 = new Student(101, "Deepa", 9.2);
        s1.displayStudent();

        // Modify CGPA using public setter
        s1.setCGPA(9.5);
        System.out.println("Updated CGPA: " + s1.getCGPA());

        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Rohan", 8.7, "Computer Science");
        pg1.displayPGStudent();

	}

}

class Student {
	public int rollNumber;
	protected String name; 
	private double CGPA;

	Student(int rollNumber, String name, double CGPA) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.CGPA = CGPA;
	}

	// Public getter for private CGPA
	public double getCGPA() {
		return CGPA;
	}

	// Public setter for private CGPA
	public void setCGPA(double CGPA) {
		if(CGPA >= 0.0 && CGPA <= 10.0) {  
			this.CGPA = CGPA;
		} else {
			System.out.println("Invalid CGPA value.");
		}
	}

	public void displayStudent() {
		System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", CGPA: " + CGPA );
	}
}

//Subclass to demonstrate protected access
class PostgraduateStudent extends Student {

	String specialization;

	PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
		super(rollNumber, name, CGPA);
		this.specialization = specialization;
	}

	void displayPGStudent() {
		// Can access protected member 'name' directly
		System.out.println("Roll Number: " + rollNumber +  ", Name: " + name + 
         ", CGPA: " + getCGPA() +  ", Specialization: " + specialization);
	}
}

