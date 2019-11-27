package graph.dfs;

import graph.basic.Graph;

/**
 * Description: Connect Component.
 * Created By xxm
 */
public class ConnectComponent {
    private Graph G;
    private boolean[] visited;
    private int cccount; // count connect component

    public ConnectComponent(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        cccount = 0;

        // for Non-connected graph
        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) {
                dfs(v);
                cccount++;
            }
    }

    /**
     * Depth-first search
     * time complexity: O(V + E)  -- E >> V
     *
     * @param v vertex
     */
    private void dfs(int v) {
        visited[v] = true;
        for (int w : G.adj(v)) // traversing all neighbors of v
            if (!visited[w])
                dfs(w);
    }

    /**
     * Count connect component.
     *
     * @return int
     */
    public int count() {
        return cccount;
    }
}
