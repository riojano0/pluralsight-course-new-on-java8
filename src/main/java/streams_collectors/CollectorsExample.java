package streams_collectors;

import streams_collectors.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                                .getResourceAsStream("people-example.txt"))));
                Stream<String> stringStream = reader.lines()
        ) {

            stringStream
                    .map(line -> {
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                        personList.add(p);
                        return p;
                    })
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<Person> personStream = personList.stream();

        Optional<Person> minPersonMajorThan20 = personStream
                .filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println(minPersonMajorThan20);

        Optional<Person> maxPersonMajorThan20 = personList.stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println(maxPersonMajorThan20);

        Map<Integer, List<Person>> collect = personList.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge
                        )
                );
        System.out.println(collect);

        Map<Integer, Long> collect2 = personList.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()
                        )
                );
        System.out.println(collect2);

        Map<Integer, List<String>> collect3 = personList.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(collect3);

        Map<Integer, String> collect4 = personList.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.joining(", ")
                                )
                        )
                );
        System.out.println(collect4);
    }

}
