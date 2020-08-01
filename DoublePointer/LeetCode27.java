public class LeetCode27 {
    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++)
            if(nums[i] != val && i != k)
               nums[k++] = nums[i];

        return k;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
