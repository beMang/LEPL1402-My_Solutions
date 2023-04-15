import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Person{
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + age;
        }

        public static void main(String[] args) {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person("Guillaume",20));
            persons.add(new Person("John",50));
            persons.add(new Person("Guillaume",10));
            persons.add(new Person("John",10));
            persons.add(new Person("Luc",5));
            persons.add(new Person("Adrien",19));

            sortPerson(persons);
            System.out.println(Arrays.toString(persons.toArray()));
        }

    private static void sortPerson(ArrayList<Person> persons) {
            class SortByName implements Comparator<Person> {

                @Override
                public int compare(Person o1, Person o2) {
                    int comparaison = o1.name.compareTo(o2.name);
                    if (comparaison == 0) {
                        return o1.age - o2.age;
                    } else {
                        return comparaison;
                    }
                }
            }
            persons.sort(new SortByName());
    }
}
