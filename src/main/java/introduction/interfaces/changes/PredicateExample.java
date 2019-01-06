package introduction.interfaces.changes;

import java.util.function.Predicate;

public class PredicateExample {

    // Predicate Examples with new changes on interface
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 10;

        // New Default methods
        Predicate<String> p1AndP2 = p1.and(p2);

        System.out.println(p1AndP2.test("12Characters"));
        System.out.println(p1AndP2.test("25CharactersIsHereInPlace"));

        // Allow static methods
        Predicate<String> equalPredicate = Predicate.isEqual("ThisValue");

        System.out.println(equalPredicate.test("ThisValue"));
        System.out.println(equalPredicate.test("AnotherValue"));
    }

}