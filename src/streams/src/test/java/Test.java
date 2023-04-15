import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		Student[] test = new Student[]{
				new Student("Zwdrien","ZWntonutti",2,new HashMap<>()),
				new Student("Zzuel","Zantonutti",0,new HashMap<>()),
				new Student("Victor","Antonutti", 0,new HashMap<>())
		};

		Stream stream = Arrays.stream(test);

		StudentFunctions functions = new StudentFunctions();
		System.out.println(functions.findLastInLexicographicOrder(stream).getFirstName());
	}
}
