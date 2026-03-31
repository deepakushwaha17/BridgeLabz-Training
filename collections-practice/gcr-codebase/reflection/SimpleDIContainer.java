package reflection;
import java.lang.reflect.*;

class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {

    @Inject
    private Engine engine;

    void drive() {
        engine.start();
        System.out.println("Car is running");
    }
}

public class SimpleDIContainer {
	public static void main(String[] args) throws Exception {
		Car car = new Car();

        //Reflection-based Dependency Injection
        for (Field field : Car.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);

                // Create dependency object
                Object dependency = field.getType().getDeclaredConstructor().newInstance();

                // Inject dependency
                field.set(car, dependency);
            }
        }
        car.drive();
    }
}
