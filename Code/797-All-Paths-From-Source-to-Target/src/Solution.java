import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 所有可能路径
 * Solution: DFS
 * Created By xingximing.xxm
 */
public class Solution {

    List<List<Integer>> res = new LinkedList<>();

    private void dfs(int[][] graph, int s, LinkedList<Integer> path, int n) {
        // 访问第 s 个节点
        path.addLast(s);

        // 递归出口
        // 到达终点
        if (s == n - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        // 搜索 s 的邻居节点
        for (int i = 0; i < graph[s].length; i++) {
            dfs(graph, graph[s][i], path, n);
        }

        // 回溯
        path.removeLast();
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 从 0 到 n-1 深度优先遍历
        LinkedList<Integer> path = new LinkedList<>();
        dfs(graph, 0, path, graph.length);
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};

        List<List<Integer>> lists = new Solution().allPathsSourceTarget(graph);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
