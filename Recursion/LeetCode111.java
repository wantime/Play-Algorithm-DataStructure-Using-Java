public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        if(root.right == null && root.left != null)
            return minDepth(root.left) + 1;

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }
}
