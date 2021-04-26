/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        // 如果root本身就是p或者q，比如说root就是p节点吧,
        // 如果q存在于以root为根的树中，显然root就是最近公共祖先;
        // 即使q不存在于以root为根的树中, 也应该返回root节点.
        if (root == p || root == q) return root;

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 1: 如果p和q都在以root为根的树中，那么left和right一定分别是p和q
        if (left != null && right != null) {
            return root;
        }
        // 2: 如果p和q都不在以root为根的树中，直接返回null
        if (left == null && right == null) {
            return null;
        }
        // 3: 如果p和q只有一个存在于root为根的树中，函数返回该节点
        return left == null ? right : left;
    }
}
