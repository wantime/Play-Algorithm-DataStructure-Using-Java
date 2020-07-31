public class Heap {

    private int[] data;
    int size;
    public void sort(int[] arr){

        int n = arr.length;
        size = n - 1;
        data = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        for (int i = n/2 - 1; i >= 0 ; i--)
            siftDown(i);
        for (int i = 0; i < n; i++) {
            arr[i] = getMin();
        }

    }
    private int getParent(int index){
        return (index + 1) / 2;
    }
    private int getLeftChild(int index){
        return index * 2 + 1;
    }
    private int getMin(){
        int res = data[0];
        swap(data, 0, size);
        size --;
        siftDown(0);
        return res;
    }

    private void siftDown(int index){

        if(2 * index + 1 > size)
            return;

        int child = getLeftChild(index);
        if(child + 1 <= size && data[child + 1] < data[child])
            child = child + 1;
        if(data[index] > data[child]) {
            swap(data, index, child);
            siftDown(child);
        }

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Heap().sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
