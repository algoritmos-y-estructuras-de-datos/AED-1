package UT03.TA2.TAD;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas de Lista Ordenada
 * @author Grupo 7
 */
public class ListaOrdenadaTest {
    
    ListaOrdenada listaVacia;
    ListaOrdenada listaOrdenada;
    
    public ListaOrdenadaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        listaVacia = new ListaOrdenada();
        listaOrdenada = new ListaOrdenada();
        listaOrdenada.insertar(new Nodo("nodo5", "dato1", null));
        listaOrdenada.insertar(new Nodo("nodo1", "dato2", null));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertar method, of class ListaOrdenada.
     */
    @Test
    public void testInsertar() {
        assertEquals(listaVacia.cantElementos(), 0);
        assertEquals(listaOrdenada.cantElementos(), 2);
        listaVacia.insertar(new Nodo("nodo4", "", null));
        assertEquals(listaVacia.cantElementos(), 1);
        assertEquals(listaVacia.imprimir(), "nodo4");
        listaVacia.insertar(new Nodo("nodo5", "", null));
        assertEquals(listaVacia.cantElementos(), 2);
        assertEquals(listaVacia.imprimir(), "nodo4nodo5");
        listaVacia.insertar(new Nodo("nodo5", "", null));
        assertEquals(listaVacia.cantElementos(), 2);
        assertEquals(listaVacia.imprimir(), "nodo4nodo5");
        listaVacia.insertar(new Nodo("nodo6", "", null));
        assertEquals(listaVacia.cantElementos(), 3);
        assertEquals(listaVacia.imprimir(), "nodo4nodo5nodo6");
        listaVacia.insertar(new Nodo("nodo1", "", null));
        assertEquals(listaVacia.cantElementos(), 4);
        assertEquals(listaVacia.imprimir(), "nodo1nodo4nodo5nodo6");
        listaVacia.insertar(new Nodo("nodo0", "", null));
        assertEquals(listaVacia.cantElementos(), 5);
        assertEquals(listaVacia.imprimir(), "nodo0nodo1nodo4nodo5nodo6");
        listaVacia.insertar(new Nodo("nodo2", "", null));
        assertEquals(listaVacia.cantElementos(), 6);
        assertEquals(listaVacia.imprimir(), "nodo0nodo1nodo2nodo4nodo5nodo6");
        listaVacia.insertar(new Nodo("nodo3", "", null));
        assertEquals(listaVacia.cantElementos(), 7);
        assertEquals(listaVacia.imprimir(), "nodo0nodo1nodo2nodo3nodo4nodo5nodo6");
        assertEquals(listaOrdenada.imprimir(), "nodo1nodo5");
        listaOrdenada.insertar(new Nodo("nodo2", "", null));
        assertEquals(listaOrdenada.imprimir(), "nodo1nodo2nodo5");
        listaOrdenada.insertar(new Nodo("nodo3", "", null));
        assertEquals(listaOrdenada.imprimir(), "nodo1nodo2nodo3nodo5");
        listaOrdenada.insertar(new Nodo("nodo6", "", null));
        assertEquals(listaOrdenada.imprimir(), "nodo1nodo2nodo3nodo5nodo6");
    }

}
