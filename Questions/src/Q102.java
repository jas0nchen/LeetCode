import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author chendong09
 * @since 2021/12/28
 **/
public class Q102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQue = new LinkedList<>();
        nodeQue.offer(root);
        while (!nodeQue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            TreeNode node;
            int size = nodeQue.size();
            for (int i = 0; i < size; i++) {
                node = nodeQue.poll();
                level.add(node.val);
                if (node.left != null) {
                    nodeQue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
