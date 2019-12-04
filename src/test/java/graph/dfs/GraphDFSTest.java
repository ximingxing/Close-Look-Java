package graph.dfs;

import datastructure.array.Array;
import graph.basic.AdjSet;
import graph.basic.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
public class GraphDFSTest {

    @Test
    public void dfsTest() {
        Graph g = new AdjSet("src/test/java/graph/dfs/g2.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.pre());
        System.out.println(graphDFS.post());
    }

    @Test
    public void dfsNRTest() {
        Graph g = new AdjSet("src/test/java/graph/dfs/g.txt");
        GraphDFSnr graphDFSnr = new GraphDFSnr(g);
        System.out.println(graphDFSnr.pre());
    }

    @Test
    public void connectComponent() {
        Graph g = new AdjSet("src/test/java/graph/dfs/g2.txt");
        ConnectedComponent cc = new ConnectedComponent(g);

        assertEquals(cc.count(), 2);

        assertEquals(cc.isConnected(0, 6), true);

        for (Array<Integer> component : cc.components()) {
            System.out.println(component);
        }
    }

    @Test
    public void SingleSourcePathTest() {
        Graph g = new AdjSet("src/test/java/graph/dfs/g2.txt");
        SingleSourcePath sspath = new SingleSourcePath(g, 0);

        System.out.println("Path from 0 to 6:\n" + sspath.path(6));
        System.out.println("\nPath from 0 to 5:\n" + sspath.path(5));
    }
}