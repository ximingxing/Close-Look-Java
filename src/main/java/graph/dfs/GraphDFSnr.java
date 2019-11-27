package graph.dfs;

import datastructure.array.Array;
import datastructure.stack.LinkedListStack;
import datastructure.stack.Stack;
import graph.basic.Graph;

/**
 * Description: Graph DFS implementation with non-recursion
 * Created By xxm
 */
public class GraphDFSnr {

    private Graph G;
    private boolean[] visited;

    private Array<Integer> pre = new Array<>();

    public GraphDFSnr(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        // for Non-connected graph
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    /**
     * Depth-first search non-recursion
     *
     * @param v
     */
    private void dfs(int v) {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(v); // v push in stack
        visited[v] = true;
        while (!stack.isEmpty()) { // if stack isn`t empty, still has node in graph untraveled.
            Integer cur = stack.pop(); // travel the top of stack.
            pre.addLast(cur);
            for (Integer w : G.adj(cur)) // put all neighbors of cur in stack.
                if (!visited[w]) {  // the element neighbors of cur isn`t visited.
                    stack.push(w);
                    visited[w] = true;
                }
        }
    }

    public Iterable<Integer> pre() {
        return pre;
    }
}