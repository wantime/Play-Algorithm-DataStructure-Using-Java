public class MergeBU {


    public void sort(int[] arr){

        int n = arr.length;

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i < n; i += sz + sz) {
                //  对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1]进行归并
                merge(arr, i, i + sz - 1,
                        Math.max(i+sz+sz-1, n-1));
            }
        }
    }

    private void merge(int[] arr, int l, int mid, int r){

        int[] aux = new int[r-l+1];
        for (int i = l; i < r; i++)
            aux[i-l] = arr[i];

        int i = l;      //  左边的范围是aux[0...mid-l]
        int j = mid+1;  //  右边的范围是aux[mid+1-l...r-l]
        for (int k = l; k < r; k++) {

            if(i > mid) {
                arr[k] = aux[j];
                j ++;
            }
            else if( j > r){
                arr[k] = aux[i];
                i ++;
            }
            else if(aux[i-l] <= aux[j-l]){
                arr[k] = aux[i-l];
                i ++;
            }else {
                arr[k] = aux[j-l];
                j ++;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new MergeBU().sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                System.out.println("error");
        }
    }
}
