/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空的节点插入val
        if (root == null) return new TreeNode(val);

        // 如果val大于root的值, 则在右子树中寻找合适位置
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        // 如果val小于root的值, 则在左子树中寻找合适位置
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
