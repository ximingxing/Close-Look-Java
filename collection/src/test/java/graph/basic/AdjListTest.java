package graph.basic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
public class AdjListTest {

    @Test
    public void AdjList() {
        AdjList adjList = new AdjList("src/test/java/graph/basic/g.txt");
        System.out.println(adjList);
    }
}