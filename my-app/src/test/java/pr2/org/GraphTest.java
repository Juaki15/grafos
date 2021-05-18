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

    /**Test que sirve para comprobar que se puede crear el grafo */
    @Before 
    public void setUp(){
        g = new Graph<String>();
    }

    /**Test para verificar que el grafo que hemos creado existe */
    @Test
    public void graphExistsTest(){
        assertNotNull(g);
    }

    /**Test para comprobar que el toString funciona correctamente */
    @Test
    public void toStringEmptyTest(){
        String expectedOutput = "Vértice\tConexiones\n";
        assertEquals(expectedOutput, g.toString());
    }

    /**Test para verificar que no se puede annadir el mismo vertice dos veces */
    @Test
    public void addOneVertexTestFail(){
        g.addVertex("v1");
        assertFalse(g.addVertex("v1"));
    }

    /**Test para comprobar que podemos annadir un vertice al grafo */
    @Test
    public void addOneVertexTestOk(){
        assertTrue(g.addVertex("v1"));
    }

    /**Otro test para comprobar que el toString funciona bien */
    @Test
    public void toStringTwoVertexTest(){
        g.addVertex("v1");
        g.addVertex("v0");
        g.addEdge("v1","v0");
        g.addEdge("v0","v1");
        String expectedOutput = "Vértice\tConexiones\n"
            +"v0\t[v1]\n" 
            +"v1\t[v0]\n" ;
        assertEquals(expectedOutput, g.toString());
    }

    /**Test para comprobar que se puede annadir una arista a dos vertices existentes */
    @Test
    public void addEdgeTestOk(){
        g.addVertex("v1");
        g.addVertex("v2");
        assertTrue(g.addEdge("v1","v2"));
    }

    /**Test para comprobar que no se puede annadir la misma arista dos veces */
    @Test
    public void addEdgeTestFailDuplicated(){
        g.addVertex("v1");
        g.addVertex("v2");
        assertTrue(g.addEdge("v1","v2"));
        assertFalse(g.addEdge("v1","v2"));
    }

    /**Test para comprobar que no se puede annadir una arista si uno de los dos vertices dados no existen */
    @Test
    public void addEdgeTestFailNonExists(){
        g.addVertex("v1");
        assertFalse(g.addEdge("v1","v2"));
    }

    /**Test para comprobar que podemos annadir una arista a un mismo vertice */
    @Test
    public void addEdgeSingleVertex(){
        g.addVertex("v1");
        assertTrue(g.addEdge("v1","v1"));
    }

    /**Test para comprobar que los adyacentes de v1 no estan vacios */
    @Test 
    public void obtainAdjacentsTestTrue() throws Exception {
        g.addVertex("v1");
        g.addVertex("v2");
        g.addEdge("v1", "v2");
        assertNotNull(g.obtainAdjacents("v1"));
    }

    /**Test para comprobar que v3 no tiene adyacentes */
    @Test (expected = Exception.class)
    public void obtainAdjacentsTestFalse() throws Exception {
        this.g.obtainAdjacents("v1");
    }

    /**Test para comprobar que el grafo contiene el vertice que hemos annadido */
    @Test
    public void containsVertexTestTrue() {
        g.addVertex("v1");
        assertTrue(g.containsVertex("v1"));

    }

    /**Test para comprobar que le grafo no contiene un vertice que no hemos annadido */
    @Test
    public void containsVertexTestFalse() {
        g.containsVertex("v1");
    }

    /**Test para comprobar que encontramos un camino de un vertice a otro dados en el grafo */
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

    /**Otro test para comprobar que encontramos un camino de un vertice a otro dados en el grafo */
    @Test
    public void pathExists(){
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addVertex("v4");
        g.addVertex("v5");
        g.addVertex("v6");
        g.addVertex("v7");
        g.addVertex("v8");
        g.addEdge("v1","v2");
        g.addEdge("v1","v5");
        g.addEdge("v2","v3");
        g.addEdge("v3","v4");
        g.addEdge("v4","v6");
        g.addEdge("v4","v7");
        g.addEdge("v2","v8");
        List<String> camino = g.onePath("v1","v4");
        List<String> caminoEsperado = new ArrayList<>();
        caminoEsperado.add("v1");
        caminoEsperado.add("v2");
        caminoEsperado.add("v3");
        caminoEsperado.add("v4");
        assertEquals(caminoEsperado,camino);
    }

    /**Test para comprobar que no hay un camino de un vertice a otro (inconexos) dados en el grafo */
    @Test 
    public void pathDontExistUnconectedVertex() {
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addEdge("v1", "v2");
        List<String> camino = g.onePath("v1","v3");
        assertNull(camino);
    }

    /**Test para comprobar que no hay un camino de un vertice a otro si uno de los vertices no existe */
    @Test 
    public void pathDontExistsUndefinedVertex() {
        g.addVertex("v1");
        List<String> camino = g.onePath("v1","v3");
        assertNull(camino);
    }
}