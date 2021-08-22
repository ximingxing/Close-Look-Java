/**
 * Description: 给定一个二叉树，找出其最大深度。
 * Solution: DFS
 * Created By xingximing.xxm
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
