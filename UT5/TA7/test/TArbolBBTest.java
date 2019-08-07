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

    TArbolBB<Integer> arbolVacio, arbolSoloRaiz, arbolNivel, arbolNivel2, arbolNivel3,
           arbolNivelDos, arbolCaso5Avl, arbolCaso6Avl, arbolCaso7Avl, arbolCaso8Avl, arbolCaso9Avl,
            arbolCaso10Avl, arbolCaso11Avl, arbolCaso12Avl, arbolCaso13Avl;

    @Before
    public void setUp() {

        // Árbol vacío
        arbolVacio = new TArbolBB<>();

        // Árbol 1 nodo
        arbolSoloRaiz = new TArbolBB<>();
        arbolSoloRaiz.insertar(new TElementoAB<>(1, 1));

        // Nivel con 2 nodos: Raíz 2, hijo izq 1
        arbolNivel = new TArbolBB<>();
        arbolNivel.insertar(new TElementoAB<>(2, 2));
        arbolNivel.insertar(new TElementoAB<>(1, 1));

        // Nivel con 3 Nodos. 2 al mismo nivel: Raíz 3, hijo izq 1, hijo izq 2
        arbolNivel2 = new TArbolBB<>();
        arbolNivel2.insertar(new TElementoAB<>(3, 3));
        arbolNivel2.insertar(new TElementoAB<>(2, 2));
        arbolNivel2.insertar(new TElementoAB<>(1, 1));
        
         // Nivel con 3 Nodos. 2 al mismo nivel: Raíz 2, hijo izq 1, hijo der 1
        arbolNivelDos = new TArbolBB<>();
        arbolNivelDos.insertar(new TElementoAB<>(2, 2));
        arbolNivelDos.insertar(new TElementoAB<>(3, 3));
        arbolNivelDos.insertar(new TElementoAB<>(1, 1));

        // Nivel con 5 nodos: Raíz 1, (hijo izq 1 -> 0), hijo der 2, 3 y 4
        arbolNivel3 = new TArbolBB<>();
        arbolNivel3.insertar(new TElementoAB<>(1, 1));
        arbolNivel3.insertar(new TElementoAB<>(0, 0));
        arbolNivel3.insertar(new TElementoAB<>(2, 2));
        arbolNivel3.insertar(new TElementoAB<>(3, 3));
        arbolNivel3.insertar(new TElementoAB<>(4, 4));

    }

    @Test
    public void testNivelClaveVacio() {
        Comparable unaClave = 1;
        int expResult = -1;
        int result = arbolVacio.nivelClave(unaClave);
        assertEquals(expResult, result);
    }

    @Test
    public void testNivelClaveUnNodo() {
        Comparable unaClave = 1;
        int expResult = 1;
        int result = arbolSoloRaiz.nivelClave(unaClave);
        assertEquals(expResult, result);
    }

    @Test
    public void testNivelClaveDosNodos() {
        Comparable unaClave = 1;
        int expResult = 2;
        int result = arbolNivel.nivelClave(unaClave);
        assertEquals(expResult, result);
    }

    @Test
    public void testNivelClaveTresNodos() {
        Comparable unaClave = 1;
        int expResult = 3;
        int result = arbolNivel2.nivelClave(unaClave);
        assertEquals(expResult, result);
    }

    /**
     * Test of completarNodosExternos method, of class TArbolBB.
     */
    @Test
    public void testCompletarNodosExternos() {
        int[] vectorBetas = null;
        TArbolBB instance = new TArbolBB();
        instance.completarNodosExternos(vectorBetas);

    }

    @Test
    public void testTrayectInterMedia() {

        TArbolBB instance = new TArbolBB();
        float expResult = 0.0F;
        float result = instance.trayectInterMedia();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of trayectInterMediaMejorado method, of class TArbolBB.
     */
    @Test
    public void testTrayectInterMediaMejorado() {
        TArbolBB instance = new TArbolBB();
        float expResult = 0.0F;
        float result = instance.trayectInterMediaMejorado();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularCosto method, of class TArbolBB.
     */
    @Test
    public void testCalcularCosto() {
        int[] FrecExito = null;
        int[] FrecNoExito = null;
        TArbolBB instance = new TArbolBB();
        long expResult = 0L;
        long result = instance.calcularCosto(FrecExito, FrecNoExito);
        assertEquals(expResult, result);
    }

    /**
     * Test of nivelMasProfundo method, of class TArbolBB.
     */
    @Test
    public void testNivelMasProfundoArbolVacio() {
        int expResult = -1;
        int result = arbolVacio.nivelMasProfundo();
        assertEquals(expResult, result);
    }

    /**
     * Test of nivelMasProfundo method, of class TArbolBB.
     */
    @Test
    public void testNivelMasProfundoArbolSoloRaiz() {
        int expResult = 1;
        int result = arbolSoloRaiz.nivelMasProfundo();
        assertEquals(expResult, result);
    }

    /**
     * Test of nivelMasProfundo method, of class TArbolBB.
     */
    @Test
    public void testNivelMasProfundoArbolNivel1() {
        int expResult = 2;
        int result = arbolNivel.nivelMasProfundo();
        assertEquals(expResult, result);
    }

    /**
     * Test of nivelMasProfundo method, of class TArbolBB.
     */
    @Test
    public void testNivelMasProfundoArbolNivel2() {
        int expResult = 3;
        int result = arbolNivel2.nivelMasProfundo();
        assertEquals(expResult, result);
    }

    /**
     * Test of nivelMasProfundo method, of class TArbolBB.
     */
    @Test
    public void testNivelMasProfundoArbolNivel3() {
        int expResult = 4;
        int result = arbolNivel3.nivelMasProfundo();
        assertEquals(expResult, result);
    }

    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolVacio() {
        int nivel = 4;
        Lista expResult = new Lista();
        Lista result = arbolVacio.clavesNivel(nivel);
        int tamanioExp = expResult.cantElementos();
        int tamanioRes = result.cantElementos();
        assertEquals(tamanioExp, tamanioRes);
    }

    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolVacio2() {
        int nivel = 300;
        Lista expResult = new Lista();
        Lista result = arbolVacio.clavesNivel(nivel);
        Boolean esvacioExp = expResult.esVacia();
        Boolean esvacioRes = result.esVacia();
        assertEquals(esvacioExp, esvacioRes);
    }

    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolSoloRaiz() {
        int nivel = 1;
        Lista expResult = new Lista();
        expResult.insertar(new Nodo(1,1));
        Lista result = arbolSoloRaiz.clavesNivel(nivel);
        Comparable primeroExp = expResult.getPrimero().getEtiqueta();
        Comparable primeroRes = result.getPrimero().getEtiqueta();
        assertEquals(primeroExp, primeroRes);
    }

    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolSoloRaiz2() {
        int nivel = 1;
        Lista expResult = new Lista();
        expResult.insertar(new Nodo(1,1));
        Lista result = arbolSoloRaiz.clavesNivel(nivel);
        int tamanioExp = expResult.cantElementos();
        int tamanioRes = result.cantElementos();
        assertEquals(tamanioExp, tamanioRes);
    }

    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolSoloRaiz3() {
        int nivel = 3;
        Lista expResult = new Lista();
        Lista result = arbolSoloRaiz.clavesNivel(nivel);
        Boolean esvacioExp = expResult.esVacia();
        Boolean esvacioRes = result.esVacia();
        assertEquals(esvacioExp, esvacioRes);
    }
    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolNivel() {
        int nivel = 2;
        Lista expResult = new Lista();
        expResult.insertar(new Nodo(1,1));
        Lista result = arbolNivel.clavesNivel(nivel);
        Boolean esvacioExp = expResult.esVacia();
        Boolean esvacioRes = result.esVacia();
        assertEquals(esvacioExp, esvacioRes);
    }
    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolNivel2() {
        int nivel = 2;
        Lista expResult = new Lista();
        expResult.insertar(new Nodo(1,1));
        Lista result = arbolNivel.clavesNivel(nivel);
        Comparable primeroExp = expResult.getPrimero().getEtiqueta();
        Comparable primeroRes = result.getPrimero().getEtiqueta();
        assertEquals(primeroExp, primeroRes);
    }
    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolNivel3() {
        int nivel = 2;
        Lista expResult = new Lista();
        expResult.insertar(new Nodo(1,1));
        Lista result = arbolNivel.clavesNivel(nivel);
        int tamExp = expResult.cantElementos();
        int tamRes = result.cantElementos();
        assertEquals(tamExp, tamRes);
    }
    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolNivel4() {
        int nivel = 3;
        Lista expResult = new Lista();
        Lista result = arbolNivel.clavesNivel(nivel);
        int tamExp = expResult.cantElementos();
        int tamRes = result.cantElementos();
        assertEquals(tamExp, tamRes);
    }
    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolNivel5() {
        int nivel = 3;
        Lista expResult = new Lista();
        Lista result = arbolNivel.clavesNivel(nivel);
        Boolean tamExp = expResult.esVacia();
        Boolean tamRes = result.esVacia();
        assertEquals(tamExp, tamRes);
    }
    /**
     * Test of clavesNivel method, of class TArbolBB.
     */
    @Test
    public void testClavesNivelArbolNivelDos() {
        int nivel = 2;
        Lista expResult = new Lista();
        expResult.insertar(new Nodo(1,1));
        expResult.insertar(new Nodo(2,2));
        Lista result = arbolNivelDos.clavesNivel(nivel);
        int tamExp = expResult.cantElementos();
        int tamRes = result.cantElementos();
        assertEquals(tamExp, tamRes);
    }
}
