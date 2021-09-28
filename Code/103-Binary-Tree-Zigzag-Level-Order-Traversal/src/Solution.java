import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: Z字型层序遍历二叉树
 * Solution: 层序遍历二叉树的变种，如果偶数层则从左到右输出节点值；
 * 如果是技术层，则从右至左输出节电值即可。
 * Created By xingximing.xxm
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) return res;

        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 标记偶数层或者奇数层
        boolean isTheOrder = true;

        while (!queue.isEmpty()) {
            // Z字型遍历，利用双端队列维护交替输出
            Deque<Integer> level = new LinkedList<>();
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (isTheOrder) {
                    // 偶数层从左到右输出
                    level.addLast(node.val);
                } else {
                    // 奇数层从右至左输出
                    level.addFirst(node.val);
                }

                // 节点入队
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            res.add(new LinkedList<>(level));
            // 变换奇偶层
            isTheOrder = !isTheOrder;
        }

        return res;
    }
}
