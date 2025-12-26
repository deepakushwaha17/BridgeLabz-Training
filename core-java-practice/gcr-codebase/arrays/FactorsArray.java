//Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors

import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = input.nextInt();

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if(number % i == 0) {
                if (index == maxFactor) {
                    // Expand array
                    int[] temp = new int[maxFactor * 2];
                    for (int j = 0; j < maxFactor; j++){
                        temp[j] = factors[j];
					}
                    factors = temp;
                }
                factors[index++] = i;
            }
        }

        System.out.println("Factors of " + number + " are:");
        for (int i = 0; i < index; i++){
            System.out.print(factors[i] + " ");
		}
		input.close();
    }
}
