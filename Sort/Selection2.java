public class Selection2 {

    public void sort(int[] arr){

        int l = 0;
        int r = arr.length - 1;

        while (l < r){
            //  通过每次找到最小值与最大值来优化选择排序
            int minIndex = l;
            int maxIndex = r;
            //  进行选择前需要确保min小于max
            if(arr[minIndex] > arr[maxIndex])
                swap(arr, minIndex, maxIndex);

            for (int j = l + 1; j < r; j++) {
                if(arr[l] > arr[j])
                    minIndex = j;
                if(arr[r] < arr[j])
                    maxIndex = j;
            }
            swap(arr, minIndex, l);
            swap(arr, maxIndex, r);
            l ++;
            r --;
        }
    }
    private void swap(int[] arr, int i, int j){
        if(i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,0};
        new Selection2().sort( arr);
    }
}
