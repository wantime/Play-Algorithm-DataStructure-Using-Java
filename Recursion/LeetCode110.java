public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node){

        if (node == null)
            return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
