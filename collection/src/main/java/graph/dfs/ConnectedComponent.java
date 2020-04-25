package graph.dfs;

import datastructure.array.Array;
import graph.basic.Graph;

/**
 * Description: Connect Component.
 * Created By xxm
 */
public class ConnectedComponent {
    private Graph G;
    private int[] visited; // unvisited -> -1, visited -> cccount
    private int cccount; // count connected component

    public ConnectedComponent(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < visited.length; i++) visited[i] = -1;
        cccount = 0;

        // for Non-connected graph
        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1)
                dfs(v, cccount++); // dfs first, then plus ccid.
    }

    /**
     * Find the connected component by Depth-first search.
     *
     * @param v
     * @param ccid connected component id
     */
    private void dfs(int v, int ccid) {
        visited[v] = ccid;
        for (int w : G.adj(v)) // traversing all neighbors of v
            if (visited[w] == -1)
                dfs(w, ccid);
    }

    /**
     * Determine whether two points are connected.
     *
     * @param v vertex1
     * @param w vertex2
     * @return true if connected else return false.
     */
    public boolean isConnected(int v, int w) {
        G.validateVertex(v, w);
        return visited[v] == visited[w];
    }

    /**
     * Solving connected components.
     *
     * @return Array contains Array(sub graph)
     */
    public Array<Array<Integer>> components() {
        Array<Array<Integer>> res = new Array<>(cccount);
        for (int i = 0; i < cccount; i++)
            res.addLast(new Array<Integer>());

        for (int v = 0; v < G.V(); v++)
            res.get(visited[v]).addLast(v);

        return res;
    }

    /**
     * Count connected component.
     *
     * @return int
     */
    public int count() {
        return cccount;
    }
}
