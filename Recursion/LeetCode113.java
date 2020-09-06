import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        dfs(root, sum, list, res);
        return res;
    }

    private void dfs(TreeNode node, int sum, LinkedList<Integer> list, List<List<Integer>> res){

        if(node == null)
            return;

        list.addLast(node.val);

        if(node.left == null && node.right == null && sum == node.val)
            res.add(new ArrayList<>(list));


        dfs(node.left, sum - node.val, list, res);
        dfs(node.right, sum - node.val, list, res);
        list.removeLast();
    }
    int res = 0;
    public int calculate(int n, int m){

        int[] used = new int[n+1];


        fs(1, 0, used, n, m);
        return res;
    }

    private void fs(int num, int index, int[] used, int n, int m){

        if(index == m){
            res ++;
            return;
        }

        for (int i = num; i <= n; i++) {
            if(used[i] < 4){
                used[i] ++;
                fs(i, index+1, used, n, m);
                used[i] --;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode113().calculate(9,4));
    }
}
