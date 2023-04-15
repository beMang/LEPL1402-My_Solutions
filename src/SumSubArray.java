import java.util.Arrays;

public class SumSubArray {
    /**
     * Find the contiguous subarray with the maximal sum
     *
     * @param a a non-empty array
     * @return A triplet (sum, start, end) with sum the sum of the subarray and `start` and `end` the
     *         start and end of the subarray
     *
     * For example for the array [-2,1,-3,4,-1,2,1,-5,4] your method should return [6, 3, 6]
     */
    public static int[] maxSubArray(int[] a){
        int max = 0;
        int current = 0;
        int start=0,stop=0, from=0, to = 0;
        for (int i=0; i < a.length; i++) {
            current += a[i];
            stop++;
            if (current>max) {
                max = current;
                from = start;
                to = stop-1;
            }
            if (current<0) {
                current = 0;
                start = i+1;
                stop = start;
            }
        }
        if (max==0){
            int[] minArray = minArray(a);
            return new int[]{minArray[0], minArray[1], minArray[1]};
        }
        return new int[]{max, from, to};
    }

    public static int[] minArray(int[] a){
        int max = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i]>max) {
                max = a[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }

    public static void main(String[] args) {
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] test2 = new int[]{1};
        int[] test3 = new int[]{-9,-5,-6};
        System.out.println(Arrays.toString(maxSubArray(test)));
        System.out.println(Arrays.toString(maxSubArray(test2)));
        System.out.println(Arrays.toString(maxSubArray(test3)));
    }
}
