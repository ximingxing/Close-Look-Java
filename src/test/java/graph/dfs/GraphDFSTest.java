package graph.dfs;

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
        ConnectComponent cc = new ConnectComponent(g);
        assertEquals(cc.count(), 2);
    }
}