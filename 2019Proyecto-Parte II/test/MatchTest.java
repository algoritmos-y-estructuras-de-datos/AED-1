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
public class MatchTest {
    Match instance;
    public MatchTest() {
        instance = new Match("1","1","1",1,"1","1");
    }

    /**
     * Test of getId method, of class Match.
     */
    @Test
    public void testGetId() {
        String expResult = "1";
        String result = instance.getId();
        assertEquals(Integer.parseInt(expResult), Integer.parseInt(result));
    }

    /**
     * Test of getLeague method, of class Match.
     */
    @Test
    public void testGetLeague() {
        String expResult = "1";
        String result = instance.getLeague();
        assertEquals(Integer.parseInt(expResult), Integer.parseInt(result));
        
    }

    /**
     * Test of getSeason method, of class Match.
     */
    @Test
    public void testGetSeason() {
        Integer expResult = 1;
        Integer result = instance.getSeason();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHomeTeam method, of class Match.
     */
    @Test
    public void testGetHomeTeam() {
        String expResult = "1";
        String result = instance.getHomeTeam();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAwayTeam method, of class Match.
     */
    @Test
    public void testGetAwayTeam() {
        String expResult = "1";
        String result = instance.getAwayTeam();
        assertEquals(expResult, result);
 
    }
    
}
