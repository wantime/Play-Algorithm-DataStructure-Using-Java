import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            if(!record.containsKey(nums1[i]))
                record.put(nums1[i], 1);
            else
                record.put(nums1[i], record.get(nums1[i]) +1);

        LinkedList<Integer> ret = new LinkedList<>();

        for (int i = 0; i < nums2.length; i++) {
            if(record.containsKey(nums2[i])) {
                ret.addLast(nums2[i]);
                int count = record.get(nums2[i]);
                if(count == 1)
                    record.remove(nums2[i]);
                else
                    record.put(nums2[i], count-1);
            }
        }
        int[] res = new int[ret.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = ret.removeFirst();
        return res;
    }

}
