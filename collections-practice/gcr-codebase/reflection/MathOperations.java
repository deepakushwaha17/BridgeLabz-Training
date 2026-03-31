package reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class MathOperations {
    public int add(int a, int b) { 
    	return a + b;
    }
    public int subtract(int a, int b) { 
    	return a - b; 
    }
    public int multiply(int a, int b) { 
    	return a * b; 
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        MathOperations mo = new MathOperations();

        System.out.print("Enter method name: ");
        String methodName = input.nextLine();

        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(mo, 10, 5);
        System.out.println("Result: " + result);
        input .close();
    }
}
