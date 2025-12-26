//Write a Java program to create a 2D Array and Copy the 2D Array into a single dimension array

import java.util.Scanner;

public class Copy2DTo1DArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns : ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] = input.nextInt();
			}
		}

        int[] array1D = new int[rows * columns];
        int index = 0;
		
		//copying 2D array elements to 1D array
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                array1D[index++] = matrix[i][j];
			}
		}

        System.out.println("Elements of 1D array:");
        for (int i = 0; i < array1D.length; i++){
            System.out.print(array1D[i] + " ");
		}
		input.close();
    }
}
