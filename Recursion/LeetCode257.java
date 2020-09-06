import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();

        if(root == null)
            return res;

        if(root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);



        for(String left: leftPath){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(left);
            res.add(sb.toString());
        }

        for (String right: rightPath){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(right);
            res.add(sb.toString());
        }

        return res;
    }

}
