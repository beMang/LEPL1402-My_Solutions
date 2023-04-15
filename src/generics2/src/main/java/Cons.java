import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // The item inside this list node
    public E v;
    // The next element, null if there is none
    public Cons<E> next;

    // Returns a new Cons by applying Function function on all elements
    public <R> Cons <R> map(Function <E,R> function) {
        Cons<R> first = new Cons<>(function.apply(v),null); //Garder une trace
        Cons<E> current_cons = this.next; //Lecture des éléments
        Cons<R> previous = first; //Trace pour modifier le précédent

        while (current_cons!=null){
            previous.next = new Cons<R>(function.apply(current_cons.v),null);
            previous = previous.next;
            current_cons = current_cons.next;
        }
        return first;
    }
    // Returns a new Cons containing all elements that match Predicate predicate
    public Cons <E> filter(Predicate <E> predicate) {
        Cons<E> first = null; //Garder une trace
        Cons<E> current_cons = this; //Lecture des éléments
        Cons<E> previous = first; //Trace pour modifier le précédent

        while (current_cons!=null){
            if(predicate.test(current_cons.v)){
                if(first==null){
                    first = new Cons<>(current_cons.v, null);
                    previous = first;
                } else{
                    previous.next = new Cons<>(current_cons.v, null);
                    previous = previous.next;
                }
            }
            current_cons = current_cons.next;
        }
        return first;
    }

    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }
}
