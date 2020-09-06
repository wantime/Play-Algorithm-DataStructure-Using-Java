import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode47 {

    private List<List<Integer>> res;
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {

        res = new ArrayList<>();
        if(nums.length == 0)
            return res;

        Arrays.sort(nums);
        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();

        getPermute(nums, 0, p);

        return res;
    }
    private void getPermute(int[] nums, int index, LinkedList<Integer> p){

        if(index == nums.length)
            res.add(new LinkedList<Integer>(p));


        for(int i = 0; i < nums.length; i ++)

            if(used[i] == false){
                if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false)
                    continue;
                p.addLast(nums[i]);
                used[i] = true;
                getPermute(nums, index+1, p);
                used[i] = false;
                p.removeLast();
            }
    }

}


