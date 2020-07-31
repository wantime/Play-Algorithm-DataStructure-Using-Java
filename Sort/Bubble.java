public class Bubble {

    public void sort(int[] arr){


        boolean swapFlag; // 当某一次遍历发现没有元素需要调整位置，数组就是有序的，此时结束循环
        int n = arr.length; //  每一次冒泡之后，最大的元素都在最后那个位置，所以下一次遍历就不需要考虑它
        do{
            swapFlag = false;
            for (int i = 1; i < n; i++) {
                if(arr[i] < arr[i-1]){
                    swap(arr, i, i-1);
                    swapFlag = true;
                }
            }
            n --;
        }while (swapFlag);
    }

    private void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Bubble().sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                System.out.println("error");
        }
    }
}
