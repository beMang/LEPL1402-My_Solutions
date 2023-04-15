public class Fibonacci {

    /*
     * Returns the index-th element of the fibonnaci sequence, computed recursively
     */
    public static int fiboRecursive(int index){
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fiboRecursive(index-1) + fiboRecursive(index-2);
        }
    }

    /*
     * Returns the index-th element of the fibonnaci sequence, computed iteratively
     */
    public static int fiboIterative(int index){
        if (index==0) {
            return 0;
        }
        int n1 = 0;
        int n2 = 1;
        for (int i = 1; i < index; i++) {
            n2 = n1 + n2;
            n1 = n2 - n1;
        }
        return n2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String test = i + " : " + fiboIterative(i) + " - " + fiboRecursive(i);
            System.out.println(test);
        }
    }

}
