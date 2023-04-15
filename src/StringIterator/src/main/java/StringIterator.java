import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


/**
 * Question:
 *
 * You are asked to implement an IterableString allowing
 * to iterate on the successive chars of a given string
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 *
 */
public class StringIterator {

    /**
     * Factory method
     * @param s the string on which to iterate
     * @return a new instance of your implementation of an IterableString allowing to iterate on s
     */
    public static IterableString makeIterableString(String s) {
        return new MyString(s);
    }

    /**
     * An IterableString permit to iterate on each character of a
     * string one by one from left to right
     */
    public interface IterableString extends Iterable<Character> {}

    static class MyString implements IterableString{
        String s;

        MyString(String s){
            this.s = s;
        }

        @Override
        public Iterator<Character> iterator() {
            return new Iterator<Character>() {
                int position = 0;
                @Override
                public boolean hasNext() {
                    return !(position>=s.length());
                }

                @Override
                public Character next() {
                    char c = s.charAt(position);
                    position++;
                    return c;
                }
            };
        }
    }
}
