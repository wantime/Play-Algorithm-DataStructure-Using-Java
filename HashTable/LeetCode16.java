import java.util.Arrays;

public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)
            throw new IllegalArgumentException("the input nums have less than" +
                    " 3 elements");

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];
        //Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i ++){

            int l = i + 1;          //
            int r = nums.length - 1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if( sum > target) r --;
                else if(sum < target) l ++;
                else return target;
            }

        }
        return closest;
    }
}
