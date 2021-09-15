import java.util.LinkedList;
import java.util.List;

/**
 * Description: 课程表
 * Solution: 有向图找环
 * Created By xingximing.xxm
 */
public class Solution {
    boolean[] visited; // 标记访问过的节点
    boolean[] canPath; // 记录traverse走过的路径
    boolean noCycle = true;

    // 建图
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 初始化邻接表
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        // 将课程依赖关系构建为有向图
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }

        return graph;
    }

    private void traverse(List<Integer>[] graph, int s) {
        // 图中存在环
        if (canPath[s]) {
            noCycle = false;
        }
        // 已经访问过节点s
        if (visited[s]) {
            return;
        }

        // 遍历节点s
        visited[s] = true;
        canPath[s] = true;

        // 访问节点s的邻居节点
        for (int i = 0; i < graph[s].size(); i++) {
            traverse(graph, graph[s].get(i));
        }

        // 离开节点s
        canPath[s] = false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        canPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return noCycle;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};

        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
