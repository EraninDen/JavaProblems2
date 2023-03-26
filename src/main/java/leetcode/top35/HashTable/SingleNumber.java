package leetcode.top35.HashTable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int uniqNum = 0;
        for (int idx : nums) {
            uniqNum ^= idx;
        }
        return uniqNum;
    }

    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
