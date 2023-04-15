public class FListMerge {

    /*
     * This method receives an FList and returns a new FList containing the same values but sorted in ascending order.
     *
     */
    public static FList<Integer> mergeSort(FList<Integer> fList){
        if(fList.length()==1){
            return fList;
        }
        if(fList.isEmpty()){
            return fList;
        }

        FList<Integer> A = FList.nil();
        for (int i = 0; i < fList.length() / 2; i++) {
            A = A.cons(fList.head());
            fList = fList.tail();
        }
        A = reversed(A);
        return sort2OrderedSubList(mergeSort(A),mergeSort(fList));
    }

    public static FList<Integer> sort2OrderedSubList(FList<Integer> A, FList<Integer> B){
        FList<Integer> result = FList.nil();
        while(!A.isEmpty() && !B.isEmpty()){
            if(A.head()<=B.head()){
                result = result.cons(A.head());
                A = A.tail();
            } else{
                result = result.cons(B.head());
                B = B.tail();
            }
        }

        //Check wich list hasn't been entirely read :
        if(!A.isEmpty()){
            while (!A.isEmpty()){
                result = result.cons(A.head());
                A = A.tail();
            }
        } else{
            while (!B.isEmpty()){
                result = result.cons(B.head());
                B = B.tail();
            }
        }

        return reversed(result);
    }

    public static FList<Integer> reversed(FList<Integer> toInverse){
        FList<Integer> inverse = FList.nil();
        while (!toInverse.isEmpty()){
            inverse = inverse.cons(toInverse.head());
            toInverse = toInverse.tail();
        }
        return inverse;
    }
}