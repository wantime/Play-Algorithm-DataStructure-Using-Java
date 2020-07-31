public class Insertion2 {

    public void sort(int[] arr){

        for (int i = 1; i < arr.length; i++) {

            //  判断arr[i]合适的插入位置
            //  修改交换操作为赋值语句
            int curValue = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1] > curValue; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = curValue;
        }
    }
}
