package livecoding;

import java.util.HashMap;
import java.util.Map;

public class LiveCoding {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[]nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[] {i,j};
            }
        }
        return null;
    }
}
