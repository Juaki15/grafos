package pr2.org;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

//import jdk.internal.jline.internal.TestAccessible;

//import jdk.internal.jline.internal.TestAccessible;

import org.junit.Before;

import java.util.*;

import org.junit.Test;

public class GraphTest {
    
    public class Vertice {
        String value;
    }
    
    Graph<String> g;

    @Before
    public void setUp(){
        g = new Graph<String>();
    }
    @Test

    public void graphExistsTest(){
        assertNotNull(g);
    }


    @Test
    public void toStringEmptyTest(){
        String expectedOutput = "Vértice\tConexiones\n";
        assertEquals(expectedOutput, g.toString());
    }

    @Test
    public void addOneVertexTestOk(){
        assertTrue(g.addVertex("v1"));
        assertFalse(g.addVertex("v1"));
    }

    @Test
    public void addOneVertexTestFail(){
        assertTrue(g.addVertex("v1"));
    }

    //*
    @Test
    public void toStringTwoVertexTest(){
        g.addVertex("v1");
        g.addVertex("v0");
        String expectedOutput = "Vértice\tConexiones\n"
            +"v0\t\n"
            +"v1\t\n";
        assertEquals(expectedOutput, g.toString());
    }//*/
    @Test
    public void addEdgeOk(){
        g.addVertex("v1");
        g.addVertex("v2");
        assertTrue(g.addEdge("v1","v2"));
    }

    @Test
    public void addEdgeFailDuplicated(){
        g.addVertex("v1");
        g.addVertex("v2");
        assertTrue(g.addEdge("v1","v2"));
        assertFalse(g.addEdge("v1","v2"));
    }
    @Test
    public void addEdgeFailNonExists(){
        g.addVertex("v1");
        assertFalse(g.addEdge("v1","v2"));
    }
}
