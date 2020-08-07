
public class LeetCode977 {
   public int[] sortedSquares(int[] A) {
        
        int l = 0;
        int r = A.length-1;
        int k = r;
        int[] res = new int[A.length];
        while(l <= r){
            if(A[l] + A[r] < 0)
                res[k--] = A[l]*A[l++];
            else{
                res[k--] = A[r]*A[r--];
                //r--;
            }
                
        }
        return res;
    }
}
