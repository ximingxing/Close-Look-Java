/**
 * Description: 检查以root为根结点的树的左右子树是否是镜像对称的
 * Solution: 1）每个树根结点的值相等；2）每个树的右子树都与另一个树的左子树镜像对称
 * Created By xingximing.xxm
 */
public class Solution {

    /**
     * 检查某个节点的左右子树是否对称
     */
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        // 当p向左子树遍历，则q向右子树遍历；
        // 当p向右子树遍历，则q向左子树遍历
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        // p，q均从根节点出发
        return check(root, root);
    }
}
