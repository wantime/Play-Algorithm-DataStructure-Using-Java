public class Selection1 {


    public void Sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;
            //  每一次找到arr[i...arr.length]中最小的元素放在arr[i]上
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
