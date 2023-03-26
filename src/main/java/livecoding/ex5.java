package livecoding;

import java.util.Arrays;

public class ex5 {

    public static int[] reverse2(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 7, 0, 1, 4, 5 };
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reverse2(array)));


    }
}
