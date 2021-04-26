import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: DFS 深度优先搜索
 * <p>
 * 只要在前序遍历(中序、后序遍历也可以)保存当前节点所在的层数即可.
 * 保存层数可以使用Map，数组或者ArrayList.
 * 如果使用Map注意Key的顺序，leetcode上直接使用HashMap也是可以通过的,
 * 其实更安全的策略是使用TreeMap.
 * <p>
 * Created By xxm
 */
public class Solution2 {
    private void dfs(TreeNode root, int deep, Map<Integer, List<Integer>> have) {
        // 递归结束条件
        if (root == null) return;

        // 从map中取出当前层节点对应的list
        // 如果没有则返回空
        List<Integer> list = have.getOrDefault(deep, new ArrayList<>());
        // 将当前节点值加入list
        list.add(root.val);
        // 更新完list后, 再将其放回map之中
        have.put(deep, list);

        // 之后递归调用左右子树
        dfs(root.left, deep + 1, have);
        dfs(root.right, deep + 1, have);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 使用Map存储<层数, 该层的全部节点>
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        // DFS遍历, 从root开始, 也就是第0层
        dfs(root, 0, map);
        // 最后返回map中所有元素的集合
        return new ArrayList<>(map.values());
    }
}
