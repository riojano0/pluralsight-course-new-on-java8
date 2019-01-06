package streams_collectors;

import streams_collectors.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapFilterReduce {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("A", 21));
        personList.add(new Person("B", 25));

        List<Integer> ages = new ArrayList<>();

        // We wan to compute "Average of the age of the people older than 20"

        // Steps
        // 1 - Mapping - List of person and return a list of integer, both list size are the same
        // 2 - Filtering - Takes list of integers and returns a lits of integer, but some elements have been filtered
        // 3 - Average(Reduction) - Equivalente to the SQL aggregation

        Stream<Person> stream = personList.stream();

        Consumer<Person> mappingConsumer = p -> ages.add(p.getAge());
        Consumer<Person> printerConsumer = System.out::println;
        stream.forEach(mappingConsumer.andThen(printerConsumer));

        Predicate<Person> personPredicate = person -> person.getAge() > 20;
        Stream<Person> filtered = stream.filter(personPredicate);

    }

}
