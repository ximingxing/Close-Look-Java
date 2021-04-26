/**
 * Description:
 * <p>
 * 使用一个辅助函数判断是否包含1
 * 如果不包含则将节点删除.
 * <p>
 * Created By xxm
 */
public class Solution2 {

    private boolean containsOne(TreeNode root) {
        if (root == null) return false;

        boolean a = containsOne(root.left);
        boolean b = containsOne(root.right);

        if (!a) root.left = null;
        if (!b) root.right = null;

        return root.val == 1 || a || b;
    }

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

}
