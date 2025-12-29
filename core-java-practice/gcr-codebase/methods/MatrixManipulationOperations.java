/*Write a program to perform matrix manipulation operations like finding the transpose, determinant, 
and inverse of a matrix. The program should take random matrices as input and display 
the result of the operations. */

import java.util.Random;

public class MatrixManipulationOperations {
  
    // create a random integer matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // random integer 0-9
        return matrix;
    }

    // display integer matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.printf("%5d", val);
            System.out.println();
        }
    }

    // display double matrix (for inverse)
    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) return;
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%8.3f", val);
            System.out.println();
        }
    }

    // find the transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }

    // Determinant of 2x2 matrix
    public static int determinant2x2(int[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    // Determinant of 3x3 matrix
    public static int determinant3x3(int[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return null;
        }
        return new double[][] {
            { (double)m[1][1]/det, -(double)m[0][1]/det },
            { -(double)m[1][0]/det, (double)m[0][0]/det }
        };
    }

    // Inverse of 3x3 matrix
    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return null;
        }

        double[][] adj = new double[3][3];
        // Cofactor matrix
        adj[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        adj[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        adj[0][2] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        adj[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        adj[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        adj[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        adj[2][0] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        adj[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        adj[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        // Transpose and divide by determinant
        double[][] inverse = new double[3][3];
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                inverse[i][j] = adj[j][i] / (double)det;

        return inverse;
    }

    public static void main(String[] args) {
        // Create a random 3x3 matrix
        int[][] matrix = createRandomMatrix(3, 3);
        
        System.out.println("Original Matrix:");
        displayMatrix(matrix);
        
        System.out.println("\nTranspose:");
        int[][] transpose = transposeMatrix(matrix);
        displayMatrix(transpose);
        
        if (matrix.length == 2) {
            int det2x2 = determinant2x2(matrix);
            System.out.println("\nDeterminant (2x2): " + det2x2);
            
            double[][] inverse2x2 = inverse2x2(matrix);
            System.out.println("\nInverse (2x2):");
            displayMatrix(inverse2x2);
        } else if (matrix.length == 3) {
            int det3x3 = determinant3x3(matrix);
            System.out.println("\nDeterminant (3x3): " + det3x3);
            
            double[][] inverse3x3 = inverse3x3(matrix);
            System.out.println("\nInverse (3x3):");
            displayMatrix(inverse3x3);
        } else {
            System.out.println("Only 2x2 and 3x3 matrices are supported for determinant and inverse.");
        }
    }

}