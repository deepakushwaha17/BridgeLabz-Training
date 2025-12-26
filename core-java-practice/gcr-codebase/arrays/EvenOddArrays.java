/*Create a program to save odd and even numbers into odd and even arrays between 1 to the number entered by the user.
 Finally, print the odd and even numbers array*/
 
import java.util.Scanner;

public class EvenOddArrays {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number : ");
        int number = input.nextInt();

        if (number <= 0) {
            System.err.println("Invalid input. Not a natural number.");
            System.exit(0);
        }
		
		int size = number / 2 + 1;
        int[] evenNumbers = new int[size];
        int[] oddNumbers = new int[size];

        int evenIndex = 0, oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0){
                evenNumbers[evenIndex++] = i;
			} else{
                oddNumbers[oddIndex++] = i;
			}
        }

        System.out.println("Even Numbers are ");
        for (int i = 0; i < evenIndex; i++){
            System.out.print(evenNumbers[i] + " ");
		}

        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++){
            System.out.print(oddNumbers[i] + " ");
		}
		input.close();
    }
}

