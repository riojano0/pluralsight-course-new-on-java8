package string_io_others_bits;

import java.util.StringJoiner;

public class StringExample {

    //StringJoiner come with JDK 8
    public static void main(String[] args) {
        StringJoiner joinedString = new StringJoiner(", ");
        joinedString.add("One").add("Two");
        System.out.println(joinedString);

        StringJoiner joinedString2 = new StringJoiner(", ", "{", "}");
        joinedString2.add("One").add("Two");
        System.out.println(joinedString2);

        StringJoiner joinedString3 = new StringJoiner(", ", "{", "}");
        System.out.println(joinedString3);

        String joinedString4 = String.join(", ", "one", "two");
        System.out.println(joinedString4);

        String[] strings = {"one", "two"};
        String joinedString5 = String.join(", ", strings);
        System.out.println(joinedString5);
    }

}
