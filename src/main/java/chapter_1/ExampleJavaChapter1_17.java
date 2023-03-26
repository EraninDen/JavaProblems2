package chapter_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleJavaChapter1_17 {
    //подсчет числа появлений подстроки в строке
    //2 интерпретации
    // 11 в 111 - появляется 1 раз (2 варианта)
    // 11 в 111 - появляется 2 раза (1 вариант)

    public static void main(String[] args) {
        String s = "111";

        System.out.println(countStringInString(s, "11"));
    }

    public static int countStringInString(String string, String toFind) {
        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);

        int position = 0;
        int count = 0;

        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }
        return count++;
    }

//    public static int countStringInString(String string, String toFind) {
//        int result = string.split(Pattern.quote(toFind), -1).length -1;
//        return result < 0 ? 0 : result;
//    }

//    public static int countStringInString(String string, String toFind) {
//        int position = 0;
//        int count = 0;
//        int n = toFind.length();
//
//        while ((position = string.indexOf(toFind, position)) != -1) {
//            position = position + n;
//            count++;
//        }
//        return count;
//    }
}
