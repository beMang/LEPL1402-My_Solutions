import java.util.function.Function;

public abstract class FTree<A> {

    public final int depth() {
        if(left()==null && right()==null){
            return 0;
        } else{
            if(left()!=null){
                return 1+left().depth();
            } else {
                return 1+right().depth();
            }
        }
    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A,B> f) {
        B value = f.apply(this.value());
        if(this instanceof Leaf){
            return new Leaf<>(value);
        } else{
            return new Node<>(value,left().map(f),right().map(f));
        }
    }

}
