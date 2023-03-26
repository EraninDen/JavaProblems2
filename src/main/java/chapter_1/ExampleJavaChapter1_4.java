package chapter_1;

public class ExampleJavaChapter1_4 {
    // Проверка содержит ли строка только цифры
    //два решения: Character.isDigit() && String.matches()

    public static void main(String[] args) {
        String s = "123";
        System.out.println(containsOnlyDigits(s));
    }

    public static boolean containsOnlyDigits(String str){
        return str.matches("[0-9]+");
    }

//    public static boolean containsOnlyDigits(String str){
//        return !str.chars()
//                .anyMatch(n-> !Character.isDigit(n));
//    }


//    public static boolean containsOnlyDigits(String str){
//        for(int i = 0; i < str.length();i++){
//            if(!Character.isDigit(str.charAt(i))){
//                return false;
//            }
//        }
//
//        return true;
//    }


}
