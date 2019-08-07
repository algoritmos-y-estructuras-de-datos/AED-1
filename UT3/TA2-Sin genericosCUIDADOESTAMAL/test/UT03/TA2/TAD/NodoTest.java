package UT03.TA2.TAD;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import UT03.TA2.TAD.Nodo;
import UT03.TA2.TAD.INodo;

/**
 * Pruebas de Nodo
 * @author Grupo 7
 */
public class NodoTest {
    
    Nodo nodoPrueba3;
    Nodo nodoPrueba2;
    Nodo nodoPrueba1;
    Nodo nodoPrueba0;
    Nodo nodoNulo;
    
    public NodoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nodoPrueba3 = new Nodo("nodoPrueba3", "dato3", null);
        nodoPrueba2 = new Nodo("nodoPrueba2", "dato2", nodoPrueba3);
        nodoPrueba1 = new Nodo("nodoPrueba2", "dato1", nodoPrueba2);
        nodoPrueba0 = new Nodo("nodoPrueba0", "dato3", null);
        nodoNulo = new Nodo();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDato method, of class Nodo.
     */
    @Test
    public void testGetDato() {
        assertTrue(((String)nodoPrueba1.getDato()).equals("dato1"));
    }

    /**
     * Test of setDato method, of class Nodo.
     */
    @Test
    public void testSetDato() {
        nodoPrueba1.setDato("dato2");
        assertTrue(((String)nodoPrueba1.getDato()).equals("dato2"));
    }

    /**
     * Test of setSiguiente method, of class Nodo.
     */
    @Test
    public void testSetSiguiente() {
        nodoPrueba1.setSiguiente(nodoPrueba2);
        assertEquals(nodoPrueba1.getSiguiente(), nodoPrueba2);
    }

    /**
     * Test of getSiguiente method, of class Nodo.
     */
    @Test
    public void testGetSiguiente() {
        assertEquals(nodoPrueba1.getSiguiente(), nodoPrueba2);
        assertEquals(nodoPrueba2.getSiguiente(), nodoPrueba3);
        assertEquals(nodoPrueba3.getSiguiente(), null);
    }

    /**
     * Test of imprimir method, of class Nodo.
     */
    @Test
    public void testImprimir() {
        nodoPrueba1.imprimir();
    }

    /**
     * Test of imprimirEtiqueta method, of class Nodo.
     */
    @Test
    public void testImprimirEtiqueta() {
        nodoPrueba1.imprimirEtiqueta();
    }

    /**
     * Test of equals method, of class Nodo.
     */
    @Test
    public void testEquals() {
        assertTrue(nodoPrueba1.equals(nodoPrueba2));
        assertFalse(nodoPrueba1.equals(nodoPrueba3));
    }

    /**
     * Test of getEtiqueta method, of class Nodo.
     */
    @Test
    public void testGetEtiqueta() {
        assertEquals(nodoPrueba1.getEtiqueta(), "nodoPrueba2");
        assertEquals(nodoNulo.getEtiqueta(), null);
    }

    /**
     * Test of compareTo method, of class Nodo.
     */
    @Test
    public void testCompareTo() {
        assertEquals(nodoPrueba1.compareTo(nodoPrueba2.getEtiqueta()), 0);
        assertEquals(nodoPrueba1.compareTo(nodoPrueba3.getEtiqueta()), -1);
        assertEquals(nodoPrueba1.compareTo(nodoPrueba0.getEtiqueta()), 2);
    }
    
}
