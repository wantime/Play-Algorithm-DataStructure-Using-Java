public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null)
            return null;

        if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }

        else if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }

        else {  //root.val == key
            if(root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            else if(root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            else { //root.left != null && root.right != null
                TreeNode successor = findMax(root.left);
                successor.left = removeMax(root.left);
                successor.right = root.right;
                root.left = root.right = null;
                return successor;
            }
        }
    }

    private TreeNode findMax(TreeNode node){
        if(node.right == null)
            return node;
        return findMax(node.right);
    }

    private TreeNode removeMax(TreeNode node){
        if(node == null)
            return null;

        if(node.right == null){
            TreeNode leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }
}
