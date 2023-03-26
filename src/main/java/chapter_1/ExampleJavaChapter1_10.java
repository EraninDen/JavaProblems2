package chapter_1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExampleJavaChapter1_10 {
    //генерирование всех перестановок
    //использовать Set т.к. List позволяет дублирование
    // 3 варианта

    public static void main(String[] args) {
        String s = "Hello";
        //permuteAndPrint(s);
        //System.out.println(permuteAndStore(s));
        permuteAndPrintStream(s);


    }
    public static void permuteAndPrintStream(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return;
        }

        permuteAndPrintStream("", str);

    }

    private static void  permuteAndPrintStream(String prefix, String str){
        int n = str.length();

        if(n == 0){
            System.out.println(prefix + " ");
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i),
                            str.substring(i + 1, n) + str.substring(0, i)));
        }

    }

//    public static Set<String> permuteAndStore(String str) {
//        return permuteAndStore("", str);
//    }
//
//    private static Set<String> permuteAndStore(String prefix, String str) {
//        Set<String> permutations = new HashSet<>();
//        int n = str.length();
//
//        if (n == 0){
//            permutations.add(prefix);
//        } else {
//            for (int i = 0; i < n; i++){
//                permutations.addAll(permuteAndStore(prefix + str.charAt(i),
//                        str.substring(i + 1, n) + str.substring(0, i)));
//            }
//        }
//        return permutations;
//    }

//    public static void permuteAndPrint(String str) {
//        permuteAndPrint("", str);
//    }
//
//    private static void permuteAndPrint(String prefix, String str) {
//        int n = str.length();
//
//        if (n == 0) {
//            System.out.println(prefix + " ");
//        } else {
//            for (int i = 0; i < n; i++) {
//                permuteAndPrint(prefix + str.charAt(i),
//                        str.substring(i + 1, n) + str.substring(0, i));
//            }
//        }
//    }
}
