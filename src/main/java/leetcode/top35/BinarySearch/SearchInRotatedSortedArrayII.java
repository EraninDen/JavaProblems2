package leetcode.top35.BinarySearch;

import java.util.HashSet;

public class SearchInRotatedSortedArrayII {
    // Using HashSet
    public boolean search(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.contains(target);
    }

    //Using binary search

    public boolean search2(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            int mid = (last - first) / 2 + first;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) first = mid + 1;
            else last = mid - 1;
        }
        return false;
    }
}
