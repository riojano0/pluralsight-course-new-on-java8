package string_io_others_bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMergingExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                        .getResourceAsStream("people-bimap-example.txt"))));
             Stream<String> stream = bufferedReader.lines()) {

            stream
                    .map(line -> {
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
                        persons.add(p);
                        return p;
                    })
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------");
        List<Person> list1 = persons.subList(0, 7);
        List<Person> list2 = persons.subList(7, persons.size());

        Map<Integer, List<Person>> map1 = mapByAge(list1);
        System.out.println("Map 1");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));
        Map<Integer, List<Person>> map2 = mapByAge(list2);
        System.out.println("Map 2");
        map2.forEach((age, list) -> System.out.println(age + " -> " + list));


        map2.entrySet().stream()
                .forEach(
                        entry -> map1.merge(
                                entry.getKey(),
                                entry.getValue(),
                                (listInside1, listInside2) -> {
                                    listInside1.addAll(listInside2);
                                    return listInside1;
                                }
                        )
                );

        System.out.println("Map 1 merge on Map 2");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));
    }

    private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
        Map<Integer, List<Person>> map = list.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        return map;
    }

    static class Person {

        private String name;
        private int age;
        private String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

}
