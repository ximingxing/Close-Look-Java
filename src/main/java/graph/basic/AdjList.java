package graph.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Description: Adjacent List
 * Created By xxm
 */
public class AdjList implements Graph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    /**
     * Build Adjacent Matrix
     * time complexity: O(E*V) -- judge Parallel edge(Traversing LinkedList)
     * space complexity: O(E+V)
     *
     * @param filename file path
     */
    private AdjList(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative!");
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new LinkedList<>();

            E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-negative!");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                validateVertex(a, b);

                if (a == b) throw new IllegalArgumentException("Self Loop is Detected!");
                if (adj[a].contains(b)) // contain() -- O(V)
                    throw new IllegalArgumentException("Parallel Edges are Detected!");

                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int... vertex) {
        for (int v : vertex) {
            if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is invalid!");
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v, w);
        return adj[v].contains(w);
    }

    /**
     * Look for the edge adjacent to v.
     * time complexity: O(degree(V)) -- worst-case scenario: O(V)
     *
     * @param v vertex
     * @return the edge adjacent to v.
     */
    @Override
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Degree
     * time complexity: O(degree(V)) -- worst-case scenario: O(V)
     *
     * @param v vertex
     * @return size
     */
    @Override
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            builder.append(String.format("%d: ", v));
            for (int w : adj[v])
                builder.append(String.format("%d ", w));
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        AdjList adjList = new AdjList("src/main/java/graph/basic/g.txt");
        System.out.println(adjList);
    }
}