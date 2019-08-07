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
public class PiezaTest {
    
    public PiezaTest() {
    }
    /**
     * Test of obtenerRubro method, of class Pieza.
     */
    @Test
    public void testObtenerRubro() {
        Pieza instance = new Pieza("KS100","17.4.2","Pumps BMX",2,2013);
        String expResult = "17";
        String result = instance.obtenerRubro();
        assertEquals(expResult, result);
    }
    
}
