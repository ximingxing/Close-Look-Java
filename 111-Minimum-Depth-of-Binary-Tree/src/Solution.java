import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * BFS
 * <p>
 * Created By xxm
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // BFS核心数据结构
        Queue<TreeNode> q = new LinkedList<>();
        // 先将根节点入队, 最小树高为1
        q.offer(root);
        int depth = 1;

        // 队列不为空
        while (!q.isEmpty()) {
            int size = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                // 最小树高度为 root 到最近叶子节点的路径长度
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
