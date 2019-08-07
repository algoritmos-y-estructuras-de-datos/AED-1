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
public class TeamTest {

    Team instance;

    public TeamTest() {
        instance = new Team("1", "1");
        instance.golesHechosEnTemporada.insertar(new Nodo(2012, 2012));
        instance.golesHechosEnTemporada.insertar(new Nodo(2012, 2012));
        instance.golesHechosEnTemporada.insertar(new Nodo(2013, 2013));
        instance.golesHechosEnTemporada.insertar(new Nodo(2013, 2013));
        instance.golesHechosEnTemporada.insertar(new Nodo(2013, 2013));
        instance.golesHechosEnTemporada.insertar(new Nodo(2014, 2014));
        instance.golesHechosEnTemporada.insertar(new Nodo(2014, 2014));
        instance.golesHechosEnTemporada.insertar(new Nodo(2014, 2014));
        instance.golesHechosEnTemporada.insertar(new Nodo(2014, 2014));
        instance.golesHechosEnTemporada.insertar(new Nodo(2015, 2015));
        instance.golesHechosEnTemporada.insertar(new Nodo(2015, 2015));
        instance.golesHechosEnTemporada.insertar(new Nodo(2015, 2015));
        instance.golesHechosEnTemporada.insertar(new Nodo(2015, 2015));
        instance.golesHechosEnTemporada.insertar(new Nodo(2015, 2015));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2012,2012));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2012,2012));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2013,2013));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2013,2013));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2013,2013));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2014,2014));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2014,2014));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2014,2014));
        instance.golesRecibidosEnTemporada.insertar(new Nodo(2014,2014));

    }

    @Before
    public void setUp() {

    }

    /**
     * Test of getId method, of class Team.
     */
    @Test
    public void testGetId() {

        String expResult = "1";
        String result = instance.getId();
        assertEquals(Integer.parseInt(expResult), Integer.parseInt(result));
    }

    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {

        String expResult = "1";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getGolesHechos method, of class Team.
     */
    @Test
    public void testGetGolesHechos() {
        Integer temporada = 2012;
        int expResult = 2;
        int result = instance.getGolesHechos(temporada);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGolesHechos method, of class Team.
     */
    @Test
    public void testGetGolesHechos3() {
        Integer temporada = 2013;
        int expResult = 3;
        int result = instance.getGolesHechos(temporada);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGolesHechos method, of class Team.
     */
    @Test
    public void testGetGolesHechos4() {
        Integer temporada = 2014;
        int expResult = 4;
        int result = instance.getGolesHechos(temporada);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGolesHechos method, of class Team.
     */
    @Test
    public void testGetGolesHechos5() {
        Integer temporada = 2015;
        int expResult = 5;
        int result = instance.getGolesHechos(temporada);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGolesRecibidos method, of class Team.
     */
    @Test
    public void testGetGolesRecibidos() {

        Integer temporada = 2012;
        int expResult = 2;
        int result = instance.getGolesRecibidos(temporada);
        assertEquals(expResult, result);

    }

    /**
     * Test of getGolesRecibidos method, of class Team.
     */
    @Test
    public void testGetGolesRecibidos2() {

        Integer temporada = 2012;
        int expResult = 2;
        int result = instance.getGolesRecibidos(temporada);
        assertEquals(expResult, result);

    }

    /**
     * Test of getGolesRecibidos method, of class Team.
     */
    @Test
    public void testGetGolesRecibidos3() {

        Integer temporada = 2014;
        int expResult = 4;
        int result = instance.getGolesRecibidos(temporada);
        assertEquals(expResult, result);

    }

    /**
     * Test of getGolesRecibidos method, of class Team.
     */
    @Test
    public void testGetGolesRecibidos4() {

        Integer temporada = 2013;
        int expResult = 3;
        int result = instance.getGolesRecibidos(temporada);
        assertEquals(expResult, result);

    }

    /**
     * Test of getGolesRecibidos method, of class Team.
     */
    @Test
    public void testGetGolesRecibidos5() {

        Integer temporada = 2022;
        int expResult = 0;
        int result = instance.getGolesRecibidos(temporada);
        assertEquals(expResult, result);

    }
}
