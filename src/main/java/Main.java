import com.sun.jdi.Value;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Main {
    public static void main(String[] args) {

//        Integer[] nums = new Integer[]{1, 2, 5, 4, 4, 5, 2, 3, 6, 5};
//
//        System.out.println(transform(nums));
//        HashSet<Integer> hashSet = new HashSet<>(List.of(nums));

        System.out.println(testArithmeticException(0));


    }

    //1, 2, 5, 4, 4, 5, 2, 3, 6, 5

    public static Map<String, Long> transform(final Integer... nums) {

        List<String> list = new ArrayList<>();
        for (Integer num : nums) {
            if (num != 4 && num != 6) {
                list.add(num.toString());
            }
        }

        Map<String, Long> frequency =
                list.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()));

        frequency.forEach((k, v) -> System.out.println("<" + k + "-hello: " + v + ">"));
        return frequency;

//        return Arrays.stream(nums)
//                .filter(e -> e != 4 & e != 6)
//                .collect(groupingBy((s -> (s + "-hello: ")), counting()));
//                .entrySet()
//                .stream()
//                .sorted((e1, e2) -> {
//                    final String s1 = String.valueOf(e1.getKey());
//                    final String s2 = String.valueOf(e2.getKey());
//                    return s1.compareTo(s2);
//                })
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
    }

    public static Integer testArithmeticException (int x) throws RuntimeException {
        return 2/x;
    }
}

/*
List<String> list = Arrays.asList(
        "Франция", "Германия", "Монако", "Испания", "Италия",
        "Австрия", "Испания", "Монако", "Грузия", "Монако",
        "Испания", "Италия", "Монако", "Сингапур", "Армения");

Map<String, Long> frequency =
        list.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));

frequency.forEach((k, v) -> System.out.println(k + ": " + v));

_____________________________

//        Optional<List<String>> list = new ArrayList<>();
//         list = Optional.of((List<String>) Arrays.stream(nums));
//        Map<String,Long> result = new HashMap<>();
//                list = Optional.ofNullable((List<String>) list.stream().collect(groupingBy(
//                        Function.identity(), counting())));
//        result.forEach((k, v) -> System.out.println("<" + k + "-hello: " + v + ">"));
//        return result;




____________________________


 */

// map. get(key)


//                .distinct()
//
//                .filter(e -> e != 4 & e != 6)
//                .collect(Collectors.toMap(e -> new String(e + "-hello: "), Collectors.toCollection());
//        Arrays.stream(nums)
//                .filter(e -> e != 4 & e != 6)
//                .out::print();


        /*

        Map<String, Long> map3 = workers.stream()
       .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));

        static void task(final String input) {
    asList(
        requireNonNull(input, "input string can't be null")
            .toLowerCase()
            .split("[\\p{Blank}\\p{Punct}]+")
    )
        .stream()
        .collect(groupingBy(s -> s, counting()))
        .entrySet()
        .stream()
        .sorted(
            (e0, e1) -> {
                final int res = e1.getValue().compareTo(e0.getValue());
                return res == 0 ? e0.getKey().compareTo(e1.getKey()) : res;
            }
        )
        .limit(10)
        .forEach(System.out::println);
}

Map<Integer, String[]> collect = hashMap.entrySet().stream()
        .sorted((e1, e2) -> {
            final String s1 = e1.getValue()[e1.getValue().length - 1];
            final String s2 = e2.getValue()[e2.getValue().length - 1];
            return s2.compareTo(s1);
        })
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
         */


//<1-hello:1>

// преобразовать в мапу
//посчитать кол во повторений
//исключить 4 и 6
