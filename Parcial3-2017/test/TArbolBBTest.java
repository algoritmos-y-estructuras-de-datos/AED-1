/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marce
 */
public class TArbolBBTest {
    
    public TArbolBBTest() {
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.insertar(null);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.inOrden();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVaciar() {
        System.out.println("vaciar");
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.vaciar();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPreOrden() {
        System.out.println("preOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.preOrden();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPostOrden() {
        System.out.println("postOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.postOrden();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularCosto() {
        System.out.println("calcularCosto");
        int[] FrecExito = null;
        int[] FrecNoExito = null;
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.calcularCosto(FrecExito, FrecNoExito);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
