import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用堆栈实现二叉树前序遍历
 */

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        // 声明堆栈保存TreeNode
        Stack<TreeNode> stack = new Stack<>();
        // 初始时将root压入堆栈, 只要堆栈不空, 说明root有孩子节点
        for (stack.push(root); !stack.isEmpty();) {
            // 堆栈顶元素成为当前的root
            root = stack.pop();
            // 对root前序遍历
            if (root != null) {
                res.add(root.val);
                // 由于堆的遍历顺序是后进先出,
                // 所以前序遍历先将右子树压入堆栈
                stack.push(root.right);
                stack.push(root.left);
            }
        }
        return res;
    }
}
