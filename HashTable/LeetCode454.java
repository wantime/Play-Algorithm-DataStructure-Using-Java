import java.util.HashMap;

public class LeetCode454 {
    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int ret = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0){
            char c1 = i >= 0 ? num1.charAt(i) : '0';
            char c2 = j >= 0 ? num2.charAt(j) : '0';

            ret = (c1 - '0') + (c2 - '0') + ret;

            res.insert(0, ret%10);

            ret = ret / 10;
            i --;
            j --;
        }
        if ( ret > 0)
            res.insert(0, ret);
        return res.toString();
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < C.length; i ++){
            for(int j = 0; j < D.length; j ++){
                int sum = C[i] + D[j];
                if(map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else map.put(sum, 1);
            }
        }

        int res = 0;
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < B.length; j ++){
                int sum = A[i] + B[j];
                if(map.containsKey(-sum))
                    res += map.get(-sum);
            }
        }

        return res;
    }
}
