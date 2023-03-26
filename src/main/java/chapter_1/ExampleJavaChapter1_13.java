package chapter_1;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExampleJavaChapter1_13 {
    //удаление заданного символа
    //3 варианта

    public static void main(String[] args) {
        String s = "Hello my world !!!";

        System.out.println(removeCharacter(s, 'e'));
    }

//    public static String removeCharacter(String str, char ch){
//        return str.replaceAll(Pattern.quote(String.valueOf(ch)),"");
//    }

//    public static String removeCharacter(String str, char ch) {
//        StringBuilder sb = new StringBuilder();
//        char[] chArray = str.toCharArray();
//
//        for (char c : chArray) {
//            if(c !=ch){
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }

    public static String removeCharacter(String str, char ch) {
        return str.chars()
                .filter(c -> c != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
