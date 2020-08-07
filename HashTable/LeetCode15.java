import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        //为了防止出现大量重复值
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++) {
            //如果和前一个相同则跳过
            if (i>=1 && nums[i] == nums[i-1]){
                continue;
            }
            //这里就和两数之和逻辑一样
            HashSet<Integer> set = new HashSet<>();
            //  首先判断 - (nums[i]+nums[j])是否已存在，存在的话说明满足这一条件的三个数可以组成一个三元组
            for (int j = i+1; j < nums.length; j++) {
                int x = 0 - nums[i] - nums[j];
                if (set.contains(x)) {
                    List<Integer> list = Arrays.asList(new Integer[]{nums[i],
                            x,nums[j]});
                    res.add(list);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
