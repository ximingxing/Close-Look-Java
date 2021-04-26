/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // 如果root为空, 递归出口
        // 如果当前的root保存的值等于val的值, 就返回root
        if (root == null || val == root.val) return root;

        // 否则根据BST, 右子树节点大于左子树节点的性质, erfensou
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
