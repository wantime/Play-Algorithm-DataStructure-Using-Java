import java.util.LinkedList;
import java.util.List;

public class LeetCode401 {

    private LinkedList<String> res;
    public List<String> readBinaryWatch(int num) {
        res = new LinkedList<>();
        int[] hours = {1,2,4,8};
        int[] minutes = {1,2,4,8,16,32};

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if(Integer.bitCount(h) + Integer.bitCount(m) == num){

                    String hour = Integer.toString(h);
                    String minute = Integer.toString(m);

                    if( m < 10 )
                        res.addLast(hour + ":0" + minute);
                    else
                        res.addLast(hour + ":" + minute);
                }
            }
        }
        return res;
    }
}
