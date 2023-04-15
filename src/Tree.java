import java.util.List;
import java.util.Stack;

class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Node){
            return ((Node) o).val == this.val;
        } else {
            return false;
        }
    }
}

public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if (! (o instanceof Tree)){
            return false;
        }
        if(this.root==null || ((Tree) o).root==null){
            return this.root == ((Tree) o).root;
        }
        if(root.isLeaf() && ((Tree) o).root.isLeaf()){
            return root.equals(((Tree) o).root);
        } else if (!root.isLeaf() && !((Tree)o).root.isLeaf()) {
            Tree tree1right = new Tree(root.right);
            Tree tree2right = new Tree(((Tree) o).root.right);
            Tree tree1left = new Tree(root.left);
            Tree tree2left = new Tree(((Tree) o).root.left);
            return (tree1right.equals(tree2right) && tree1left.equals(tree2left));
        } else{
            return false;
        }
    }

    public Tree combineWith(Tree o){
        if(o == null || o.root ==null){
            return this;
        }
        if(this.root == null){
            return o;
        }
        return new Tree(combineNode(this.root, o.root));
    }

    private Node combineNode(Node x, Node y){
        if(x==null && y==null)
            return null;

        Node newNode = new Node(0);
        if(x==null){
            newNode.val = y.val;
            newNode.left = combineNode(null, y.left);
            newNode.right = combineNode(null, y.right);
        }
        else if(y==null){
            newNode.val = x.val;
            newNode.left = combineNode(x.left, null);
            newNode.right = combineNode(x.right, null);
        }
        else{
            newNode.val = x.val + y.val;
            newNode.left = combineNode(x.left, y.left);
            newNode.right = combineNode(x.right, y.right);
        }
        return newNode;
    }
}

class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if(root.isLeaf()){
            res.add(root.val);
        } else{
            if(root.left!=null){
                recursiveInorder(root.left,res);
            }
            res.add(root.val);
            if(root.right!=null){
                recursiveInorder(root.right,res);
            }
        }
    }


    public static void iterativeInorder(Node root, List<Integer> res){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current!=null||!stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
    }

}