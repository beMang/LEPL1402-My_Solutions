import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> lst = new ArrayList<Integer>();
		add(lst,0);

		System.out.println(lst);
	}

	public static void add(ArrayList<Integer> lst, int i){
		if(i==5){
			lst.add(i);
		} else {
			add(lst,i+1);
			lst.add(i);
		}
	}
}
