public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null)
            return 0;

        return dfs(root.left, true) + dfs(root.right, false);
    }

    private int dfs(TreeNode node, boolean isLeft){

        if(node == null)
            return 0;

        if(node.left == null && node.right == null)
            if(isLeft)
                return node.val;
            else
                return 0;

        return dfs(node.left, true) + dfs(node.right, false);
    }

}
