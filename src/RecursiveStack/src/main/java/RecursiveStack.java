import java.util.ArrayList;

/**
 * Question:
 *
 * You are asked to implement the abstract data type RecursiveStack below.
 *
 * Your implementation can be an inner static class or a class below.
 * The factory method "makeRecursiveStack" returns a new instance of your implementation
 *
 * Once it is done, copy-paste the complete file in Inginious also with the imports
 *
 *
 * Feel free to add classes, methods or fields in the class but do not modify
 * the signature of existing code
 *
 */
public interface RecursiveStack {

    /**
     * Factory method
     * @return a new instance of your implementation of RecursiveStack
     */
    public static RecursiveStack makeRecursiveStack() {
        return new MyStack(new ArrayList<>());
    }


    int size();

    int top();

    RecursiveStack removeTop();

    RecursiveStack addTop(int v);

    static class MyStack implements RecursiveStack{
        ArrayList<Integer> stack;

        MyStack(ArrayList<Integer> numbers){
            stack = numbers;
        }

        @Override
        public int size() {
            return stack.size();
        }

        @Override
        public int top() {
            return stack.get(stack.size()-1);
        }

        @Override
        public RecursiveStack removeTop() {
            ArrayList<Integer> copy = (ArrayList<Integer>) stack.clone();
            copy.remove(stack.size()-1);
            return new MyStack(copy);
        }

        @Override
        public RecursiveStack addTop(int v) {
            ArrayList<Integer> copy = (ArrayList<Integer>) stack.clone();
            copy.add(v);
            return new MyStack(copy);
        }
    }
}

