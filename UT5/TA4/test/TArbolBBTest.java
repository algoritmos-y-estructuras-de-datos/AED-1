/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author lucas
 */
public class TArbolBBTest {

    TArbolBB<Integer> arbolVacio, arbolSoloRaiz, arbolCaso1Avl, arbolCaso2Avl, arbolCaso3Avl,
            arbolCaso4Avl, arbolCaso5Avl, arbolCaso6Avl, arbolCaso7Avl, arbolCaso8Avl, arbolCaso9Avl,
            arbolCaso10Avl, arbolCaso11Avl, arbolCaso12Avl, arbolCaso13Avl;

    @Before
    public void setUp() {
        // --------------
        // Casos simples:
        // --------------
        // Árbol vacío
        arbolVacio = new TArbolBB<>();
        // Árbol 1 nodo
        arbolSoloRaiz = new TArbolBB<>();
        arbolSoloRaiz.insertar(new TElementoAB<>(1));

        // --------------
        // Casos felices:
        // --------------
        // AVL 3 nodos: Raíz 2, hijo izq 1, hijo der 3
        arbolCaso1Avl = new TArbolBB<>();
        arbolCaso1Avl.insertar(new TElementoAB<>(2));
        arbolCaso1Avl.insertar(new TElementoAB<>(1));
        arbolCaso1Avl.insertar(new TElementoAB<>(3));
        // AVL 4 nodos: Raíz 2, hijo izq 1, (hijo der 3 -> hijo der 4)
        arbolCaso2Avl = new TArbolBB<>();
        arbolCaso2Avl.insertar(new TElementoAB<>(2));
        arbolCaso2Avl.insertar(new TElementoAB<>(1));
        arbolCaso2Avl.insertar(new TElementoAB<>(3));
        arbolCaso2Avl.insertar(new TElementoAB<>(4));
        // AVL 4 nodos: Raíz 2, (hijo izq 1 -> 0), hijo der 3
        arbolCaso3Avl = new TArbolBB<>();
        arbolCaso3Avl.insertar(new TElementoAB<>(2));
        arbolCaso3Avl.insertar(new TElementoAB<>(1));
        arbolCaso3Avl.insertar(new TElementoAB<>(0));
        arbolCaso3Avl.insertar(new TElementoAB<>(3));
        // AVL 5 nodos: 4 -> izq 3,2; -> der 5, 6
        arbolCaso4Avl = new TArbolBB<>();
        arbolCaso4Avl.insertar(new TElementoAB<>(4));
        arbolCaso4Avl.insertar(new TElementoAB<>(3));
        arbolCaso4Avl.insertar(new TElementoAB<>(2));
        arbolCaso4Avl.insertar(new TElementoAB<>(5));
        arbolCaso4Avl.insertar(new TElementoAB<>(6));
        // AVL 6 nodos: 4 -> izq 2,1,3; -> der 5, 6
        arbolCaso5Avl = new TArbolBB<>();
        arbolCaso5Avl.insertar(new TElementoAB<>(4));
        arbolCaso5Avl.insertar(new TElementoAB<>(2));
        arbolCaso5Avl.insertar(new TElementoAB<>(1));
        arbolCaso5Avl.insertar(new TElementoAB<>(3));
        arbolCaso5Avl.insertar(new TElementoAB<>(5));
        arbolCaso5Avl.insertar(new TElementoAB<>(6));
        // AVL 6 nodos: 4 -> izq 3,2; -> der 5, 6
        arbolCaso6Avl = new TArbolBB<>();
        arbolCaso6Avl.insertar(new TElementoAB<>(4));
        arbolCaso6Avl.insertar(new TElementoAB<>(3));
        arbolCaso6Avl.insertar(new TElementoAB<>(2));
        arbolCaso6Avl.insertar(new TElementoAB<>(6));
        arbolCaso6Avl.insertar(new TElementoAB<>(5));
        arbolCaso6Avl.insertar(new TElementoAB<>(7));
        // AVL 7 nodos: caso que faltó. Ver último caso de los fallidos
        // es igual, pero "arreglo" subárbol izquierdo agregándole hijo
        // al primer izq
        arbolCaso13Avl = new TArbolBB<>();
        arbolCaso13Avl.insertar(new TElementoAB<>(6));
        arbolCaso13Avl.insertar(new TElementoAB<>(4));
        arbolCaso13Avl.insertar(new TElementoAB<>(3));
        arbolCaso13Avl.insertar(new TElementoAB<>(2));
        arbolCaso13Avl.insertar(new TElementoAB<>(5));
        arbolCaso13Avl.insertar(new TElementoAB<>(7));
        arbolCaso13Avl.insertar(new TElementoAB<>(8));

        // --------------
        // Casos fallidos:
        // --------------
        // AVL 3 nodos: Raíz 1, izq 2, der 3
        arbolCaso7Avl = new TArbolBB<>();
        arbolCaso7Avl.insertar(new TElementoAB<>(1));
        arbolCaso7Avl.insertar(new TElementoAB<>(2));
        arbolCaso7Avl.insertar(new TElementoAB<>(3));
        // AVL 4 nodos: 1, 2, 3, 4 lineal
        arbolCaso8Avl = new TArbolBB<>();
        arbolCaso8Avl.insertar(new TElementoAB<>(1));
        arbolCaso8Avl.insertar(new TElementoAB<>(2));
        arbolCaso8Avl.insertar(new TElementoAB<>(3));
        arbolCaso8Avl.insertar(new TElementoAB<>(4));
        // AVL 4 nodos: 4, 3, 2, 1 lineal
        arbolCaso9Avl = new TArbolBB<>();
        arbolCaso9Avl.insertar(new TElementoAB<>(4));
        arbolCaso9Avl.insertar(new TElementoAB<>(3));
        arbolCaso9Avl.insertar(new TElementoAB<>(2));
        arbolCaso9Avl.insertar(new TElementoAB<>(1));
        // AVL 5 nodos: 6 raiz, izq 5, der 7, 8, 9
        arbolCaso10Avl = new TArbolBB<>();
        arbolCaso10Avl.insertar(new TElementoAB<>(6));
        arbolCaso10Avl.insertar(new TElementoAB<>(5));
        arbolCaso10Avl.insertar(new TElementoAB<>(7));
        arbolCaso10Avl.insertar(new TElementoAB<>(8));
        arbolCaso10Avl.insertar(new TElementoAB<>(9));
        // AVL 6 nodos: idem anterior, pero 9 tiene dos hijos
        arbolCaso11Avl = new TArbolBB<>();
        arbolCaso11Avl.insertar(new TElementoAB<>(6));
        arbolCaso11Avl.insertar(new TElementoAB<>(5));
        arbolCaso11Avl.insertar(new TElementoAB<>(7));
        arbolCaso11Avl.insertar(new TElementoAB<>(9));
        arbolCaso11Avl.insertar(new TElementoAB<>(8));
        arbolCaso11Avl.insertar(new TElementoAB<>(10));
        // AVL 6 nodos: 6 raiz, rompo por izquierda
        arbolCaso12Avl = new TArbolBB<>();
        arbolCaso12Avl.insertar(new TElementoAB<>(6));
        arbolCaso12Avl.insertar(new TElementoAB<>(5));
        arbolCaso12Avl.insertar(new TElementoAB<>(4));
        arbolCaso12Avl.insertar(new TElementoAB<>(3));
        arbolCaso12Avl.insertar(new TElementoAB<>(7));
        arbolCaso12Avl.insertar(new TElementoAB<>(8));
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_vacio() {
        assertTrue(arbolVacio.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_soloRaiz() {
        assertTrue(arbolSoloRaiz.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso1Avl() {
        assertTrue(arbolCaso1Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso2Avl() {
        assertTrue(arbolCaso2Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso3Avl() {
        assertTrue(arbolCaso3Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso4Avl() {
        assertTrue(arbolCaso4Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso5Avl() {
        assertTrue(arbolCaso5Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso6Avl() {
        assertTrue(arbolCaso6Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso13Avl() {
        assertTrue(arbolCaso13Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso7Avl() {
        assertFalse(arbolCaso7Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso8Avl() {
        assertFalse(arbolCaso8Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso9Avl() {
        assertFalse(arbolCaso9Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso10Avl() {
        assertFalse(arbolCaso10Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso11Avl() {
        assertFalse(arbolCaso11Avl.esArbolAvl());
    }

    /**
     * Test of esArbolAvl method, of class TArbolBB.
     */
    @Test
    public void testEsArbolAvl_caso12Avl() {
        assertFalse(arbolCaso12Avl.esArbolAvl());
    }

}
