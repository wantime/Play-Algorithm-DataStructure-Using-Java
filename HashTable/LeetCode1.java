import java.util.HashMap;

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        int[] index = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                index[0] = map.get(complement);
                index[1] = i;
                return index;
            }
            else
                map.put(nums[i], i);
        }
        return index;
    }
}
