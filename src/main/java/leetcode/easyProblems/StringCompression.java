package leetcode.easyProblems;

import java.util.Arrays;

public class StringCompression {

//    public static int compress(char[] chars) {
//        int ans = 0;
//
//        for (int i = 0; i < chars.length; ) {
//            final char letter = chars[i];
//            int count = 0;
//
//            while (i < chars.length && chars[i] == letter) {
//                ++count;
//                ++i;
//            }
//            chars[ans++] = letter;
//            if (count > 1) {
//                for (final char c : String.valueOf(count).toCharArray()) {
//                    chars[ans++] = c;
//                }
//            }
//        }
//        return ans;
//    }

//    public static int compress(char[] chars) {
//        int n = chars.length;
//        if (n == 1) {
//            return 1;
//        }
//
//        int i = 0, j = 0;
//        while (i < n) {
//            int count = 1;
//            while (i < n - 1 && chars[i] == chars[i + 1]) {
//                count++;
//                i++;
//            }
//
//            chars[j++] = chars[i++];
//            if (count > 1) {
//                String countStr = String.valueOf(count);
//                for (int k = 0; k < countStr.length(); k++) {
//                    chars[j++] = countStr.charAt(k);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(chars));
//
//        return j;
//    }




    public static int compress3(char[] chars) {
        int p1 = 0;
        int p2 = 0;
        StringBuilder ans = new StringBuilder();
        while (p1 < chars.length && p2 < chars.length) {
            int count = 0;
            while (p2 < chars.length && chars[p1] == chars[p2]) {
                count++;
                p2++;
            }
            ans.append(chars[p1]);
            p1 = p2;
            if (count > 1) {
                ans.append(count);
            }
        }
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }
        System.out.println(Arrays.toString(chars));
        return ans.length();
    }

    public static void main(String[] args) {

        char[] charsInput = new char[]{
                'b', 'b', 'b', 'a', 'a', 'o', 'b', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'
        };
        char[] charsInput2 = new char[]{
                'b', 'b', 'b', 'a', 'a', 'o', 'b', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'
        };
        System.out.println("/");
        System.out.println(compress3(charsInput2));
        System.out.println("/");

        //System.out.println("v2: " + compress2(charsInput));
        //System.out.println();
        System.out.println(compressVer2(charsInput));

    }

//    public static int compress(char[] chars) {
//        //нужно два указателя, длинна массива, опорный элемент, счетчик
//        int length = chars.length;
//        int i = 0, j = 1;
//        int counter = 1;
//        char k = chars[0];
//        //проходимся по массиву
//        //если элемент такой же добавляем счетчик и сдвигаем второй указатель
//        //если другой то сдвигаем первый указатель
//        //(если счетчик > 1 то пишем значение счетика) и сдвигаем первый указатель еще раз, также счетчику присваиваем 1
//        //а опорному элементу присваиваем значение второго указателя
//        while (i < length) {
//            if (k == chars[j]) {
//                counter++;
//                j++;
//            } else {
//                i++;
//                chars[i] = (char) counter;
//                i++;
//                counter = 1;
//                k = chars[j];
//            }
//        }
//    }

//    private static int compress2(char[] chars) {
//        char x = chars[0];
//        int counter = 1;
//        int l = chars.length;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < l; i++) {
//            if (x == chars[i]) {
//                counter++;
//            } else {
//                sb.append(x);
//                if (counter > 1) {
//                    sb.append(counter);
//                }
//                x = chars[i];
//                counter = 1;
//            }
//        }
//        sb.append(x);
//        if (counter > 1) {
//            sb.append(counter);
//        }
//        System.out.println("v2: " + sb);
//        return sb.toString().toCharArray().length;
//    }

    public static int compressVer2(char[] chars) {
        int p1 = 0, p2 = 0;
        StringBuilder ans = new StringBuilder();
        while (p1 < chars.length && p2 < chars.length) {
            int count = 0;
            while (p2 < chars.length && chars[p1] == chars[p2]) {
                count++;
                p2++;
            }
            ans.append(chars[p1]);
            p1 = p2;
            if (count > 1) {
                ans.append(count);
            }
        }
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }
        System.out.println(Arrays.toString(chars));
        return ans.length();
    }

}
