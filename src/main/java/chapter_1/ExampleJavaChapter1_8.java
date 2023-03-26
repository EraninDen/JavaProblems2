package chapter_1;

public class ExampleJavaChapter1_8 {
    //Удаление пробелов из строки

    public static void main(String[] args) {
        String s = "Hello world !!!";
        System.out.println(removeWhitespaces(s));
    }

    public static String removeWhitespaces(String str){
        return str.replaceAll("\\s", "");
    }
}
