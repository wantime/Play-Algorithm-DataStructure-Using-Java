public class Shell {

    public void sort(int[] arr){

        int n = arr.length;

        int h = 1;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        while (h < n/3) h = 3*h + 1;

        while (h >= 1){

            for (int i = h; i < n; i++) {

                int tmp = arr[i];
                int j = i;
                for (; j > h && arr[j] < arr[j-h]; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = tmp;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {

        int[] arr = {3,2,1};
        new Shell().sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                System.out.println("error");
        }
    }
}

