import java.util.ArrayList;

public class LeetCode129 {

    public int sumNumbers(TreeNode root) {

        //  使用res存储每一个根节点到叶子节点所组成的数字字符串
        ArrayList<String> record = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        dfs(root, s, record);

        int res = 0;
        for (int i = 0; i < record.size(); i++) {
            res += Integer.parseInt(record.get(i));
        }
        return res;
    }
    private void dfs(TreeNode node, StringBuilder s, ArrayList<String> record){

        if(node == null)
            return;

        s.append(Integer.toString(node.val));
        if(node.left == null && node.right == null)
            record.add(s.toString());

        dfs(node.left, s, record);
        dfs(node.right, s, record);
        s.deleteCharAt(s.length()-1);

    }
}
