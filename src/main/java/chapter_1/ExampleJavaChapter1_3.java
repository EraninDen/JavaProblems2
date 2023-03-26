package chapter_1;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExampleJavaChapter1_3 {
    //Инвертирование букв и слов
    //три варианта решения - в первых двух буквы инвертированы, но слова в том же порядке
    //в третьем инвертируется все: и слова, и буквы
    private  static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public static void main(String[] args) {
        String s = "Hello hello my madness world !!!";
        ExampleJavaChapter1_3 example = new ExampleJavaChapter1_3();


       // System.out.println(example.reverseWord(s));
       // System.out.println(reverseWords(s));
        System.out.println(example.reverse(s));
    }

    public String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

//    public static  String reverseWords(String str){
//        return PATTERN.splitAsStream(str)
//                .map(w-> new StringBuilder(w).reverse())
//                .collect(Collectors.joining(" "));
//    }

//    public String reverseWord(String str){
//        String[] words = str.split(WHITESPACE);
//        StringBuilder reversedString = new StringBuilder();
//
//        for(String word: words){
//            StringBuilder reverseWord = new StringBuilder();
//
//            for(int i = word.length()-1; i>=0; i--){
//                reverseWord.append(word.charAt(i));
//            }
//
//            reversedString.append(reverseWord).append(WHITESPACE);
//        }
//
//        return reversedString.toString();
//    }
}
