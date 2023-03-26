package leetcode.top35.BinarySearch;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int a = BinarySearch(nums, target, 0, Pivot(nums));
        int b = BinarySearch(nums, target, Pivot(nums) + 1, nums.length - 1);
        if (a == -1 && b == -1) return -1;
        if (a == -1 && b != -1) return b;
        else return a;
    }

    static int Pivot(int[] nums) {
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) break;
        }
        return i;
    }

    static int BinarySearch(int[] nums, int target, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) return BinarySearch(nums, target, low, mid - 1);
            else return BinarySearch(nums, target, mid + 1, high);
        }
        return -1;
    }
}
