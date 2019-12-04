package graph.dfs;

import graph.basic.Graph;

/**
 * Description: All Pair Path
 * Created By xxm
 */
public class AllPairPath {

    private Graph G; // init graph
    private SingleSourcePath[] paths; // each element is a solution to single source path.

    public AllPairPath(Graph G) {
        this.G = G;
        paths = new SingleSourcePath[G.V()];

        for (int v = 0; v < G.V(); v++)
            // all vertexes in graph as single source vertex.
            // then solve single source path algorithm.
            paths[v] = new SingleSourcePath(G, v);
    }

    public boolean isConnectedTo(int s, int t) {
        G.validateVertex(s);
        return paths[s].isConnectedTo(t);
    }

    public Iterable<Integer> path(int s, int t) {
        G.validateVertex(s);
        return paths[s].path(t);
    }
}
