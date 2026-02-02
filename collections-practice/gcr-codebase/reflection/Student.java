package reflection;

public class Student {
	
    String name;
    public Student() { 
    	this.name = "Default Student"; 
    }

    public static void main(String[] args) throws Exception {
        Class<Student> cls = Student.class;
        Student s = cls.getDeclaredConstructor().newInstance();
        System.out.println("Student Name: " + s.name);
    }
}
