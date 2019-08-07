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
public class PlayerTest {
    Player instance;
    public PlayerTest() {
        instance = new Player("1","1");
        
    }
    
    @Before
    public void setUp(){
        instance.playerPositions.insertar(new Nodo("A","A"));
    }

    /**
     * Test of getId method, of class Player.
     */
    @Test
    public void testGetId() {

        Comparable expResult = "1";
        Comparable result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        String expResult = "1";
        String result = instance.getName();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPosicion method, of class Player.
     */
    @Test
    public void testGetPosicion() {
        String expResult = "A";
        String result = instance.getPosicion();
        assertEquals(expResult, result);
    }
    
}
