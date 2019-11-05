package graph.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Description: Adjacent Matrix
 * g.txt : Store a graph structure
 *         line 1 : vertex edge
 *         line 2 ~ line n : the relationship of edges
 * Created By xxm
 */
public class AdjMatrix {

    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            adj = new int[V][V];

            E = scanner.nextInt();
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
