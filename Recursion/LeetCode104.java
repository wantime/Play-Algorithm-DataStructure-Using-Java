public class LeetCode104 {

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int Depth = Math.max(leftDepth, rightDepth) + 1;
        return Depth;
    }
}
