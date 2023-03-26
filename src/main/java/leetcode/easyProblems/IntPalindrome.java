package leetcode.easyProblems;

public class IntPalindrome {

    public static boolean isPalindrome(int x) {
        int reversed = 0;
        int original = x;
        while (x != 0) {
            int num = x % 10;
            reversed = reversed * 10 + num;
            x = x / 10;
        }
        if (original == reversed && original >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(125));
        System.out.println(isPalindrome(212));
        System.out.println(isPalindrome(-212));
        System.out.println(isPalindrome(821212128));
        System.out.println("version2");
        System.out.println(isPalindrome2(212));
        System.out.println(isPalindrome2(213));
        System.out.println(isPalindrome2(-1234321));

    }

    public static boolean isPalindrome2(int x) {
        int reversed = 0, original = x;
        while (x != 0) {
            int num = x % 10;
            reversed = reversed * 10 + num;
            x = x / 10;
        }
        return original >= 0 && original == reversed;
    }
}
