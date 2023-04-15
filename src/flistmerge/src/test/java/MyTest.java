public class MyTest {
	public static void main(String[] args) {


		FList<Integer> fl2 = FList.nil();
		fl2 = fl2.cons(799);
		fl2 = fl2.cons(5);
		fl2 = fl2.cons(0);
		fl2 = fl2.cons(400);
		fl2 = fl2.cons(-4000);
		fl2 = fl2.cons(200);
		fl2 = fl2.cons(-6);


		FList<Integer> result = FListMerge.mergeSort(fl2);
		result.print();
	}
}
