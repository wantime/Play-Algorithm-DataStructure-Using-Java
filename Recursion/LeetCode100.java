public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {


        if(p == null && q == null)  //终止条件
            return true;
        if(p != null && q != null)
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;

    }
}
