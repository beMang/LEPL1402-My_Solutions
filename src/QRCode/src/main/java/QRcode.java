import java.util.Arrays;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 *
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 *
 *         boolean [][] t0 = new boolean[][] {
 *                 {false,true,false,false},
 *                 {false,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,true}
 *         };
 *
 *         // t2 is a version of t2 with two quarter rotations
 *         boolean [][] t2 = new boolean[][] {
 *                 {true,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,false},
 *                 {false,false,true,false}
 *         };
 */
public class QRcode {

    protected boolean [][] data;

    /**
     * Create a QR code object
     * @param data is a n x n square matrix
     */
    public QRcode(boolean [][] data) {
        this.data = data;
    }

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     * @param o the other matrix to compare to
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof QRcode)){
            return false;
        }
        if(strictlyEqual(((QRcode) o).data)){
            return true;
        }
        boolean[][] rotation = rotate(((QRcode) o).data);
        if(strictlyEqual(rotation)){
            return true;
        }
        rotation = rotate(rotation);
        if(strictlyEqual(rotation)){
            return true;
        }
        rotation = rotate(rotation);
        return strictlyEqual(rotation);
    }

    protected boolean strictlyEqual(boolean [][] data){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if(data[i][j]!=this.data[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean[][] rotate(boolean[][] array){
        boolean[][] rotate = new boolean[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                rotate[j][array.length-1-i] = array[i][j];
            }
        }
        return rotate;
    }

}
