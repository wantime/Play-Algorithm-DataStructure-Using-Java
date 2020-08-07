import java.util.HashSet;

public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2){

        HashSet<Integer> record = new HashSet<>();
        for(int num: nums1)
            record.add(num);

        HashSet<Integer> resSet = new HashSet<>();
        for(int num: nums2){
            if(record.contains(num)){
                resSet.add(num);
            }
        }
        int i = 0;
        int[] res = new int[resSet.size()];
        for(int nums : resSet)
            res[i++] = nums;
        return res;
    }
}
