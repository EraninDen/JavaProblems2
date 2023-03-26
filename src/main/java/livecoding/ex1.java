package livecoding;

import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 2, 5, 7, 8};
        Set<Integer> result = new LinkedHashSet<>();

        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i] * arr[i]) ;
        }
        System.out.println(result);
    }


}
