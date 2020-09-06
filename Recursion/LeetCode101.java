public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        TreeNode left = root.left;
        TreeNode right = root.right;

        return dfs(left, right);

    }

    private boolean dfs(TreeNode p, TreeNode q){

        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
