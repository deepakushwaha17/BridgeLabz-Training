/*Write a program FizzBuzz, take a number as user input and if it is a positive integer loop from 0 to the number and save the number, 
but for multiples of 3 save "Fizz" instead of the number, for multiples of 5 save "Buzz", and for multiples of both save "FizzBuzz". 
Finally, print the array results for each index position in the format Position 1 = 1, …, Position 3 = Fizz,...*/

import java.util.Scanner;

public class FizzBuzz{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer : ");
        int number = input.nextInt();

        if (number <= 0) {
            System.err.println("Invalid input. Not a positive integer.");
            System.exit(0);
        }

        String[] result = new String[number + 1];

        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                result[i] = "FizzBuzz";
            }else if (i % 3 == 0){
                result[i] = "Fizz";
            }else if (i % 5 == 0){
                result[i] = "Buzz";
            }else{
                result[i] = String.valueOf(i);
			}
        }

        for (int i = 0; i <= number; i++){
            System.out.println("Position " + i + " = " + result[i]);
		}
		input.close();
    }
}
