import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {

    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, list, res);
        return res;

    }

    private void dfs(int[] nums, LinkedList<Integer> list, List<List<Integer>> res){

        if(list.size() == nums.length){
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i] = true;
                dfs(nums, list, res);
                list.removeLast();
                used[i] = false;
            }
        }
    }
}
