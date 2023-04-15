package visitor.src.main.java;

public class Leaf implements Visitable {
    public int value;
    public Leaf(int val){
        value = val;
    }


    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
