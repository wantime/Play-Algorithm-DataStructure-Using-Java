public class LeetCode283 {

    public void moveZeroes(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                if(i != k)
                    swap(nums, i, k++);
                else
                    k ++;
        }


    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
