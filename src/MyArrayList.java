import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object [] list;
    private int size;


    public MyArrayList(int initSize){
        if(initSize>0){
            size = 0;
            list = new Object[initSize];
        } else {
            throw new IndexOutOfBoundsException("Index smaller than zero");
        }
    }


    /*
     * Checks if 'list' needs to be resized then add the element at the end
     * of the list.
     */
    public void enqueue(Item item){
        if (size +1 < list.length) {
            list[size()] = item;
        } else {
            Object[] clone = list.clone();
            list = new Object[clone.length*2];
            for (int i = 0; i < size; i++) {
                list[i] = clone[i];
            }
            list[size] = item;
        }
        size++;
    }


    /*
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list. You dont need to
     * resize when removing an element.
     */
    public Item remove(int index){
        if(index<0 || index>size-1){
            throw new IndexOutOfBoundsException("Out of bound");
        } else {
            Item deleted = (Item) list[index];
            list[index] = null;
            for (int i = index; i < size; i++) {
                list[i] = list[i+1];
            }
            size--;
            return deleted;
        }
    }


    public int size(){
        return this.size;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        private int index = 0;
        private final int nInit = size;
        @Override
        public boolean hasNext() {
            failFastCheck();
            return size != 0 && index < size;
        }

        private void failFastCheck(){
            if (nInit!=size){
                throw new ConcurrentModificationException("Modification pendant itération");
            }
        }
        @Override
        public Item next() {
            if(hasNext()){
                Item toReturn =  (Item) list[index];
                index ++;
                return toReturn;
            } else {
                throw new NoSuchElementException("Plus d'élément");
            }
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<Integer>(5);

        for (int i = 0; i <= 50; i++) {
            test.enqueue(i);
        }

        Iterator<Integer> it = test.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        test.remove(3);
        it = test.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}