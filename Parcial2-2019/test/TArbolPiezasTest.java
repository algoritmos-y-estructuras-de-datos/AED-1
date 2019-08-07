/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class TArbolPiezasTest {
    
    public TArbolPiezasTest() {
    }

    /**
     * Test of piezasPorRubro method, of class TArbolPiezas.
     */
    @Test
    public void testPiezasPorRubro() {
        String unRubro = "10";
        TArbolPiezas instance = new TArbolPiezas();
        Pieza pieza1 = new Pieza("KS213321","10.4.5","Pump",10,2010);
        Pieza pieza2 = new Pieza("KS2133334321","10.4.8","Pump",10,2010);
        Pieza pieza3 = new Pieza("KS2441","10.7.3","Pump",10,2010);
        instance.insertar(new TElementoAB<>("KS213321",pieza1));
        instance.insertar(new TElementoAB<>("KS2133334321",pieza2));
        instance.insertar(new TElementoAB<>("KS2441",pieza3));
        TArbolPiezas expResult = null;
        TArbolPiezas result = instance.piezasPorRubro(unRubro);
        assertEquals(expResult, result);
    }

    /**
     * Test of cantYvalorStock method, of class TArbolPiezas.
     */
    @Test
    public void testCantYvalorStock() {
        TArbolPiezas instance = new TArbolPiezas();
        Pieza pieza1 = new Pieza("KS213321","10.4.5","Pump",10,2010);
        Pieza pieza2 = new Pieza("KS2133334321","10.4.8","Pump",10,2010);
        Pieza pieza3 = new Pieza("KS2441","10.7.3","Pump",10,2010);
        instance.insertar(new TElementoAB<>("KS213321",pieza1));
        instance.insertar(new TElementoAB<>("KS2133334321",pieza2));
        instance.insertar(new TElementoAB<>("KS2441",pieza3));
        int expResult = 0;
        int[] preResult = instance.cantYvalorStock();
        int result = preResult[0];
        assertEquals(expResult, result);
    }
    
}
