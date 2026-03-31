package reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class GetClassInformation {
    public static void main(String[] args) throws ClassNotFoundException {
    	try {
    		Scanner input = new Scanner(System.in);
            System.out.print("Enter class name: ");
            String className = input.nextLine();

            Class<?> cls = Class.forName(className);

            System.out.println("Fields:");
            for (Field f : cls.getDeclaredFields()) {
            	System.out.println(f);
            }

            System.out.println("\nMethods:");
            for (Method m : cls.getDeclaredMethods()) {
            	System.out.println(m);
            }

            System.out.println("\nConstructors:");
            for (Constructor<?> c : cls.getDeclaredConstructors()) {
            	System.out.println(c);
            }
            input.close();
    	}
    	catch(ClassNotFoundException e) {
    		System.out.println("Class not found!");
    	}
        
    }
}