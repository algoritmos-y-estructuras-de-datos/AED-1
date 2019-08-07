package UT03.TA2.TAD;

import junit.framework.TestCase;

/**
 * Pruebas de Lista
 * @author Grupo 7
 */
public class ListaTest extends TestCase {
    
    Lista<String> listaVacia;
    Lista<String> lista1;
    
    public ListaTest() {
    }
    
    @Override
    protected void setUp() throws Exception {
        listaVacia = new Lista<>();
        lista1 = new Lista<>();
        lista1.insertar(new Nodo<>("nodo1", "dato1", null));
        lista1.insertar(new Nodo<>("nodo2", "dato2", null));
    }
    
    @Override
    protected void tearDown() throws Exception {
    }

    /**
     * Test of insertar method, of class Lista.
     */
    public void testInsertar() {
        lista1.insertar(new Nodo<>("nodo3", "dato3", null));
        assertEquals(lista1.imprimir(), "nodo1nodo2nodo3");
        assertEquals(lista1.cantElementos(), 3);
        lista1.insertar(new Nodo<>("nodo3", "dato3", null));
        assertEquals(lista1.imprimir(), "nodo1nodo2nodo3");
        assertEquals(lista1.cantElementos(), 3);
        lista1.insertar(new Nodo<>("nodo4", "dato4", null));
        assertEquals(lista1.imprimir(), "nodo1nodo2nodo3nodo4");
        assertEquals(lista1.cantElementos(), 4);
    }

    /**
     * Test of buscar method, of class Lista.
     */
    public void testBuscar() {
        INodo<String> buscado1 = lista1.buscar("nodo1");
        INodo<String> buscado2 = lista1.buscar("nodo2");
        INodo<String> buscado3 = lista1.buscar("nodo888");
        assertTrue(buscado1 != null);
        assertTrue(buscado2 != null);
        assertTrue(buscado3 == null);
    }

    /**
     * Test of eliminar method, of class Lista.
     */
    public void testEliminar() {
        lista1.insertar(new Nodo<>("nodo3", "dato3", null));
        assertEquals(lista1.imprimir(), "nodo1nodo2nodo3");
        assertEquals(lista1.cantElementos(), 3);
        assertFalse(lista1.eliminar("nodo4"));
        assertTrue(lista1.eliminar("nodo1"));
        assertEquals(lista1.imprimir(), "nodo2nodo3");
        assertEquals(lista1.cantElementos(), 2);
        assertTrue(lista1.eliminar("nodo3"));
        assertEquals(lista1.imprimir(), "nodo2");
        assertEquals(lista1.cantElementos(), 1);
        assertTrue(lista1.eliminar("nodo2"));
        assertEquals(lista1.imprimir(), "");
        assertEquals(lista1.cantElementos(), 0);
        assertFalse(lista1.eliminar("nodo2"));
        assertEquals(lista1.imprimir(), "");
        assertEquals(lista1.cantElementos(), 0);
        assertFalse(listaVacia.eliminar("nodo2"));
        assertEquals(listaVacia.imprimir(), "");
        assertEquals(listaVacia.cantElementos(), 0);
    }

    /**
     * Test of imprimir method, of class Lista.
     */
    public void testImprimir_0args() {
        assertEquals(lista1.imprimir(), "nodo1nodo2");
        assertEquals(listaVacia.imprimir(), "");
    }

    /**
     * Test of imprimir method, of class Lista.
     */
    public void testImprimir_String() {
        assertEquals(lista1.imprimir(", "), "nodo1, nodo2");
        assertEquals(listaVacia.imprimir(", "), "");
    }

    /**
     * Test of cantElementos method, of class Lista.
     */
    public void testCantElementos() {
        assertEquals(lista1.cantElementos(), 2);
        assertEquals(listaVacia.cantElementos(), 0);
    }

    /**
     * Test of esVacia method, of class Lista.
     */
    public void testEsVacia() {
        assertFalse(lista1.esVacia());
        assertTrue(listaVacia.esVacia());
    }

    /**
     * Test of getPrimero method, of class Lista.
     */
    public void testGetPrimero() {
        assertEquals(listaVacia.getPrimero(), null);
        Nodo<String> nuevo = new Nodo();
        listaVacia.insertar(nuevo);
        assertEquals(listaVacia.getPrimero(), nuevo);
    }
    
}
