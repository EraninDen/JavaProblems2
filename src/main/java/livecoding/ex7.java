package livecoding;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ex7 {
    public static void main(String[] args) {
        //Найти первый не повторяющийся элемент в массиве целых чисел
        int[] arr = {9, 4, 9, 6, 7, 4, 5};
        System.out.println(first(arr));

    }
    static Integer first(int[] array){
        Map<Integer, Integer> elements = new LinkedHashMap<>();
        for(int i = 0; i < array.length; i++) {
            elements.merge(array[i], 1, (old, newValue) -> old + 1);
        }
        return elements.entrySet().stream().filter(e -> e.getValue() == 1).collect(Collectors.toList()).get(0).getKey();
    }
}
