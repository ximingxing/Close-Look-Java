package graph.dfs;

import graph.basic.AdjSet;
import graph.basic.Graph;

import java.util.ArrayList;

/**
 * Description: Graph DFS implementation with recursion
 * Created By xxm
 */
public class GraphDFS {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        // Non-connected graph
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    /**
     * Depth-first search
     * time complexity: O(V + E)  -- E >> V
     *
     * @param v vertex
     */
    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v)) // traversing all neighbors of v
            if (!visited[w])
                dfs(w);
        post.add(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }
}
