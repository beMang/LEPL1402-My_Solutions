import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){
    Predicate<Student> follow_course = student -> student.getCoursesResults().containsKey(name);

    Student[] result = (Student[]) studentStream.filter(follow_course).sorted(Comparator.comparingDouble(std->std.getCoursesResults().get(name))).toArray();
    return Stream.of(result[result.length-2],result[result.length-3]);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    return studentStream.filter(s->s.getSection()==section).map(std->new Object[]{
            String.format("Student %s %s", std.getFirstName(), std.getLastName()),
            std.getCoursesResults().values().stream().reduce(0.0,Double::sum)/std.getCoursesResults().values().size()
    }).toArray();
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
    Predicate<Student> has_passed = student -> {
      boolean passed = true;
      for (double value : student.getCoursesResults().values()){
        if (value<=10.0){
          passed = false;
        }
      }
      return passed;
    };

    return (int) studentStream.filter(has_passed).count();
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
    return studentStream.max(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName)).get();
  }

  public double getFullSum(Stream<Student> studentStream){
    return studentStream.map((s)->s.getCoursesResults().values().stream().reduce(0.0, Double::sum)).reduce(0.0, Double::sum);
  }
}
