import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 利用栈模拟BST递归中序遍历
 * <p>
 * Created By xxm
 */
public class Solution2 {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (true) {
            // 节点不为空, 一直压栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 节点为空, 元素出栈
            root = stack.pop();
            // 将k--
            if (--k == 0) return root.val;
            // 遍历右子树
            root = root.right;
        }
    }

}
