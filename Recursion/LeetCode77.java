import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77 {

    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if(k == 0 || n < k)
            return res;
        LinkedList<Integer> list = new LinkedList<>();
        dfs(n, k, list);
        return res;
    }

    private void dfs(int n, int k, LinkedList<Integer> path){
        if(k == 0){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = n; i > 0; i--) {
            if(i < k)//优化，对于i<k的情况不做处理
                break;
            path.addLast(i);
            dfs(i-1, k-1, path);
            path.removeLast();

        }
    }
}
