/*Write a program to perform matrix manipulation operations like addition, subtraction, and multiplication. 
The program should take random matrices as input and display the result of the operations. */

import java.util.Random;
import java.util.Scanner;

public class MatrixManipulation {

    // create a random matrix of given rows and columns
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random numbers from 0 to 9
            }
        }
        return matrix;
    }

    // add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows for Matrix A: ");
        int rowsA = input.nextInt();
        System.out.print("Enter number of columns for Matrix A: ");
        int colsA = input.nextInt();

        System.out.print("Enter number of rows for Matrix B: ");
        int rowsB = input.nextInt();
        System.out.print("Enter number of columns for Matrix B: ");
        int colsB = input.nextInt();

        if (colsA != rowsB) {
            System.out.println("Warning: For multiplication, columns of A must equal rows of B.");
        }

        int[][] A = createRandomMatrix(rowsA, colsA);
        int[][] B = createRandomMatrix(rowsB, colsB);

        System.out.println("\nMatrix A:");
        printMatrix(A);

        System.out.println("\nMatrix B:");
        printMatrix(B);

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nA + B:");
            printMatrix(addMatrices(A, B));

            System.out.println("\nA - B:");
            printMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition and subtraction cannot be performed on matrices of different sizes.");
        }

        if (colsA == rowsB) {
            System.out.println("\nA x B:");
            printMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMultiplication cannot be performed. Columns of A must equal rows of B.");
        }

        input.close();
    }
}