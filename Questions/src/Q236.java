/**
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * @author chendong09
 * @since 2021/12/23
 **/
public class Q236 {

    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    /**
     * 深度遍历查找p、q节点
     *
     * @param root 根结点
     * @param p    节点p
     * @param q    节点q
     * @return     是否找到p、q节点
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson) )) {
            result = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
