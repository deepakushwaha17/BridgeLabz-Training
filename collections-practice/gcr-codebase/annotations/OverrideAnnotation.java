package annotations;

class Animal{
	void makesSound() {
		System.out.println("Animal makes sound.");
	}
}

class Dog extends  Animal{
	
	@Override
	void makesSound() {
		System.out.println("Dog barks.");
	}
}

public class OverrideAnnotation {

	public static void main(String[] args) {
		Animal a = new Dog();
		a.makesSound();
	}

}
