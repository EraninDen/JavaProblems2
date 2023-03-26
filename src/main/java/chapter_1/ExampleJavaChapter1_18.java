package chapter_1;

public class ExampleJavaChapter1_18 {
    //Проверка являются ли две строки анаграммами

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "llohe";

        System.out.println(isAnagram(s1, s2));
    }
    private static final int EXTENDED_ASCII_CODES = 256;

    public static boolean isAnagram(String str1, String str2) {
        int[] chCounts = new int[EXTENDED_ASCII_CODES];
        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (chStr1.length != chStr2.length) {
            return false;
        }

        for (int i = 0; i < chCounts.length; i++) {
            if (chCounts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}






