public class    Merge {


    public void sort(int[] arr){

        sort(arr, 0, arr.length-1);

    }
    //  递归使用归并排序，对arr[l...r]的范围进行排序
    private void sort(int[] arr, int l, int r){
        if(l >= r)
            return;

//        if(r - l <= 15)   //  使用插入排序进行优化
//            new Insertion2().sort(arr, l, r);

        int mid = l + (r - l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);

        if(arr[mid] > arr[mid+1])
            merge(arr, l, mid, r);
    }
    //  对arr[l...mid]和arr[mid+1...r]两部分进行归并
    private void merge(int[] arr, int l, int mid, int r){
        int[] aux = new int[r-l+1];

        for (int i = l; i <= r; i++)
            aux[i-l] = arr[i];

        int i = l, j = mid + 1;
        for (int k = 0; k <= r; k++) {

            if( i > mid ){
                arr[k] = aux[j-l];
                j ++;
            }
            else if( j > r ){
                arr[k] = aux[i-l];
                i ++;
            }
            else if( aux[i-l] <= aux[j-l] ){
                arr[k] = aux[i-l];
                i ++;
            }
            else {
                arr[k] = aux[j-l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Merge().sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                System.out.println("error");
        }
    }
}
