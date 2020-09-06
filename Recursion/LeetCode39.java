import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode39 {

    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        res = new ArrayList<>();
        if(candidates.length == 0)
            return res;

        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, target, 0, path);
        return res;

    }
    private void dfs(int[] nums, int target,
                     int start, LinkedList<Integer> path){

        if(target == 0){
            res.add(new LinkedList<>(path));
            return;
        }
        if(target < 0)
            return;
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(nums, target-nums[i], i, path);
            path.removeLast();
        }
    }
}
