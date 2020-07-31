public class Quick2 {

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

    private int partition(int[] arr, int l, int r){

        swap( arr, l, (int)(Math.random()*(r-l+1) + l) );
        int v = arr[l];

        int i = l + 1,j = r;

        while (true){
            while ( i <= r && arr[i] < v) i ++;

            while ( j >= l+1 &&  arr[j] > v) j --;

            if( i > j)  break;
            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Quick2().sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                System.out.println("error..");
        }
    }
}
