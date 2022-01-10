import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author chendong09
 * @since 2022/01/10
 **/
public class Q103 {

    /**
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[20,9],[15,7]]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int l2r = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node;
            List<Integer> line = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (l2r % 2 == 1) {
                    // 从左往右
                    node = queue.pollFirst();
                    if (node != null && node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node != null && node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    // 从右往左
                    node = queue.pollLast();
                    if (node != null && node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node != null && node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
                if (node != null) {
                    line.add(node.val);
                }
            }
            if (line.size() > 0) {
                result.add(line);
            }
            l2r++;
        }
        return result;
    }
}
