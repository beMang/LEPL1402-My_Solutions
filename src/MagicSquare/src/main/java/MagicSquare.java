import java.util.ArrayList;
import java.util.Arrays;

public class MagicSquare {


    /**
     * A magic square is an (n x n) matrix such that:
     *
     * - all the positive numbers 1,2, ..., n*n are present (thus each number appears exactly once)
     * - the sums of the numbers in each row, each column and both main diagonals are the same
     *
     *   For instance a 3 x 3 magic square is the following
     *
     *   2 7 6
     *   9 5 1
     *   4 3 8
     *
     *   You have to implement the method that verifies if a matrix is a valid magic square
     */

    /**
     *
     * @param matrix a square matrix of size n x n
     * @return true if matrix is a n x n magic square, false otherwise
     */
    public static boolean isMagicSquare(int [][] matrix) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int[] row : matrix){
            for(int i : row){
                numbers.add(i);
            }
        }
        numbers.sort(Integer::compareTo);
        for (int i = 0; i < matrix.length ; i++) {
            if(numbers.get(i)!=i+1){
                return false;
            }
        }
        return checkRows(matrix) && checkColumns(matrix) && checkDiagonal(matrix);
    }

    public static boolean checkRows(int[][] matrix){
        int sum = Arrays.stream(matrix[0]).sum();
        for(int[] row : matrix){
            if(sum!= Arrays.stream(row).sum()){
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumns(int[][] matrix){
        Integer checker = null;
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int[] ints : matrix) {
                sum += ints[i];
            }
            if(checker==null){
                checker=sum;
            } else{
                if(checker!=sum){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkDiagonal(int[][] matrix){
        int first = 0;
        for (int i = 0; i < matrix.length; i++) {
            first+=matrix[i][i];
        }
        int second = 0;
        for (int i = 0; i < matrix.length; i++) {
            second+=matrix[matrix.length-1-i][i];
        }
        return second==first;
    }
}
