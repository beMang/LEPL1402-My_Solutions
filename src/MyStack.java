import java.util.LinkedList;

public class MyStack<E> {

    private LinkedList<E> queue;

    /*
     * Constructor
     */
    public MyStack() {
        this.queue = new LinkedList<E>();
    }

    /**
     * Push an element on the stack
     *
     * @param elem the Element to push
     */
    public void push(E elem) {
        queue.add(elem);
    }

    /**
     * Remove the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E pop() {
        if (empty()) {
            return null;
        } else {
            return queue.remove(queue.size() -1);
        }
    }

    /**
     * Look at the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E peek() {
        if (empty()) {
            return null;
        } else {
            E last = pop();
            queue.add(last);
            return last;
        }
    }

    /**
     * Is the stack empty
     *
     * @return True if there is no element in the stack
     *         and false otherwise
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}