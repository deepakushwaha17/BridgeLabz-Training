/*Create a program to divide N number of chocolates among M children. Print the number of chocolates each child will get and also the remaining chocolates
 */
import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int perChild = numberOfChocolates / numberOfChildren;
        int remaining = numberOfChocolates % numberOfChildren;
        return new int[]{perChild, remaining};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = input.nextInt();
        System.out.print("Enter number of children: ");
        int numberOfChildren = input.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
        input.close();
    }
}
