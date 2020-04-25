package graph.dfs;

import datastructure.array.Array;
import graph.basic.Graph;

/**
 * Description: Graph DFS implementation with recursion
 * Created By xxm
 */
public class GraphDFS {

    private Graph G;
    private boolean[] visited;

    private Array<Integer> pre = new Array<>();
    private Array<Integer> post = new Array<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        // for Non-connected graph
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
        pre.addLast(v);
        for (int w : G.adj(v)) // traversing all neighbors of v
            if (!visited[w])
                dfs(w);
        post.addLast(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }
}
