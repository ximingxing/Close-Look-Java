import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 检查以root为根结点的树的左右子树是否是镜像对称的
 * Solution: 1）每个树根结点的值相等；2）每个树的右子树都与另一个树的左子树镜像对称
 * Created By xingximing.xxm
 */
public class Solution2 {

    private boolean check(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        // 初始时，将根结点入队两次
        queue.offer(left);
        queue.offer(right);

        while (!queue.isEmpty()) {
            // 每次出队两个节点
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            // 如果节点同时为空，则跳过本次循环
            if (p == null && q == null) continue;

            // 左右孩子其中一个为空或者其值不想等，则不满足镜像对称
            if ((p == null || q == null) || p.val != q.val) {
                return false;
            }

            // 遍历左子树的左孩子，同时遍历右子树的右孩子
            queue.offer(p.left);
            queue.offer(q.right);
            // 遍历左子树的右孩子，同时遍历右子树的左孩子
            queue.offer(p.right);
            queue.offer(q.left);
        }

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
}
