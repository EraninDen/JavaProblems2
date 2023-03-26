package chapter_1;

import java.util.regex.Pattern;

public class ExampleJavaChapter1_16 {
    //Проверка наличия подстроки в строке
    //2 варианта

    public static void main(String[] args) {
        String text = "Hello world !!!";
        String substring = "orl";

        //boolean contains = text.contains(substring);
        System.out.println(contains(text, substring));
    }

//    public static boolean contains(String text, String subtext) {
//        return text.indexOf(subtext) != -1;
//    }

    public static boolean contains(String text, String substring) {
        return text.matches("(?i).*" + Pattern.quote(substring) + ".*");
    }
}
