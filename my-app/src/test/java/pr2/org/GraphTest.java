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
    public void addEdgeTestOk(){
        g.addVertex("v1");
        g.addVertex("v2");
        assertTrue(g.addEdge("v1","v2"));
    }

    @Test
    public void addEdgeTestFailDuplicated(){
        g.addVertex("v1");
        g.addVertex("v2");
        assertTrue(g.addEdge("v1","v2"));
        assertFalse(g.addEdge("v1","v2"));
    }
    @Test
    public void addEdgeTestFailNonExists(){
        g.addVertex("v1");
        assertFalse(g.addEdge("v1","v2"));
    }

    @Test 
    public void obtainAdjacentsTestTrue() throws Exception {
        g.addVertex("v1");
        g.addVertex("v2");
        g.addEdge("v1", "v2");
        assertNotNull(g.obtainAdjacents("v2"));
    }

    @Test 
    public void obtainAdjacentsTestFalse() throws Exception {
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addEdge("v1", "v2");
        g.obtainAdjacents("v3");
    }

    @Test
    public void containsVertexTestTrue() {
        g.addVertex("v1");
        assertTrue(g.containsVertex("v1"));

    }

    @Test
    public void containsVertexTestFalse() {
        assertFalse(g.containsVertex("v1"));
    }

    @Test
    public void onePathFindsAPath(){
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");
        // Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);

        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        // Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
        //Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
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