package graph.basic;

/**
 * Description: Graph interface
 * Created By xxm
 */
public interface Graph {

    boolean hasEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int degree(int v);

    int V();

    int E();
}