package reflection;
import java.lang.reflect.*;

public class Person {
	private int age = 22;

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Field ageField = Person.class.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.setInt(p, 30); 
		System.out.println("Age: " + ageField.getInt(p));
	}

}
