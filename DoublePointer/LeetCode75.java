public class LeetCode75 {

    public void sortColors(int[] nums) {

        int zero = 0;
        int two = nums.length-1;

        int i = 0;
        while (i <= two){

            if(nums[i] == 1) {
                i ++;
            }
            else if(nums[i] == 2) {
                swap(nums, i, two);
                two --;
            }else { //nums[i] == 0;
                assert nums[i] == 0;
                swap(nums, i, zero);
                zero --;
                i++;
            }
        }

    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        new LeetCode75().sortColors(arr);
    }
}
