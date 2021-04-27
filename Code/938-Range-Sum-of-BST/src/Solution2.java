/**
 * Description: 二叉搜索树中序遍历有序性.
 * Created By xxm
 */
public class Solution2 {
    int ans;

    /* 中序遍历二叉搜索树累加符合条件的值 */
    private void traverse(TreeNode root, int low, int high) {
        // 递归出口
        if (root == null) return;

        traverse(root.left, low, high);

        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }

        traverse(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        traverse(root, low, high);
        return ans;
    }
}
