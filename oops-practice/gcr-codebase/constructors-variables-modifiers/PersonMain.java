package classandobject;

public class PersonMain {

	public static void main(String[] args) {
		 Person p1 = new Person("Deepa", 22);
		 p1.display();

	     Person p2 = new Person(p1);
	     p2.display();
	}
}

class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
