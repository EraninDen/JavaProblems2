package leetcode.top35.HashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    //with HashMap
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                ans[1] = i;
                ans[0] = map.get(val);
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
