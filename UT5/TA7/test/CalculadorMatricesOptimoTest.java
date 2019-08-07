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
public class CalculadorMatricesOptimoTest {

    int cantElem;
    CalculadorMatricesOptimo instance;
   @Before
    public void setUp() {
        cantElem = 4;
        instance = new CalculadorMatricesOptimo(cantElem);
       
    }
    
    /**
     * Test of encontrarOptimo method, of class CalculadorMatricesOptimo.
     */
    @Test
    public void testEncontrarOptimo() {
        
        int[] frecNoExito = {1, 3, 1, 3, 7};
        int[] frecExito = {0, 5, 3, 4, 2};
        
        instance.encontrarOptimo(cantElem, frecExito, frecNoExito);
        int expResult = 3;
        int result = instance.r[0][cantElem];
        assertEquals(expResult, result);
    }

}
