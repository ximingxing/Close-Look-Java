import java.util.*;

/**
 * Description: 课程表
 * Solution: 拓扑排序
 * Created By xingximing.xxm
 */
public class Solution {
    int[] visited; // 0:未搜索, 1: 正在搜索, 2: 已搜索
    Deque<Integer> stack;
    boolean noCycle = true; // 判断图中是否存在环

    // 邻接表构建有向图
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }

    // 深度优先搜索
    private void dfs(List<Integer>[] graph, int node) {
        // 将 node 标记为搜索中
        visited[node] = 1;

        // 对 node 的邻接节点执行深度优先搜索
        for (int i = 0; i < graph[node].size(); i++) {
            int v = graph[node].get(i);

            // 如果邻居节点 v 没有搜索过，则继续搜索 v 的邻居
            if (visited[v] == 0) {
                dfs(graph, v);
                // 如果出现图中环，停止搜索
                if (!noCycle)
                    return;
            } else if (visited[v] == 1) {
                // 如果邻居节点 v 已经是搜索中，则说明出现了环
                // 因此这个图不存在拓扑排序
                noCycle = false;
                return;
            }
        }

        // 搜索完成
        visited[node] = 2;
        // 将搜索完成的节点入栈
        stack.push(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new int[numCourses];
        stack = new LinkedList<>();

        for (int i = 0; i < numCourses && noCycle; i++) {
            if (visited[i] == 0)
                dfs(graph, i);
        }

        if (!noCycle) {
            return new int[0];
        }

        // 搜索完毕的全部节点都存储在栈之中
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] order = new Solution().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}
