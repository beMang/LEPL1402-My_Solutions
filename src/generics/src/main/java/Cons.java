public class Cons {
    // The item inside this list node
    public int v;
    // The next element, null if there is none
    public Cons next;

    // Returns a new Cons by applying function f on all elements
    public Cons map(F f) {
        Cons first = new Cons(f.apply(v),null); //Garder une trace
        Cons current_cons = this.next; //Lecture des éléments
        Cons previous = first; //Trace pour modifier le précédent

        while (current_cons!=null){
            previous.next = new Cons(f.apply(current_cons.v),null);
            previous = previous.next;
            current_cons = current_cons.next;
        }
        return first;
    }

    // Returns a new Cons containing all elements that match predicate p
    public Cons filter(P p) {
        Cons first = null; //Garder une trace
        Cons current_cons = this; //Lecture des éléments
        Cons previous = first; //Trace pour modifier le précédent

        while (current_cons!=null){
            if(p.filter(current_cons.v)){
                if(first==null){
                    first = new Cons(current_cons.v, null);
                    previous = first;
                } else{
                    previous.next = new Cons(current_cons.v, null);
                    previous = previous.next;
                }
            }
            current_cons = current_cons.next;
        }
        return first;
    }

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}