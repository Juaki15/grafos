package pr2.org;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

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

    @Test 
    public void obtainAdjacentsTrue() throws Exception {
        g.addVertex("v1");
        g.addVertex("v2");
        g.addEdge("v1", "v2");
        assertNotNull(g.obtainAdjacents("v2"));
    }

    @Test 
    public void obtainAdjacentsFalse() throws Exception {
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addEdge("v1", "v2");
        g.obtainAdjacents("v3");
    }

    @Test
    public void containsVertexTrue() {
        g.addVertex("v1");
        assertTrue(g.containsVertex("v1"));

    }

    @Test
    public void containsVertexFalse() {
        assertFalse(g.containsVertex("v1"));
    }

    //*
    @Test
    public void pathExists(){
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addVertex("v4");
        g.addVertex("v5");
        g.addEdge("v1","v2");
        g.addEdge("v1","v5");
        g.addEdge("v2","v3");
        g.addEdge("v3", "v4");
        List<String> camino = g.onePath("v1","v4");
        List<String> caminoEsperado = new ArrayList<>();
        caminoEsperado.add("v1");
        caminoEsperado.add("v2");
        caminoEsperado.add("v3");
        caminoEsperado.add("v4");
        assertEquals(caminoEsperado,camino);
    }//*/

    @Test 
    public void pathDontExists() {
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addEdge("v1", "v2");
        List<String> camino = g.onePath("v1","v3");
        assertNull(camino);
    }//*/

    /*@Test 
    public void pathExistsOneVertex() {
        g.addVertex("v1");
        g.addEdge("v1","v1");
        g.onePath("v1","v1");
    }*/
}