package inheritance;

public class SchoolSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher("Sahil" , 23 , "JAVA");
		teacher.displayRole();
		
		Student student = new Student("Sahil" , 23 , 'A');
		student.displayRole();
		
		Staff staff = new Staff("Qwerty" ,45);
		staff.displayRole();
		
		

	}

}

//Base class
class Person{
	String name;
	int age;
	
	Person(String name ,int age){
		this.name = name;
		this.age = age; 
	}
	void displayRole() {
		System.out.println("Person Role is ..");
	}
	
}

//subclasses
class Teacher extends Person{
	String subject;
	
	Teacher(String name ,int age , String subject){
		super(name,age);
		this.subject = subject;
	}
	
	@Override
	void displayRole() {
		System.out.println("Person Role is Teacher.");
	}
	
}
class Student extends Person {
	char grade;
	Student(String name ,int age , char grade){
		super(name,age);
		this.grade = grade;
	}
	
	@Override
	void displayRole() {
		System.out.println("Person Role is Student.");
	}
	
	
}
class Staff extends Person{
	Staff(String name ,int age){
		super(name,age);
	}
	
	@Override
	void displayRole() {
		System.out.println("Person Role is Staff.");
	}
	
}