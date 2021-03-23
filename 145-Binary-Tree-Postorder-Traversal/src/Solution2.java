import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * Created By xxm
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // Pair<节点, 访问标记>
        // 0: 左右子树都未访问
        // 1: 访问过左子树, 未访问过右子树
        // 2: 访问过右子树
        Deque<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (stack.push(new Pair<>(root, 0)); !stack.isEmpty(); ) {
            Pair<TreeNode, Integer> top = stack.pop();
            root = top.getKey();
            if (root != null) {
                switch (top.getValue()) {
                    case 0:
                        stack.push(new Pair<>(root, 1));
                        stack.push(new Pair<>(root.left, 0));
                        break;
                    case 1:
                        stack.push(new Pair<>(root, 2));
                        stack.push(new Pair<>(root.right, 0));
                        break;
                    case 2:
                        res.add(root.val);
                        break;
                }
            }
        }
        return res;
    }
}
