package leetcode.top35.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] pCount = new int[26];
        for (char pc : pArr){
            pCount[pc - 'a']++;
        }
        int l = 0;
        int[] count = new int[26];
        for (int r = 0; r < sArr.length; r++) {
            int ind = sArr[r] - 'a';
            count[ind]++;
            if (count[ind] > pCount[ind]) {
                while (count[ind] != pCount[ind]) {
                    count[sArr[l++] - 'a']--;
                }
            }
            if (r - l + 1 == pArr.length) {
                result.add(l);
            }
        }
        return result;
    }

    //O (n^2)
    private int[] hashTable(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++freq[s.charAt(i) - 'a'];
        }
        return freq;
    }

    public List<Integer> findAnagram(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] pattern = hashTable(p);
        for (int i = 0, j = p.length(); j <= s.length(); ++i, ++j) {
            if (Arrays.equals(pattern, hashTable(s.substring(i, j)))) {
                ans.add(i);
            }
        }
        return ans;
    }

    //O (n)
    private int[] hashTable2(String s) {
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length(); ++i) {
            ++freq[s.charAt(i) - 'a'];
        }
        return freq;
    }
    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();

        int[] patternFreq = hashTable2(p);

        int end = Math.min(s.length(), p.length());
        //int end = (s.length() < p.length()) ? s.length() : p.length();
        int[] stringFreq = hashTable2(s.substring(0, end));

        for (int i = 0, j = p.length(); j <= s.length(); ++i, ++j) {
            if(Arrays.equals(patternFreq, stringFreq)) ans.add(i);

            --stringFreq[s.charAt(i) - 'a'];
            if(j < s.length()) ++stringFreq[s.charAt(j) - 'a'];
        }
        return ans;
    }
}
