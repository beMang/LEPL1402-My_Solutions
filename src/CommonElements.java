public class CommonElements {
    /**
     *
     * @param tab1 is a non null array
     * @param tab2 is a non null array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {i such that tab1[i] == tab2[i]}
     *         for instance count([1,3,5,5],[1,2,5,5,6]) = 3
     */
    public static int count(int [] tab1, int [] tab2) {
        int l = tab1.length < tab2.length ? tab1.length : tab2.length;
        int same = 0;
        for (int i = 0; i < l; i++) {
            if (tab1[i] == tab2[i]) {
                same ++;
            }
        }
        return same;
    }

    /**
     *
     * @param tab1 is a non null 2D array
     * @param tab2 is a non null 2D array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {(i,j) such that tab1[i][j] == tab2[i][j]}
     */
    public static int count(int [][] tab1, int [][] tab2) {
        int l1 = tab1.length < tab2.length ? tab1.length : tab2.length;
        int same = 0;
        for (int i = 0; i < l1; i++) {
            int l2 = tab1[i].length < tab2[i].length ? tab1[i].length : tab2[i].length;
            for (int j = 0; j < l2; j++) {
                if (tab1[i][j] == tab2[i][j]) {
                    same ++;
                }
            }
        }
        return same;
    }
}
