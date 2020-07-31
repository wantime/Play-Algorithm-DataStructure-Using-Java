public class Bubble2 {

    public void sort(int[] arr){

        int n = arr.length;
        int newn;   //  newn记录上一次交换的位置，在这个位置之后都不需要再进行调整

        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if(arr[i] < arr[i-1]){
                    swap(arr, i, i-1);
                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            }
            n  = newn;
        }while (newn > 0);

    }
    private void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
