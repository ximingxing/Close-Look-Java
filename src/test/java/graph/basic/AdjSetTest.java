package graph.basic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
public class AdjSetTest {

    @Test
    public void AdjSet(){
        AdjSet adjSet = new AdjSet("src/test/java/graph/basic/g.txt");
        System.out.println(adjSet);
    }

}