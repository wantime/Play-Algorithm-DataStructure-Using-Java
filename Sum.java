public class Sum {

    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    /**
     * 计算arr[l...n]这个区间内所有数字的和
     * 递归算法
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr, int l){
       if(l == arr.length)
           return 0;
        System.out.println(arr[l]);
       return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(sum(nums));
    }
}
