package string_io_others_bits;

import java.util.Comparator;

public class ComparatorExample {

    static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    public static void main(String[] args) {
        // Old Way with anonymous class
        // We can have NPE
        // And is hard to chain
        Comparator<Person> compareLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };

        Comparator<Person> compareLastNameAndFirstName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int lastNameComparison = o1.getLastName().compareTo(o2.getLastName());
                return lastNameComparison == 0 ?
                        o1.getFirstName().compareTo(o2.getFirstName()) : lastNameComparison;
            }
        };

        // New way
        Comparator<Person> compareLastName2 = Comparator.comparing(Person::getLastName);

        Comparator<Person> compareLastNameAndFirstName2 = Comparator
                .comparing(Person::getLastName)
                .thenComparing(Person::getFirstName);

        Comparator<Person> compareLastNameAndFirstNameReversed = Comparator
                .comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .reversed();

        // Consider null values lesser than non-null values
        Comparator<String> c = Comparator.nullsFirst(Comparator.naturalOrder());
        }
}
