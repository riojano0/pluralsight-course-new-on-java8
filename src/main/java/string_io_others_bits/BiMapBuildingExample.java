package string_io_others_bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiMapBuildingExample {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                        .getResourceAsStream("people-bimap-example.txt"))));
             Stream<String> stream = bufferedReader.lines()) {
            stream
                    .map(line -> {
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
                        personList.add(p);
                        return p;
                    }).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Map");
        Map<Integer, List<Person>> map = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        map.forEach((age, list) -> System.out.println(age + " -> " + list));

        Map<Integer, Map<String, List<Person>>> bimap = new HashMap<>();

        personList.forEach(
                person -> {
                    bimap.computeIfAbsent(
                            person.getAge(),
                            HashMap::new
                    ).merge(
                            person.getGender(),
                            new ArrayList<>(Collections.singletonList(person)),
                            (list1, list2) -> {
                                list1.addAll(list2);
                                return list1;
                            }
                    );
                }
        );

        System.out.println("BiMap");
        bimap.forEach(
                (age, insideMap) -> System.out.println(age + " -> " + insideMap)
        );

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
