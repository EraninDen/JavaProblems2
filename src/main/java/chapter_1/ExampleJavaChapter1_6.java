package chapter_1;

public class ExampleJavaChapter1_6 {
    //подсчет появлений некоторого символа
    // два варианта

    public static void main(String[] args) {
        String s = "Hello my beautiful World!!!";

        System.out.println(countOccurrencesOfACertainCharacter(s, 'l'));
    }


    public static Long countOccurrencesOfACertainCharacter(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

//    public static int countOccurrencesOfACertainCharacter(String str, char ch){
//        return str.length()-str.replace(String.valueOf(ch), "").length();
//    }
}
