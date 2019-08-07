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
public class AlgABOTest {
    
    public AlgABOTest() {
    }

    @Test
    public void testEncontrarOptimo() {
        System.out.println("EncontrarOptimo");
        int cantElem = 0;
        int[] frecExito = null;
        int[] frecNoExito = null;
        AlgABO instance = null;
        instance.EncontrarOptimo(cantElem, frecExito, frecNoExito);
        fail("The test case is a prototype.");
    }

    @Test
    public void testArmarArbolBinario() {
        System.out.println("ArmarArbolBinario");
        int i = 0;
        int j = 0;
        String[] Claves = null;
        TArbolBB elArbolBB = null;
        AlgABO instance = null;
        instance.ArmarArbolBinario(i, j, Claves, elArbolBB);
        fail("The test case is a prototype.");
    }

    @Test
    public void testImprimirMatriz() {
        System.out.println("imprimirMatriz");
        int[][] matriz = null;
        AlgABO instance = null;
        instance.imprimirMatriz(matriz);
        fail("The test case is a prototype.");
    }
    
}
