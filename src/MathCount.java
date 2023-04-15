import java.util.ArrayList;

public class MathCount {
    private final int col;
    private final int row;

    public MathCount(int col, int row){
        this.col = col;
        this.row = row;
    }

    public boolean movePossible(int[] board, int move){
        return board[move]!=row;
    }

    public long number_to_fill(int[] board){
        ArrayList<Integer> possibleMove = new ArrayList<>();

        for (int i = 0; i < col; i++) {
            if(movePossible(board,i)){
                possibleMove.add(i);
            }
        }

        if(possibleMove.size()==0){
            return 0;
        } else if(possibleMove.size()==1){
            return 1;
        } else{
            long comb = 0;
            for(int j :possibleMove){
                int[] board2 = board.clone();
                board2[j]+=1;
                comb+=number_to_fill(board2);
            }
            return comb;
        }
    }

    public static void nonOpti(){
        int[] board = new int[]{0,0,0,0,0,0};
        MathCount counter = new MathCount(6,3);
        long result = counter.number_to_fill(board);
        System.out.println(result);
    }

    public static void opti() {
        int[] board1 = new int[]{2,0,0,0,0,0};
        MathCount counter = new MathCount(6,3);
        long result1 = counter.number_to_fill(board1);

        int[] board2 = new int[]{1,1,0,0,0,0};
        long result2 = counter.number_to_fill(board2);

        long finalResult = 6*(5*result2+result1);
        System.out.println(finalResult);
    }

    public static void opti2() {
        int[] board1 = new int[]{3,0,0,0,0,0};
        MathCount Counter = new MathCount(6,3);
        long result1 = Counter.number_to_fill(board1);

        int[] board2 = new int[]{2,1,0,0,0,0};
        long result2 = Counter.number_to_fill(board2);

        int[] board3 = new int[]{1,1,1,0,0,0};
        long result3 = Counter.number_to_fill(board3);

        long beforeMult = result1+result2+result3;

        long finalResult = 6*((result1+5*result2)+5*(4*result3+2*result2));

        System.out.println("Coefficient d'amelioration : " + (finalResult/beforeMult));
        System.out.println(finalResult);
    }

    public static void main(String[] args) {
        int[] board = new int[]{0,0,0,0};
        MathCount count = new MathCount(4,3);
        System.out.println(count.number_to_fill(board));
    }
}
