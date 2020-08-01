public class LeetCode26 {

    public int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++)
            if(nums[i] != nums[j])
                nums[++j] = nums[i];

        return  j + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        new LeetCode26().removeDuplicates(arr);
    }
}
