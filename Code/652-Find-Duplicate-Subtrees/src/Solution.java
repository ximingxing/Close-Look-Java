import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * Created By xxm
 */
public class Solution {
    // 用来记录每颗子树出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 用来保存返回的结果
    LinkedList<TreeNode> res = new LinkedList<>();

    private String find(TreeNode root) {
        // 递归出口
        if (root == null) return "#";

        // 后序遍历二叉树
        String left = find(root.left);
        String right = find(root.right);

        // 描述一颗以root为根节点的二叉树
        String subTree = left + "," + right + "," + root.val;

        // 寻找与subTree相同的二叉树
        Integer freq = memo.getOrDefault(subTree, 0);
        // 如果已经出现过与subTree相同的树
        if (freq == 1) {
            // 出现重复子树将结果加入res
            // 每个重复子树, 返回结果中仅仅记录一次
            res.add(root);
        }
        // 给subTree把出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return res;
    }
}
