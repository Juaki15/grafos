package pr2.org;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import org.junit.Before;

import java.util.*;

import org.junit.Test;

public class GraphTest {
     
    Graph<Integer> gInts;

    @Before
    public void setUp(){
        gInts = new Graph<Integer>();
    }
    @Test

    public void graphExistsTest(){
        assertNotNull(gInts);
    }


    @Test
    public void toStringEmptyTest(){
        String expectedOutput = "Vértice\tConexiones\n";
        assertEquals(expectedOutput, gInts.toString());
    }

    @Test
    public void addOneVertexTest(){
        assertTrue(gInts.addVertex(1));
    }

    @Test
    public void toStringOneVertexTest(){
        gInts.addVertex(1);
        String expectedOutput = "Vértice\tConexiones\n"+"1\t\n";
        assertEquals(expectedOutput, gInts.toString());
    }
}
