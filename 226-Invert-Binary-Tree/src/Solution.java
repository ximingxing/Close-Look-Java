/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归遍历左右子树
        invertTree(root.left);
        invertTree(root.right);

        // 结束后返回root即可
        return root;
    }
}
