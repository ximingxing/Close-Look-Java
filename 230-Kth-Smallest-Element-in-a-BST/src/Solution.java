/**
 * Description:
 * <p>
 * 利用BST中序遍历的有序性
 * <p>
 * Created By xxm
 */
public class Solution {
    // 用于标记顺序
    int rank = 0;
    // 返回结果
    int res = 0;

    private void traverse(TreeNode root, int k) {
        // 递归出口
        if (root == null) return;

        /**
         * 对BST中序遍历
         */
        traverse(root.left, k);

        rank++;
        if (k == rank) {
            // 找到第k小第节点
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
}
