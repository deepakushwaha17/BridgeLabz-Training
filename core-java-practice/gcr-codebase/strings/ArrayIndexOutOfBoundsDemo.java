//Write a program to demonstrate ArrayIndexOutOfBoundsException

import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo{
	public static void generateException(String[] names){
		int length = names.length;
		System.out.println("Array element at index " + length + " is " + names[length]);
	}
	
	public static void handleException(String[] names){
		try{
			int length = names.length;
			System.out.println("Array element at index " + length + " is " + names[length]);
		}
		catch (ArrayIndexOutOfBoundsException e){
			 System.out.println("ArrayIndexOutOfBoundsException occurred! " + e.getMessage());
        } 
		catch (Exception e) {
            System.out.println("Generic Exception! " + e.getMessage());
        }
	}
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int length = input.nextInt();
        input.nextLine(); 

        String[] names = new String[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = input.nextLine();
        }

        try {
            generateException(names);
        } 
		catch (ArrayIndexOutOfBoundsException e) {
			handleException(names);
        }
	}
}		