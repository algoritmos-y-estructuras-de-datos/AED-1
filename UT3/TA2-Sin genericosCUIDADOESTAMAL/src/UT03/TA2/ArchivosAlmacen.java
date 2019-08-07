package UT03.TA2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Clase para probar archivos del almacen
 * @author Grupo 7
 */
public class ArchivosAlmacen {

    /** Constantes de archivos */
    static final String ARCHIVO_ALTAS = "altas.txt";
    static final String ARCHIVO_ELIM = "elim.txt";
    static final String ARCHIVO_VENTAS = "ventas.txt";
    
    /** Contantes con posiciones de los archivos */
    static final int ETIQUETA = 0;
    static final int NOMBRE = 1;
    static final int PRECIO = 2;
    static final int STOCK = 3;
    static final int STOCK_VENTAS = 1;
    
    public static void main(String args[]) throws Exception {
        
        // Creo nuevo almacen
        Almacen almacen = new Almacen("Sevilla 1234", "24054345", "La Cantina de la UCU");
        
        // Lector para leer archivos
        BufferedReader lector;
        
        // Auxiliar para guarda contenidos
        String contenidos;
        
        // Archivo ARCHIVO_ALTAS
        // Abro archivo
        lector = new BufferedReader(new FileReader(ARCHIVO_ALTAS));
        contenidos = lector.readLine() + "\n";
        while (lector.readLine() != null) {
            contenidos += lector.readLine() + "\n";
        }
        lector.close();
        // Creo y agrego nuevo producto por cada línea
        for (String linea : contenidos.split("\n")) {
            String columnas[] = linea.split(",");
            if (columnas.length == 4)
                almacen.insertarProductoStock(new Producto(columnas[ETIQUETA], Integer.valueOf(columnas[PRECIO]), Integer.valueOf(columnas[STOCK]), columnas[NOMBRE]));
        }
        System.out.println(almacen.imprimirSeparador("\n"));
        
        System.out.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.out.println("Stock producto 1000031:" + almacen.buscarPorCodigo("1000031").getStock());
        System.out.println("Valor total stock:" + almacen.valorTotalStock());
        
        System.out.println("-----------------------------------------------------------");
        
        // Archivo ARCHIVO_VENTAS
        // Abro archivo
        lector = new BufferedReader(new FileReader(ARCHIVO_VENTAS));
        contenidos = lector.readLine() + "\n";
        while (lector.readLine() != null) {
            contenidos += lector.readLine() + "\n";
        }
        lector.close();
        // Resto stock según ventas del archivo
        for (String linea : contenidos.split("\n")) {
            String columnas[] = linea.split(",");
            if (columnas.length == 2)
                almacen.restarStock(columnas[ETIQUETA], Integer.valueOf(columnas[STOCK_VENTAS]));
        }
        System.out.println(almacen.imprimirSeparador("\n"));
        
        System.out.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.out.println("Stock producto 1000031:" + almacen.buscarPorCodigo("1000031").getStock());
        System.out.println("Valor total stock:" + almacen.valorTotalStock());
        
        System.out.println("-----------------------------------------------------------");
        
        // Archivo ARCHIVO_ELIM
        // Abro archivo
        lector = new BufferedReader(new FileReader(ARCHIVO_ELIM));
        contenidos = lector.readLine() + "\n";
        while (lector.readLine() != null) {
            contenidos += lector.readLine() + "\n";
        }
        lector.close();
        // Elimino las etiquetas del archivo
        for (String linea : contenidos.split("\n")) {
            almacen.eliminar(linea.trim());
        }
        System.out.println(almacen.imprimirSeparador("\n"));
        
        System.out.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.out.println("Valor total stock:" + almacen.valorTotalStock());
        
        System.out.println("-----------------------------------------------------------");
        
        
    }
}
