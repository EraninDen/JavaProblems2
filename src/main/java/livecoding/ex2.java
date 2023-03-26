package livecoding;

import java.util.Arrays;

public class ex2 {
    public static void main(String[] args) {
        int[] arr = {-3, -1, 2, 3, 4, 5, 7, 8};
        int k = 7;

        isHaveSum(arr, k);
    }
    // есть число k и надо вернуть ответ -> есть ли в массиве элементы сумма которых равна k
    public static void isHaveSum(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int target = k - arr[i];
            // 7-(-3) = 10
            System.out.println(target);
            // 10  сравнить со всеми елементами массива
            for (int j = 0; j < arr.length; j++) {
                if (target == (k + arr[j])) {
                    int target2 = arr[j];
                    System.out.println(target + " " + target2 + " " + k);
                    break;
                } else {
                    System.out.println("нет пары" + target + " " + arr[i]);
                }
            }
        }
    }
}
