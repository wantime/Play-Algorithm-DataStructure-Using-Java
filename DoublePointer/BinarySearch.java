public class BinarySearch {

    public boolean binarySearch(int[] arr, int target){


        int l = 0;
        int r = arr.length - 1; //  r = arr.length;
        while (l <= r){     //  l < r
            int mid = l + (r-l)/2;

            if(arr[mid] == target)
                return true;

            else if(arr[mid] > target)
                r = mid - 1;        //  r = mid;
            else if(arr[mid] < target)
                l = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        boolean isTrue = new BinarySearch().binarySearch(arr, 7);
    }
}
