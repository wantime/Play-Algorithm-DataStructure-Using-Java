public class LeetCode226 {


    public TreeNode mirrorTree(TreeNode root) {

        if(root == null)
            return null;

        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
