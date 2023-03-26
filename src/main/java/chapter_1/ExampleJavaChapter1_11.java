package chapter_1;

import java.util.stream.IntStream;

public class ExampleJavaChapter1_11 {
    //Проверка на палиндром
    //3 варианта

    public static void main(String[] args) {
        //String s = "Hello my world !!!";
        String s = "1234321";

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String str){
        return IntStream.range(0, str.length() / 2)
                .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }

//    public static boolean isPalindrome(String str) {
//        int n = str.length();
//
//        for (int i = 0; i < n / 2; i++) {
//            if (str.charAt(i) != str.charAt(n - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }


//    public static boolean isPalindrome(String str){
//        return str.equals(new StringBuilder(str).reverse().toString());
//    }
}
