import javax.imageio.stream.ImageOutputStream;
import java.util.Arrays;

public class Valley{

    /**
     * Compute the deepest valley and highest mountain
     *
     * @param slopes A non-empty array of slope
     * @return An array of two element. The first is the
     *         depth of the deepest valley and the second
     *         the height of the highest mountain
     */
    public static int[] valley (int[] slopes){
        int valley = 0;
        int montain = 0;

        int currentLine = slopes[0];
        int previousLine = 0;
        for (int i = 1; i < slopes.length; i++) {
            if(currentLine/slopes[i]<0) {
                if(currentLine<0) {
                    int high = Math.min(previousLine, -currentLine);
                    if(high>montain) montain = high;
                } else {
                    int depth = Math.min(-previousLine, currentLine);
                    if(depth>valley) valley = depth;
                }
                previousLine = currentLine;
                currentLine=slopes[i];
            } else {
                currentLine+=slopes[i];
                if(currentLine<0) {
                    int high = Math.min(previousLine, -currentLine);
                    if(high>montain){
                        montain = high;
                    }
                } else {
                    int depth = Math.min(-previousLine, currentLine);
                    if(depth>valley){
                        valley=depth;
                    }
                }
            }
        }

        return new int[]{valley,montain};
    }

    public static void main(String[] args) {
        int[] values = {1,1,1,-1,-1,-1,-1,-1,1,1,1,1,1,1,-1,-1};
        System.out.println(Arrays.toString(valley(values)));
    }
}