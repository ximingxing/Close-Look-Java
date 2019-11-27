package graph.dfs;

import datastructure.stack.LinkedListStack;
import datastructure.stack.Stack;
import graph.basic.AdjSet;
import graph.basic.Graph;

import java.util.ArrayList;

/**
 * Description: Graph DFS implementation with non-recursion
 * Created By xxm
 */
public class GraphDFSnr {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();

    public GraphDFSnr(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    /**
     * Depth-first search
     *
     * @param v
     */
    private void dfs(int v) {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            pre.add(cur);
            for (Integer w : G.adj(cur))
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
        }
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("src/main/java/graph/dfs/g2.txt");
        GraphDFSnr graphDFSnr = new GraphDFSnr(g);
        System.out.println(graphDFSnr.pre);
    }
}
