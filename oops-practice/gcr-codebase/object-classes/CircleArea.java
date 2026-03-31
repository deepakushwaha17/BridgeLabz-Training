package classandobject;

public class CircleArea {

	public static void main(String[] args) {
		Circle circle = new Circle(4);
		circle.display();

	}

}

class Circle{
	private double radius;
	static final double PI = 3.14;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double calculateArea() {	
		double area = PI * radius * radius;
		return area;
	}
	
	public double calculateCircumference() {
		double circumference = 2 * PI * radius;
		return circumference;
	}
	
	public void display() {
		System.out.println("Area of circle : " + calculateArea());
		System.out.println("Circumference of circle : " + calculateCircumference());
	}
}