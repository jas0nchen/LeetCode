import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历
 *
 * @author chendong09
 * @since 2022/03/14
 */
public class Q144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        result.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        result.addAll(right);
        return result;
    }


}
