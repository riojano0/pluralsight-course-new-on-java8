package streams_collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        List<String> list = new ArrayList<>();

        //This dont do anything because peek is a intermediary operation
        /*
        stream
                .peek(System.out::println)
                .filter(p1.or(p2))
                .peek(list::add);
        */

        //ForEach is a final operation
        stream
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(list::add);

        System.out.println("Done");
        System.out.println("Size = " + list.size());

    }

}
