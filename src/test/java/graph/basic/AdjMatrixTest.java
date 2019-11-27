package graph.basic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
public class AdjMatrixTest {

    @Test
    public void AdjMatrix(){
        AdjMatrix adjMatrix = new AdjMatrix("src/test/java/graph/basic/g.txt");
        System.out.println(adjMatrix);
    }
}