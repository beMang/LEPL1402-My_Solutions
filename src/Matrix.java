import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follows:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *  For example, the String "0 1\n2 3" represent the
     *  matrix:
     *      [0 1]
     *      [2 3]
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] rows = s.split("\n");
        int[][] result = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] character = rows[i].split(" ");
            result[i] = new int[character.length];

            for (int j = 0; j < character.length; j++) {
                result[i][j] = Integer.parseInt(character[j].trim());
            }
        }
        return result;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for(int[] rows : matrix) {
            for(int col : rows) {
                sum +=col;
            }
        }
        return sum;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input rectangular matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int m = matrix1[0].length;
        int k = matrix2[0].length;

        int[][] matrix = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = 0;
                for (int p = 0; p < m; p++) {
                    matrix[i][j] += matrix1[i][p]*matrix2[p][j];
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] idendity = {{1,0}, {0,1}};
        int[][] matrix = buildFrom("0 1 \n2 3");

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result));
    }
}