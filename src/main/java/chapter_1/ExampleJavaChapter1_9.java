package chapter_1;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ExampleJavaChapter1_9 {
    //соединение нескольких строк с помощью разделителя
    // 3 варианта

    public static void main(String[] args) {
        String[] s = {"Hello", "my", "new", "world", "!!!"};

        System.out.println(joinByDelimiter(' ', s));
    }

    public static String joinByDelimiter(char delimiter, String... args) {
        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }

//    public static String joinByDelimiter(char delimiter, String... args) {
//        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));
//
//        for (String arg : args) {
//            joiner.add(arg);
//        }
//
//        return joiner.toString();
//    }

//    public static String joinByDelimiter(char delimiter, String...args){
//        StringBuilder result = new StringBuilder();
//
//        int i = 0;
//        for(i = 0; i< args.length-1;i++){
//            result.append(args[i]).append(delimiter);
//        }
//        result.append(args[i]);
//
//        return result.toString();
//    }
}
