package graph.dfs;

import graph.basic.AdjSet;
import graph.basic.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
public class GraphDFSnrTest {

    @Test
    public void dfsnrTest() {
        Graph g = new AdjSet("src/test/java/graph/dfs/g2.txt");
        GraphDFSnr graphDFSnr = new GraphDFSnr(g);
        System.out.println(graphDFSnr.pre());
    }

}