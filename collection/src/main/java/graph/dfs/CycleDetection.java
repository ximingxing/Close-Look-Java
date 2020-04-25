package graph.dfs;

import graph.basic.Graph;

/**
 * Description: Cycle Detection
 * Created By xxm
 */
public class CycleDetection {

    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        // for Non-connected graph
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
    }

    /**
     * From v travel graph and cycle detection.
     *
     * @param v      vertex
     * @param parent pre of v
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (int w : G.adj(v)) // traversing all neighbors of v
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            } else if (w != parent) // w is visited and not pre of v
                return true;
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
