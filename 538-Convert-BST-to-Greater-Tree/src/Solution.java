/**
 * Description:
 * <p>
 * 逆序中序遍历
 * <p>
 * Created By xxm
 */
public class Solution {
    // 用于记录元素累加和
    int sum = 0;

    private void traverse(TreeNode root) {
        // 递归出口
        if (root == null) return;

        // 为了使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和;
        // 所以需要先遍历右子树.
        convertBST(root.right);

        // 计算累加
        sum += root.val;
        root.val = sum;

        // 遍历左子树
        convertBST(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
}
