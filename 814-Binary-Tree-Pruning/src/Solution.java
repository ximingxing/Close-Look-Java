/**
 * Description:
 * <p>
 * 自底向上依次检查节点:
 * 如果节点满足左右子树为空, 并且节点自身值为0, 将其删除即可;
 * <p>
 * Created By xxm
 */
public class Solution {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        // 后序遍历二叉树
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 检查节点
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }

}
