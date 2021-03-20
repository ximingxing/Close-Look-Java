import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现二叉树前序遍历
 */

public class Solution {
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }
}
