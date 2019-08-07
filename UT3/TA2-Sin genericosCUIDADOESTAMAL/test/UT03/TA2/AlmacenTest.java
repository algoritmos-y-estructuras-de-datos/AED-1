package UT03.TA2;

import UT03.TA2.TAD.IProducto;
import UT03.TA2.TAD.Lista;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas de Almacen
 * @author Grupo 7
 */
public class AlmacenTest {
    
    Almacen almacen;
    
    public AlmacenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Producto producto1 = new Producto("producto1", 10, 2, "pancho");
        Producto producto2 = new Producto("producto2", 10, 2, "burger");
        Producto producto3 = new Producto("producto3", 10, 2, "pizza");
        Producto producto4 = new Producto("producto4", 10, 2, "fritas");
        almacen = new Almacen("Sevilla 1234", "24054345", "La Cantina de la UCU");
        // Cuatro productos en orden: producto2 -> producto3 -> producto1 -> producto4
        almacen.insertarProducto(producto2);
        almacen.insertarProducto(producto3);
        almacen.insertarProducto(producto1);
        almacen.insertarProducto(producto4);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDireccion method, of class Almacen.
     */
    @Test
    public void testGetDireccion() {
        assertEquals(almacen.getDireccion(), "Sevilla 1234");
    }

    /**
     * Test of getTelefono method, of class Almacen.
     */
    @Test
    public void testGetTelefono() {
        assertEquals(almacen.getTelefono(), "24054345");
    }

    /**
     * Test of getNombre method, of class Almacen.
     */
    @Test
    public void testGetNombre() {
        assertEquals(almacen.getNombre(), "La Cantina de la UCU");
    }

    /**
     * Test of getListaProductos method, of class Almacen.
     */
    @Test
    public void testGetListaProductos() {
        assertEquals(almacen.getListaProductos().cantElementos(), 4);
        assertEquals(almacen.getListaProductos().buscar("producto1").getEtiqueta(), "producto1");
        assertEquals(almacen.getListaProductos().buscar("producto2").getEtiqueta(), "producto2");
        assertEquals(almacen.getListaProductos().buscar("producto3").getEtiqueta(), "producto3");
        assertEquals(almacen.getListaProductos().buscar("producto4").getEtiqueta(), "producto4");
    }

    /**
     * Test of setDireccion method, of class Almacen.
     */
    @Test
    public void testSetDireccion() {
        almacen.setDireccion("Sevilla 1235");
        assertEquals(almacen.getDireccion(), "Sevilla 1235");
    }

    /**
     * Test of setTelefono method, of class Almacen.
     */
    @Test
    public void testSetTelefono() {
        almacen.setTelefono("1234567");
        assertEquals(almacen.getTelefono(), "1234567");
    }

    /**
     * Test of insertarProducto method, of class Almacen.
     */
    @Test
    public void testInsertarProducto() {
        Producto productoNuevo = new Producto("producto5", 10, 2, "alfajores");
        almacen.insertarProducto(productoNuevo);
        assertEquals(almacen.getListaProductos().cantElementos(), 5);
        assertEquals(almacen.getListaProductos().buscar("producto5").getEtiqueta(), "producto5");
    }

    /**
     * Test of eliminar method, of class Almacen.
     */
    @Test
    public void testEliminar() {
        almacen.eliminar("producto4");
        assertEquals(almacen.getListaProductos().cantElementos(), 3);
        assertEquals(almacen.getListaProductos().buscar("producto4"), null);
    }

    /**
     * Test of imprimirProductos method, of class Almacen.
     */
    @Test
    public void testImprimirProductos() {
        assertEquals(almacen.imprimirProductos(), "producto2producto3producto1producto4");
    }

    /**
     * Test of imprimirSeparador method, of class Almacen.
     */
    @Test
    public void testImprimirSeparador() {
        assertEquals(almacen.imprimirSeparador(", "), "producto2, producto3, producto1, producto4");
    }

    /**
     * Test of agregarStock method, of class Almacen.
     */
    @Test
    public void testAgregarStock() {
        IProducto productoActual = almacen.buscarPorCodigo("producto2");
        assertEquals(productoActual.getStock(), (Integer)2);
        almacen.agregarStock("producto2", 3);
        assertEquals(productoActual.getStock(), (Integer)5);
        almacen.agregarStock("producto3", 3); // Inexistente
        assertEquals(productoActual.getStock(), (Integer)5);
    }

    /**
     * Test of restarStock method, of class Almacen.
     */
    @Test
    public void testRestarStock() {
        IProducto productoActual = almacen.buscarPorCodigo("producto2");
        assertEquals(productoActual.getStock(), (Integer)2);
        assertEquals(almacen.restarStock("producto2", 1), (Integer)1);
        assertEquals(productoActual.getStock(), (Integer)1);
    }

    /**
     * Test of buscarPorCodigo method, of class Almacen.
     */
    @Test
    public void testBuscarPorCodigo() {
        IProducto productoActual = almacen.buscarPorCodigo("producto2");
        assertEquals(productoActual.getEtiqueta(), "producto2");
        IProducto productoInexistente = almacen.buscarPorCodigo("producto9");
        assertEquals(productoInexistente, null);
    }

    /**
     * Test of listarOrdenadoPorNombre method, of class Almacen.
     */
    @Test
    public void testListarOrdenadoPorNombre() {
        almacen.listarOrdenadoPorNombre(); // Imprime bien! (ver consola)
        /*
            burger
            fritas
            pancho
            pizza
        */
    }

    /**
     * Test of buscarPorDescripcion method, of class Almacen.
     */
    @Test
    public void testBuscarPorDescripcion() {
        IProducto productoActual = almacen.buscarPorDescripcion("burger");
        assertEquals(productoActual.getEtiqueta(), "producto2");
        IProducto productoInexistente = almacen.buscarPorDescripcion("algo que no existe");
        assertEquals(productoInexistente, null);
    }

    /**
     * Test of cantidadProductos method, of class Almacen.
     */
    @Test
    public void testCantidadProductos() {
        assertEquals(almacen.cantidadProductos(), 4);
    }
    
    /**
     * Test of valorTotalStock method, of class Almacen.
     */
    @Test
    public void testValorTotalStock() {
        assertEquals(almacen.valorTotalStock(), (Integer)80);
        almacen.eliminar("producto2");
        assertEquals(almacen.valorTotalStock(), (Integer)60);
    }
    
    /**
     * Test of insertarProductoStock method, of class Almacen.
     */
    @Test
    public void testInsertarProductoStock() {
        Producto producto5 = new Producto("producto5", 10, 2, "frutas");
        almacen.insertarProductoStock(producto5);
        assertEquals(almacen.buscarPorCodigo("producto5").getStock(), (Integer)2);
        assertEquals(almacen.valorTotalStock(), (Integer)100);
        almacen.insertarProductoStock(producto5);
        assertEquals(almacen.buscarPorCodigo("producto5").getStock(), (Integer)4);
        assertEquals(almacen.valorTotalStock(), (Integer)120);
    }
}
