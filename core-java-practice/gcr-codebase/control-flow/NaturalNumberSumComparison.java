//Rewrite the program number 12(NaturalNumberSum) with the for loop instead of a while loop to find the sum of n Natural Numbers. 
import java.util.Scanner;

public class NaturalNumberSumComparison {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
        int naturalNumber = input.nextInt();

		//checking entered number is natural number or not
        if (naturalNumber <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int sumUsingForLoop = 0;
        for (int currentNumber = 1; currentNumber <= naturalNumber ; currentNumber++) {
            sumUsingForLoop += currentNumber;       
        }

        int sumUsingFormula = naturalNumber * (naturalNumber + 1) / 2;

		// comparing result obtained formula and while loop
        if (sumUsingForLoop == sumUsingFormula) {
            System.out.println("Both computations are correct and sum of numbers is " + sumUsingFormula);
        } else {
            System.out.println("Computation results do not match");
        }
		input.close();
    }
}
