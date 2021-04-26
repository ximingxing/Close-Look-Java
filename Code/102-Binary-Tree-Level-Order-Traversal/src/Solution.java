import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: BFS 广度优先搜索
 * <p>
 * 思路: 使用一个队列保存每一层的节点.
 * <p>
 * Created By xxm
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // 我们使用队列保存每一层的所有节点
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);

        for (; !q.isEmpty(); ) {
            // 由于我们在遍历每个节点时会将其左右子数压入队列
            // 所以需要提前保存当前队列长度
            // 用来表示当前层节点个数
            int n = q.size();
            // level用来存储每一层的节点的值
            ArrayList<Integer> level = new ArrayList<>();
            // 遍历每一层的所有节点
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                // 将当前节点存入level
                level.add(node.val);
                // 分别遍历左右子树
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            // 每一层遍历结束, 将结果加入res中
            res.add(level);
        }
        return res;
    }
}
