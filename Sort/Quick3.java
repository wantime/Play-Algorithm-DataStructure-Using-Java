public class Quick3 {


    public void sort(int[] arr){

        int n = arr.length;
        partition(arr, 0, n-1);
    }

    //  对arr从l到r进行快速排序
    private void partition(int[] arr, int l, int r){

        if(l >= r)
            return;
        //  if(r - l <= 15)
        //  insertionSort(arr, l, r_=)
        //  return

        swap( arr, l, (int)(Math.random()*(r-l+1)+l) );
        int v = arr[l];

        int lt = l; //  从arr[l+1...lt] < v
        int gt = r + 1; // 从arr[gt...r] > v
        int i = l+1;    //  arr[lt+1...i) == v
        while( i < gt ){
            if( arr[i] < v ) {
                swap(arr, lt+1, i);
                lt ++;
                i ++;
            }
            else if( arr[i] > v){
                swap(arr, gt-1, i);
                gt --;
            }
            else
                i ++;
        }
        swap(arr, l, lt);

        partition(arr, l, lt-1);
        partition(arr, gt, r);
    }




    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Quick3().sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                System.out.println("error..");
        }
    }
}
