package reflection;
import java.lang.reflect.*;

public class Calculator {
	private int multiply(int a, int b) 
	{ 
		return a * b; 
	}
	public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);
        int result = (int) multiplyMethod.invoke(calc, 5, 4);
        System.out.println("Result: " + result);
    }
}
