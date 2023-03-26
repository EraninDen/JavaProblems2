package chapter_1;

//import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

//public class ExampleJavaChapter1_14 {
//    //Отыскание символа с наибольшим числом появлений
//    //2 варианта
//
//    public static void main(String[] args) {
//        String s = "Hello my beautiful world !";
//
//        System.out.println(maxOccurrenceCharacter(s));
//    }
//
//    public static Pair<Character, Long> maxOccurrenceCharacter(String str) {
//        return str.chars()
//                .filter(c -> !Character.isWhitespace(c))
//                .mapToObj(c -> (char) c)
//                .collect(groupingBy(c -> c, counting()))
//                .entrySet()
//                .stream()
//                .max(comparingByValue())
//                .map(p -> Pair.of(p.getKey(), p.getValue()))
//                .orElse(Pair.of(Character.MIN_VALUE, -1L));
//    }

//    public static Pair<Character, Integer> maxOccurrenceCharacter(String str) {
//        Map<Character, Integer> counter = new HashMap<>();
//        char[] chStr = str.toCharArray();
//
//        for (int i = 0; i < chStr.length; i++) {
//            char currentCh = chStr[i];
//            if (!Character.isWhitespace(currentCh)) {  //игнорирование пробелов
//                Integer noCh = counter.get(currentCh);
//                if (noCh == null) {
//                    counter.put(currentCh, 1);
//                } else {
//                    counter.put(currentCh, ++noCh);
//                }
//            }
//        }
//
//        int maxOccurrences = Collections.max(counter.values());
//        char maxCharacter = Character.MIN_VALUE;
//
//        for (Map.Entry<Character, Integer> entry: counter.entrySet()){
//            if (entry.getValue() == maxOccurrences){
//                maxCharacter = entry.getKey();
//            }
//        }
//        return Pair.of(maxCharacter,maxOccurrences);
//    }
//}
