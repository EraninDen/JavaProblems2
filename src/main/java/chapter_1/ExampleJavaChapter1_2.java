package chapter_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleJavaChapter1_2 {
    //отыскание первого неповторяющегося символа

    public static void main(String[] args) {
        String s = "Hello hello my wonderful world!!!";
        System.out.println(firstNonRepeatedCharacter(s));

    }

    public static String firstNonRepeatedCharacter(String str){
        str = str.toLowerCase();
        Map<Integer, Long> chs = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
