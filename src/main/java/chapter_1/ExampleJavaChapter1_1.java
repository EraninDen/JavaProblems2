package chapter_1;

import java.util.Map;
import java.util.stream.Collectors;

public class ExampleJavaChapter1_1 {
    // подсчёт повторяющихся символов
    // два варианта решения


    public static void main(String[] args) {

        String s = "Hello world!!!";
        ExampleJavaChapter1_1 example = new ExampleJavaChapter1_1();

        System.out.println(example.countDublicateCharacters(s));
    }

    public Map<Character, Long> countDublicateCharacters(String str) {
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;

    }

//    public Map<Character, Integer> countDublicateCharacters(String str) {
//        Map<Character, Integer> result = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
//        }
//        return result;
//    }
}
