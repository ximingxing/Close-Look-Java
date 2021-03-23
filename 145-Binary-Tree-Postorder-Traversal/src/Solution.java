import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * 后序遍历即为前序遍历的翻转
 * 根据这个思路: 我们前序遍历二叉树, 给返回List头部添加结果即可.
 * Created By xxm
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        for (stack.push(root); !stack.isEmpty(); ) {
            root = stack.pop();
            if (root != null) {
                res.addFirst(root.val);
                stack.push(root.left);
                stack.push(root.right);
            }
        }
        return res;
    }
}
