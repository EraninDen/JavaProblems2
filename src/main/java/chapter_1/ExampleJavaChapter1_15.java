package chapter_1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ExampleJavaChapter1_15 {
    //Сортировка массива строк по длине
    //3 варианта

    public static void main(String[] args) {
        String[] ss = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};

        System.out.println(Arrays.toString(ss));
        sortArrayByLength(ss, Sort.ASC);
        String[] sss = sortArrayByLength(ss, Sort.ASC);
        System.out.println(Arrays.toString(sss));
    }

    public enum Sort {
        ASC, DESC
    }

    public static String[] sortArrayByLength(String[] strs, Sort direction) {
        if (direction.equals(Sort.ASC)) {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }
    }

//    public static void sortArrayByLength(String[] strs, Sort direction) {
//        if (direction.equals(Sort.ASC)) {
//            Arrays.sort(strs, Comparator.comparingInt(String::length));
//        } else {
//            Arrays.sort(strs, Comparator.comparingInt(String::length));
//        }
//    }

//    public static void sortArrayByLength(String[] strs, Sort direction){
//        if (direction.equals(Sort.ASC)) {
//            Arrays.sort(strs, (String s1, String s2)
//            -> Integer.compare(s1.length(), s2.length()));
//        } else {
//            Arrays.sort(strs, (String s1, String s2)
//        -> (-1) * Integer.compare(s1.length(), s2.length()));
//        }
//    }
}
