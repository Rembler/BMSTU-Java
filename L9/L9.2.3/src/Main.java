import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Collection<Person> people = Arrays.asList(
                new Person("Maria", 42),
                new Person("Ivan", 16),
                new Person("Petr", 23)
        );

        System.out.println(people);
        System.out.println(people.stream().sorted(Comparator.comparing(Person::getAge)).toList());
    }
}