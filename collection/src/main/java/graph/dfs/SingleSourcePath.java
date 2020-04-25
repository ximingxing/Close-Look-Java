package graph.dfs;

import datastructure.array.Array;
import graph.basic.Graph;

/**
 * Description: Single Source Path
 * Created By xxm
 */
public class SingleSourcePath {

    private Graph G;
    private int s;

    private boolean[] visited;
    private int[] pre; // record visited path

    /**
     * Init SingleSourcePath Algorithm.
     * Find path from a source to any vertex in graph.
     *
     * @param G Graph
     * @param s source vertex
     */
    public SingleSourcePath(Graph G, int s) {
        G.validateVertex(s);

        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];

        dfs(s, s); // pre of s is it`s self and from s to end.
    }

    /**
     * Depth-first search
     * time complexity: O(V + E)  -- E >> V
     *
     * @param v vertex
     */
    private void dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (int w : G.adj(v)) // traversing all neighbors of v
            if (!visited[w])
                dfs(w, v);
    }

    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    /**
     * Path from source to target vertex.
     *
     * @param t target vertex.
     * @return Array
     */
    public Iterable<Integer> path(int t) {
        Array<Integer> res = new Array<>();
        if (!isConnectedTo(t)) return res; // from source to t is unconnected.

        Array<Integer> temp = new Array<>();
        int cur = t;
        while (cur != s) {
            temp.addLast(cur);
            cur = pre[cur];
        }
        res.addLast(s);

        // reverse temp
        for (int i = temp.getSize() - 1; i >= 0; i--)
            res.addLast(temp.get(i));

        return res;
    }
}
