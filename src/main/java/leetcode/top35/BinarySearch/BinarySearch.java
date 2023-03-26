package leetcode.top35.BinarySearch;

public class BinarySearch {
    public int search1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        return val(nums, target, 0, nums.length - 1);
    }

    private int val(int[] nums, int target, int start, int end) {
        int mid = start + ((end - start) / 2);
        if (start <= end) {
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                return val(nums, target, mid + 1, end);
            } else if (nums[mid] > target) {
                return val(nums, target, start, mid - 1);
            }
        }
        return -1;
    }
}
