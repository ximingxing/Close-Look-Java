import java.util.*;

/**
 * Description:
 * 迭代法:
 * 利用堆栈迭代中序遍历二叉树.
 * Created By xxm
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        // 利用cur遍历树
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 不断将二叉树的左子树压入堆栈
                stack.push(cur);
                cur = cur.left;
            } else {
                // 如果当前节点的左子树为null
                // 我们取出stack顶部节点即为二叉树的左子树
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
