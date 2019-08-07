/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class TArbolBBTest {
    
    public TArbolBBTest() {
    }

    /**
     * Test of insertar method, of class TArbolBB.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        TElementoAB unElemento = null;
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.insertar(unElemento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class TArbolBB.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Comparable unaEtiqueta = null;
        TArbolBB instance = new TArbolBB();
        TElementoAB expResult = null;
        TElementoAB result = instance.buscar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preOrden method, of class TArbolBB.
     */
    @Test
    public void testPreOrden() {
        System.out.println("preOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.preOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrden method, of class TArbolBB.
     */
    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.inOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerMenorClave method, of class TArbolBB.
     */
    @Test
    public void testObtenerMenorClave() {
        System.out.println("obtenerMenorClave");
        TArbolBB instance = new TArbolBB();
        TElementoAB expResult = null;
        TElementoAB result = instance.obtenerMenorClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerMayorClave method, of class TArbolBB.
     */
    @Test
    public void testObtenerMayorClave() {
        System.out.println("obtenerMayorClave");
        TArbolBB instance = new TArbolBB();
        TElementoAB expResult = null;
        TElementoAB result = instance.obtenerMayorClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPadre method, of class TArbolBB.
     */
    @Test
    public void testGetPadre() {
        System.out.println("getPadre");
        Comparable clave = null;
        TArbolBB instance = new TArbolBB();
        TElementoAB expResult = null;
        TElementoAB result = instance.getPadre(clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of postOrden method, of class TArbolBB.
     */
    @Test
    public void testPostOrden() {
        System.out.println("postOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.postOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class TArbolBB.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Comparable unaEtiqueta = null;
        TArbolBB instance = new TArbolBB();
        instance.eliminar(unaEtiqueta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esVacio method, of class TArbolBB.
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        TArbolBB instance = new TArbolBB();
        Boolean expResult = null;
        Boolean result = instance.esVacio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void testObtenerAltura() {
        System.out.println("obtenerAltura");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTamanio method, of class TArbolBB.
     */
    @Test
    public void testObtenerTamanio() {
        System.out.println("obtenerTamanio");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNivel method, of class TArbolBB.
     */
    @Test
    public void testObtenerNivel() {
        System.out.println("obtenerNivel");
        Comparable unaEtiqueta = null;
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerNivel(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arbolBinario method, of class TArbolBB.
     */
    @Test
    public void testArbolBinario() {
        System.out.println("arbolBinario");
        TArbolBB instance = new TArbolBB();
        Boolean expResult = null;
        Boolean result = instance.arbolBinario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCantidadHojas method, of class TArbolBB.
     */
    @Test
    public void testObtenerCantidadHojas() {
        System.out.println("obtenerCantidadHojas");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerCantidadHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarHojas method, of class TArbolBB.
     */
    @Test
    public void testListarHojas() {
        System.out.println("listarHojas");
        TArbolBB instance = new TArbolBB();
        LinkedList<Comparable> expResult = null;
        LinkedList<Comparable> result = instance.listarHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
