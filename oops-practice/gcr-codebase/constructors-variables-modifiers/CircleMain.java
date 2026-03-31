package classandobject;

public class CircleMain {

	public static void main(String[] args) {
		Circle circle1 = new Circle();
        circle1.displayRadius();

        Circle circle2 = new Circle(5.5);
        circle2.displayRadius();

	}

}


class Circle{
	double radius;
	
	public Circle(){
		radius = 2.0;
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public void displayRadius() {
        System.out.println("Radius: " + radius);
    }
	
}