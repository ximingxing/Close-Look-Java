/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helpValid(root, null, null);
    }

    public boolean helpValid(TreeNode root, TreeNode min, TreeNode max) {
        // 递归出口
        if (root == null) return true;
        // 如果当前节点比左子树最小值还小, BST不合法
        if (min != null && root.val <= min.val)
            return false;
        // 如果当前节点比右子树最大值还大, BST不合法
        if (max != null && root.val >= max.val)
            return false;

        // 递归验证root的左子树, 并传递最小值
        // 递归验证root的右子树, 并传递最大值
        return helpValid(root.left, min, root)
                && helpValid(root.right, root, max);
    }
}
