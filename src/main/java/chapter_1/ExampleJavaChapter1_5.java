package chapter_1;


//import org.apache.commons.lang3.tuple.Pair;


import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class ExampleJavaChapter1_5 {
    //Подсчет гласных и согласных (английский язык)
    //два варианта

//    private static final Set<Character> allVowels
//            = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
//
//    public static void main(String[] args) {
//        String s = "Hello my World";
//
//        System.out.println(countVowelsAndConsonants(s));
//    }
//
//    public static Pair<Long, Long> countVowelsAndConsonants(String str) {
//        str = str.toLowerCase();
//
//        Map<Boolean, Long> result = str.chars()
//                .mapToObj(c->(char) c)
//                .filter(ch-> (ch >= 'a' && ch <='z'))
//                .collect(partitioningBy(c-> allVowels.contains(c), counting()));
//
//        return Pair.of(result.get(true), result.get(false));
//
//    }


//    public static Pair<Integer, Integer> countVowelsAndConsonants(String str){
//        str = str.toLowerCase();
//        int vowels = 0;
//        int consonants = 0;
//
//        for(int i = 0; i < str.length(); i++){
//            char ch = str.charAt(i);
//            if(allVowels.contains(ch)){
//                vowels++;
//            } else if ((ch>='a' && ch<='z')){
//                consonants++;
//            }
//        }
//        return Pair.of(vowels, consonants);
//    }
}
