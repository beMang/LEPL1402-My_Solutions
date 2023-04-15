public class Search {

    /**
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem){
        int first = 0;
        int last = tab.length - 1;

        while (first <= last) {
            int middle = (first + last) / 2;
            if (tab[middle] == elem) {
                return middle;
            } else {
                if (elem < tab[middle]) {
                    last = middle-1;
                } else {
                    first = middle+1;
                }
            }
        }
        return -1;
    }

    public static int searchShit(int[] tab, int elem) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {1,2,6,9,8,7,55};
        System.out.println(search(test, 2));
    }
}