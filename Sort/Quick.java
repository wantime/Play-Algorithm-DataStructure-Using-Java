public class Quick {

    public void sort(int[] arr){

        int n = arr.length;

        sort(arr, 0, n-1);

    }
    //  对arr从l到r进行快速排序
    private void sort(int[] arr, int l, int r){

        if(l >= r)
            return;
        //  if(r - l <= 15)
        //  insertionSort(arr, l, r_=)
        //  return

        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);

    }
    //  将arr[l...r]进行partition操作，返回p，p前面的元素<arr[p],后面的元素则大于
    private int partition(int[] arr, int l, int r){

        swap( arr, l, (int)(Math.random()*(r-l+1) + l) );

        int v = arr[l];

        int j = l;
        //  在遍历arr[l...r]这个范围的元素时，将选定的元素放在最开始的位置
        for (int i = l + 1; i <= r; i++)
            //   当发现当前元素小于v时，需要把它挪到小于的区间中，也就是用它跟
            //  j+1这个位置的元素交换一下位置，j指向了小区间的最后一个元素
            //  j+1指向大区间的第一个元素
            //  交换完成后j++，
            //  这个区间是通过其实位置l，小区间的最后一个位置j以及当前元素位置i三部分来划分的
            if (arr[i] < v)
                swap(arr, ++j, i);
        //  当遍历结束时，交换一下j与l元素的位置，就可以得到l。。。j-1和j+1...r两部分区间了
        swap(arr, j, l);
        return j;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Quick().sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                System.out.println("error");
        }
    }
}
