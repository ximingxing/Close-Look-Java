package graph.dfs;

import graph.basic.AdjSet;
import graph.basic.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description: Graph DFS implementation
 * Created By xxm
 */
public class GraphDFS {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    private GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        System.out.println(Arrays.toString(visited));

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

    public static void main(String[] args) {
        Graph g = new AdjSet("src/main/java/graph/dfs/g2.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.pre());
        System.out.println(graphDFS.post());
    }
}
