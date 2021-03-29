/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // 将 root 的左子树和右子树拉平
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 1. 将左子树断开作为新的右子树
        root.right = left;
        root.left = null;

        // 2. 将原先的右子树接在现在的右子树后面
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
