package graph.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description: Adjacent Matrix
 * g.txt : Store a graph structure
 * --------line 1 : vertex edge
 * --------line 2 ~ line n : the relationship of edges
 * Created By xxm
 */
public class AdjMatrix implements Graph{

    private int V;
    private int E;
    private int[][] adj;

    /**
     * Build Adjacent Matrix
     * time complexity: O(E)
     * space complexity: O(V^2)
     *
     * @param filename file path
     */
    private AdjMatrix(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative!");
            adj = new int[V][V];

            E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-negative!");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                validateVertex(a, b);

                if (a == b) throw new IllegalArgumentException("Self Loop is Detected!");
                if (adj[a][b] == 1) throw new IllegalArgumentException("Parallel Edges are Detected!");

                adj[a][b] = 1;
                adj[b][a] = 1;
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
        return adj[v][w] == 1;
    }

    /**
     * Look for the edge adjacent to v.
     * time complexity: O(V)
     *
     * @param v vertex
     * @return the edge adjacent to v.
     */
    @Override
    public ArrayList<Integer> adj(int v) {
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++)
            if (adj[v][i] == 1) res.add(i);
        return res;
    }

    /**
     * Degree
     * time complexity: O(1)
     *
     * @param v vertex
     * @return size if v has edge
     */
    @Override
    public int degree(int v) {
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                builder.append(String.format("%d ", adj[i][j]));
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("src/main/java/graph/basic/g.txt");
        System.out.println(adjMatrix);
    }
}