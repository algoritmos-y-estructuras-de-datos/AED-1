package UT03.TA2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas de Producto
 * @author Grupo 7
 */
public class ProductoTest {
    
    Producto producto1;
    
    public ProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        producto1 = new Producto("producto1", 10, 2, "salchipapa");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEtiqueta method, of class Producto.
     */
    @Test
    public void testGetEtiqueta() {
        assertEquals(producto1.getEtiqueta(), "producto1");
    }

    /**
     * Test of getPrecio method, of class Producto.
     */
    @Test
    public void testGetPrecio() {
        assertEquals(producto1.getPrecio(), (Integer)10);
    }

    /**
     * Test of setPrecio method, of class Producto.
     */
    @Test
    public void testSetPrecio() {
        assertEquals(producto1.getPrecio(), (Integer)10);
        producto1.setPrecio(20);
        assertEquals(producto1.getPrecio(), (Integer)20);
    }

    /**
     * Test of getStock method, of class Producto.
     */
    @Test
    public void testGetStock() {
        assertEquals(producto1.getStock(), (Integer)2);
    }

    /**
     * Test of setStock method, of class Producto.
     */
    @Test
    public void testSetStock() {
        assertEquals(producto1.getStock(), (Integer)2);
        producto1.setStock(4);
        assertEquals(producto1.getStock(), (Integer)4);
    }

    /**
     * Test of getNombre method, of class Producto.
     */
    @Test
    public void testGetNombre() {
        assertEquals(producto1.getNombre(), "salchipapa");
    }

    /**
     * Test of setNombre method, of class Producto.
     */
    @Test
    public void testSetNombre() {
        assertEquals(producto1.getNombre(), "salchipapa");
        producto1.setNombre("panchos");
        assertEquals(producto1.getNombre(), "panchos");
    }
    
}
