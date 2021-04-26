/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;

        // 统计左子树高度
        int l = 0, r = 0;
        while (left != null) {
            l++;
            left = left.left;
        }
        // 统计右子树高度
        while (right != null) {
            r++;
            right = right.right;
        }

        // 如果左右子树高度相同
        // 则二叉树为满二叉树.
        if (l == r) {
            return (int) Math.pow(2, l) - 1;
        }
        // 如果左右子树高度不同,
        // 则二叉树为普通二叉树.
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
