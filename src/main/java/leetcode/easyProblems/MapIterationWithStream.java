package leetcode.easyProblems;

import java.util.HashMap;
import java.util.Map;

public class MapIterationWithStream {

    public static String getKeyAndValuesFromMap(char[] chars) {
        Map<String, Integer> resultMap = new HashMap<>();
        int n = chars.length;

        for (char aChar : chars) {
            //положить в мапу плюсануть счетчик
            resultMap.merge(String.valueOf(aChar), 1, (oldValue, newValue) -> oldValue + 1);

        }
        StringBuilder sb = new StringBuilder();
        // собрать из мапы строку вида -> "a2b3c2" из исходника такого вида ('a','a','b','b','b','c','c')
        resultMap.forEach((key, value) -> sb.append(key).append(value));
        return String.valueOf(sb);
    }

    public static String getKeyAndValuesFromMap2(char[] chars) {
        Map<String, Integer> resultMap = new HashMap<>();
        int n = chars.length;

        for (char ch : chars) {
            resultMap.merge(String.valueOf(ch), 1, (oldV, newV) -> oldV + 1);
        }
        StringBuilder sb = new StringBuilder();
        resultMap.forEach((key, value) -> sb.append(key).append(value));
        return String.valueOf(sb);
    }
}
