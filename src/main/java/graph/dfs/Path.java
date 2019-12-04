package graph.dfs;

import datastructure.array.Array;
import graph.basic.Graph;

/**
 * Description: Path
 * Created By xxm
 */
public class Path {
    private Graph G;
    private int s;
    private int t;

    private boolean[] visited;
    private int[] pre; // record visited path

    /**
     * Init Path Algorithm.
     * Find path from a source to target vertex.
     *
     * @param G Graph
     * @param s source vertex
     * @Param t target vertex
     */
    public Path(Graph G, int s, int t) {
        G.validateVertex(s, t);

        this.G = G;
        this.s = s;
        this.t = t;

        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++)
            pre[i] = -1;

        dfs(s, s); // pre of s is it`s self and from s to end.
    }

    /**
     * Depth-first search -- early stop recursion
     * time complexity: O(V + E)  -- E >> V
     *
     * @param v      vertex
     * @param parent visited vertex before v
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;

        if (v == t) return true;

        for (int w : G.adj(v)) // traversing all neighbors of v
            if (!visited[w])
                if (dfs(w, v)) return true;

        return false;
    }

    public boolean isConnected() {
        return visited[t];
    }

    /**
     * Path from source to target vertex.
     *
     * @return Array
     */
    public Iterable<Integer> path() {
        Array<Integer> res = new Array<>();
        if (!isConnected()) return res; // from source to t is unconnected.

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
