public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        int j = 0;

        while (l <= r){
            swap(nums, l, (int)(Math.random() * (r - l + 1) + l));
            int v = nums[l];
            j = l;  //  记录大于v的最后一个元素的位置
            for (int i = l + 1; i <= r ; i++) {
                if(nums[i] >= v && i != j)
                    swap(nums, ++j, i);
            }
            swap(nums, l, j);
            if(j == k - 1)
                break;
            else if(j > k - 1)
                r = j - 1;
            else
                l = j + 1;
        }
        return nums[j];
    }
    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 0};
        new LeetCode215().findKthLargest(arr, 2);
    }
}
