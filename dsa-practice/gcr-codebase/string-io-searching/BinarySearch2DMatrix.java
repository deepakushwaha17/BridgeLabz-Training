package dsaProblems;

import java.util.Scanner;

public class BinarySearch2DMatrix {
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int r = mid / columns;
            int c = mid % columns;

            if (matrix[r][c] == target) {
                return true; // target found
            } else if (matrix[r][c] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }

        return false; // target not found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println("Enter matrix elements (row-wise, ascending sorted in each row):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        System.out.print("Enter the target value to search: ");
        int target = input.nextInt();

        boolean found = searchMatrix(matrix, target);
        if (found) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }

        input.close();
    }
}
