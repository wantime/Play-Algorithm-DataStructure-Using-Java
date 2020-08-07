import java.util.HashSet;

public class LeetCode202 {

    public boolean isHappy(int n) {

        HashSet<Integer> record = new HashSet<>();
        while (n != 1){
            int res = 0;
            record.add(n);

            while (n != 0){
                res += (n % 10) * (n % 10);
                n /= 10;
            }
            if(record.contains(res))
                return false;
            record.add(res);
            n = res;
        }
        return true;
    }
}
