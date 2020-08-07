import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length < 4) return res;



        Arrays.sort(nums);

        int len =  nums.length - 3;
        for(int i = 0; i < len; i ++){

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = nums.length - 1; j > i + 1; j--) {
                int l = i + 1;
                int r = j - 1;
                while (r > l) {
                    int sum = nums[i] + nums[l] + nums[r] + nums[j];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r], nums[j]);
                        if (!res.contains(list)) {
                            res.add(list);
                        }
                        while (r > l && nums[r - 1] == nums[r]) r--; // 去重
                        while (r > l && nums[l + 1] == nums[l]) l++; // 去重
                        l++;
                        r--;
                    }
                    if(sum < target)l++;
                    if(sum > target)r--;

                }
            }
        }

        return res;
    }
}
