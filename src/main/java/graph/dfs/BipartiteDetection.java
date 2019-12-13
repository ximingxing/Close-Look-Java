package graph.dfs;

import graph.basic.Graph;

/**
 * Description: Bipartite graph detection.
 * Created By xxm
 */
public class BipartiteDetection {

    private Graph G;
    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite;

    public BipartiteDetection(Graph G) {
        this.G = G;
        this.visited = new boolean[G.V()];
        this.colors = new int[G.V()];
        this.isBipartite = true; // default graph is Bipartite.

        for (int i = 0; i < G.V(); i++)
            colors[i] = -1; // init value is -1 means uncolored.

        // for Non-connected graph
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                if (!dfs(v, 0)) {
                    isBipartite = false;
                    break;
                }
    }

    /**
     * Bipartite graph detection.
     *
     * @param v     vertex
     * @param color c can take the value 0 or 1, means Bipartite graph.
     */
    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : G.adj(v)) // traversing all neighbors of v
            if (!visited[w]) {
                if (dfs(w, 1 - color)) return false;
            } else if (colors[w] == colors[v]) // two vertices of an edge are the same color
                return false;
        return true;
    }

    public boolean isBipartite() {
        return isBipartite;
    }
}
