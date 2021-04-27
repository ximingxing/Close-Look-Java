/**
 * Description:
 * Created By xxm
 */
public class Solution {

    private int traverse(TreeNode root, int low, int high) {
        // 递归出口
        if (root == null) return 0;

        // 当前节点的值大于 high, 在左子树中寻找
        if (root.val > high) {
            return traverse(root.left, low, high);
        }
        // 当前节点的值小于 low, 在右子树中寻找
        if (root.val < low) {
            return traverse(root.right, low, high);
        }

        // 将符合 low <= root.val <= high 条件的值求和.
        return root.val + traverse(root.left, low, high) + traverse(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return traverse(root, low, high);
    }
}
