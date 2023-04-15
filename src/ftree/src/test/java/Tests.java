import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.Random;

import static org.junit.Assert.*;


public class Tests {

    private static Random rng = new Random();

    public static int randomInt(){
        return rng.nextInt(100);
    }

    public static int fTreeSum(FTree<Integer> ft){
        if(ft instanceof Node){
            return ft.value() + fTreeSum(ft.left()) + fTreeSum(ft.right());
        }
        return ft.value();
    }

    @Test()
    public void testSimpleMap(){

        FTree<Integer> root;
        FTree[] firstStage = new FTree[2];
        FTree[] secondStage = new FTree[4];
        FTree[] thirdStage = new FTree[8];
        FTree[] fleafs = new FTree[16];

        for(int i = 0 ; i < 16 ; i++){
            fleafs[i] = new Leaf(1+(2*i));
        }

        for(int i = 0; i<8 ; i++){
            thirdStage[i] = new Node<Integer>(2 + i*4, fleafs[i*2], fleafs[i*2+1]);
        }

        for(int i = 0 ; i <4 ; i++){
            secondStage[i] = new Node<Integer>(((i*8)+4), thirdStage[i*2], thirdStage[i*2+1]);
        }

        firstStage[0] = new Node<Integer>(8, secondStage[0], secondStage[1]);
        firstStage[1] = new Node<Integer>(24, secondStage[2], secondStage[3]);

        root = new Node<Integer>(16, firstStage[0], firstStage[1]);

        FTree<Integer> result = root.map(i -> i*10);

        assertEquals(4960, fTreeSum(result) );



    }

    @Test()
    public void testRandomMap(){

        int elemSum = 0 ;
        int r;

        FTree<Integer> root;
        FTree[] firstStage = new FTree[2];
        FTree[] secondStage = new FTree[4];
        FTree[] thirdStage = new FTree[8];
        FTree[] fleafs = new FTree[16];
        for(int i = 0 ; i < 16 ; i++){
            r = randomInt();
            elemSum += r;
            fleafs[i] = new Leaf(r);
        }

        for(int i = 0; i<8 ; i++){
            r = randomInt();
            elemSum += r;
            thirdStage[i] = new Node<Integer>(r, fleafs[i*2], fleafs[i*2+1]);
        }

        for(int i = 0 ; i <4 ; i++){
            r = randomInt();
            elemSum += r;
            secondStage[i] = new Node<Integer>(r, thirdStage[i*2], thirdStage[i*2+1]);
        }

        r = randomInt();
        elemSum += r;
        firstStage[0] = new Node<Integer>(r, secondStage[0], secondStage[1]);

        r = randomInt();
        elemSum += r;
        firstStage[1] = new Node<Integer>(r, secondStage[2], secondStage[3]);

        r = randomInt();
        elemSum += r;
        root = new Node<Integer>(r, firstStage[0], firstStage[1]);

        FTree<Integer> result = root.map(i -> i*10);

        assertEquals(elemSum*10, fTreeSum(result) );


    }

    @Test()

    public void testDepth(){


        FTree<Integer> root;
        FTree[] firstStage = new FTree[2];
        FTree[] secondStage = new FTree[4];
        FTree[] thirdStage = new FTree[8];
        FTree[] fleafs = new FTree[16];
        for(int i = 0 ; i < 16 ; i++){
            fleafs[i] = new Leaf(1);
        }

        for(int i = 0; i<8 ; i++){
            thirdStage[i] = new Node<Integer>(1, fleafs[i*2], fleafs[i*2+1]);
        }

        for(int i = 0 ; i <4 ; i++){
            secondStage[i] = new Node<Integer>(1, thirdStage[i*2], thirdStage[i*2+1]);
        }

        firstStage[0] = new Node<Integer>(1, secondStage[0], secondStage[1]);
        firstStage[1] = new Node<Integer>(1, secondStage[2], secondStage[3]);

        root = new Node<Integer>(1, firstStage[0], firstStage[1]);

        assertEquals(4, root.depth());


    }

    @Test()
    public void testLeaf() throws Exception {

        FTree<Integer> l = new Leaf(1);

        if(null!=l.left()) throw new Exception("left() on a leaf should return null");

        if(null!=l.right()) throw new Exception("right() on a leaf should return null");

        if(1!=l.value()) throw new Exception("The value returned by value() is not the one given to the constructor");

        assertEquals(null, l.left());
        assertEquals(null, l.right());


    }

    @Test()
    public void testNode() throws Exception{

        FTree<Integer> l = new Leaf(1);
        FTree<Integer> r = new Leaf(3);
        FTree<Integer> n = new Node(2, l, r);

        if(l!=n.left()) throw new Exception("left() on a leaf should return the child");

        if(r!=n.right()) throw new Exception("right() on a leaf should return the child");

        if(2!=n.value()) throw new Exception("The value returned by value() is not the one given to the constructor");

        assertEquals(l, n.left());
        assertEquals(r, n.right());


    }

}
