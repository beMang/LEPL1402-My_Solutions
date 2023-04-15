package visitor.src.main.java;

public class Evaluation implements Visitor {
	@Override
	public int visit(Add visitable) {
		return (visitable.getLeft().accept(this)+visitable.getRight().accept(this));
	}

	@Override
	public int visit(Mult visitable) {
		return (visitable.getLeft().accept(this)*visitable.getRight().accept(this));
	}

	@Override
	public int visit(Div visitable) {
		int denom = visitable.getRight().accept(this);
		if(denom==0){
			throw new IllegalArgumentException("Div by zero");
		}
		return (visitable.getLeft().accept(this)/denom);
	}

	@Override
	public int visit(Sub visitable) {
		return (visitable.getLeft().accept(this)-visitable.getRight().accept(this));
	}

	@Override
	public int visit(Leaf visitable) {
		return visitable.value;
	}
}
