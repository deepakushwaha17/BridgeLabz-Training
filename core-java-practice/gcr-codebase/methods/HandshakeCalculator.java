//Create a program to find the maximum number of handshakes among students.

import java.util.Scanner;

public class HandshakeCalculator {

    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        int numberOfStudents = input.nextInt();

        int handshakes = calculateHandshakes(numberOfStudents);
        System.out.println("The maximum number of possible handshakes is " + handshakes);
        input.close();
    }
}
