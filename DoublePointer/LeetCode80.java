public class LeetCode80 {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int j = 0;  //  nums[j...i-1]中存储满足要求的元素
                    //  nums[0..1]绝对满足要求，从2开始判断
        for (int i = 2; i < n; i++) {
            if(nums[j] != nums[i]) {
                nums[j + 2] = nums[i];
                j++;
            }
        }
        return j+2;
    }
}
