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

    TArbolPiezas instance = new TArbolPiezas();
    TElementoAB<Pieza> elemento1 = new TElementoAB<>("0332002150", new Pieza("0332002150", "9.2.1", "Relays", 5, 99));
    TElementoAB<Pieza> elemento2 = new TElementoAB<>("1987431228", new Pieza("1987431228", "8.5.4", "Active Carbon Cabin Filters - HCV", 2, 121));
    TElementoAB<Pieza> elemento3 = new TElementoAB<>("0130007325", new Pieza("0130007325", "9.7.1", "Electric Parts - HCV", 2, 302));

    /**
     * Test of piezasPorRubro method, of class TArbolPiezas.
     */
    @Test
    public void testPiezasPorRubro() {
        String unRubro = "9";
        instance.insertar(elemento1);
        instance.insertar(elemento2);
        instance.insertar(elemento3);
        TArbolPiezas result = instance.piezasPorRubro(unRubro);
        Lista<Pieza> inOrden = result.inorden();
        Nodo<Pieza> pieza = inOrden.getPrimero();
        while (pieza != null) {
            assertEquals(unRubro, pieza.getDato().obtenerRubro());
            pieza = pieza.getSiguiente();
        }
    }

    /**
     * Test of cantYvalorStock method, of class TArbolPiezas.
     */
    @Test
    public void testCantYvalorStock() {
        TArbolPiezas instance = new TArbolPiezas();
        Pieza pieza1 = new Pieza("KS213321", "10.4.5", "Pump", 10, 2010);
        Pieza pieza2 = new Pieza("KS2133334321", "10.4.8", "Pump", 10, 2010);
        Pieza pieza3 = new Pieza("KS2441", "10.7.3", "Pump", 10, 2010);
        instance.insertar(new TElementoAB<>("KS213321", pieza1));
        instance.insertar(new TElementoAB<>("KS2133334321", pieza2));
        instance.insertar(new TElementoAB<>("KS2441", pieza3));
        int expResult = 0;
        int[] preResult = instance.cantYvalorStock();
        int result = preResult[0];
        assertEquals(expResult, result);
    }

}
