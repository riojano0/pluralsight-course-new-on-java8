package streams_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 10, 10);
        Integer sum = list.stream()
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        List<Integer> list2 = Arrays.asList(-10,-15);
        Integer maxWrong = list2.stream()
                .reduce(0, Integer::max);
        System.out.println("Wrong identity on Max = " + maxWrong);

        List<Integer> list3 = Arrays.asList();
        Optional<Integer> maxOptional = list3.stream()
                .reduce(Integer::max);
        System.out.println("Identity on Max = " + maxOptional);
    }

}
