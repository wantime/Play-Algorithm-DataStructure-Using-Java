public class LeetCode209 {

    public int minSubArrayLen(int s, int[] nums) {

        int i = 0;
        int j = 0;
        int sum = 0;    //sum = nums[i...j)
        int minLen = nums.length;
        while (i < nums.length){
            if(sum < s && j < nums.length) {
                sum += nums[j++];
            }
            else if(sum >= s){
                minLen = (Math.min(minLen, j-i));
                sum -= nums[i++];
            }
            else
                break;
        }
        return minLen;
    }
}
