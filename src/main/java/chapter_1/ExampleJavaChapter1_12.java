package chapter_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ExampleJavaChapter1_12 {
    //Удаление повторяющихся символов
    //3 варианта решения

    public static void main(String[] args) {
        String s = "Hello my new world !!!";

        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String str){
        return Arrays.asList(str.split("")).stream()
                .distinct()
                .collect(Collectors.joining());
    }


//    public static String removeDuplicates(String str) {
//        char[] chArray = str.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        Set<Character> chHashSet = new HashSet<>();
//
//        for (char c : chArray) {
//            if(chHashSet.add(c)){
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }


//    public static String removeDuplicates(String str) {
//        char[] chArray = str.toCharArray(); // или использовать charAt(i)
//        StringBuilder sb = new StringBuilder();
//
//        for (char ch : chArray) {
//            if(sb.indexOf(String.valueOf(ch)) == -1){
//                sb.append(ch);
//            }
//        }
//        return sb.toString();
//    }
}
