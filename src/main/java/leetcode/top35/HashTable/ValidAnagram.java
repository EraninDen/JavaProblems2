package leetcode.top35.HashTable;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length();i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (result.containsKey(c)) {
                result.put(c, result.getOrDefault(c, 0) - 1);
            }
        }
        for (int val : result.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }
}
