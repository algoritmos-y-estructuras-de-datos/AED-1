
public class Main {

    public static void main(String[] args) {
        
        
        /**
         * EJERCICIO 1
         * 
         */
        
        
        // cargar los productos desde el archivo "altasprueba.txt"
        Almacen campeonDelSiglo = new Almacen("Salon de fiestas");
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/altasPrueba.txt");
        String[][] productoAux = new String[lineas.length][4];
        int precioTotal = 0;
        for (int i = 0; i < lineas.length; i++) {
            productoAux[i] = lineas[i].split(",", -1);
            if (productoAux[i][0] != null && productoAux[i][1] != null && productoAux[i][2] != null && productoAux[i][3] != null){
                Producto nuevo = new Producto(Integer.parseInt(productoAux[i][0]), productoAux[i][1]);
                nuevo.setStock(Integer.parseInt(productoAux[i][3]));
                nuevo.setPrecio(Integer.parseInt(productoAux[i][2]));
                
                precioTotal += nuevo.getValor();
                campeonDelSiglo.insertarProducto(nuevo);
                
            }
        }
        System.out.println("El Monto total ha incrementado: " + precioTotal);
        
        
        // listar los productos ordenados por codigo, junto con su cantidad existente
        Nodo<Producto> aux = campeonDelSiglo.getProductos().inorden().getPrimero();
        while (aux != null) {
            System.out.println(aux.getDato().getEtiqueta().toString() + " " + aux.getDato().getStock());
            aux = aux.getSiguiente();
        }

        //emitir el valor del stock
        System.out.println(precioTotal);

        // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
        String[] productosEliminar = ManejadorArchivosGenerico.leerArchivo("src/elimPrueba.txt");
        for (int i = 0; i < productosEliminar.length; i++) {
            campeonDelSiglo.eliminarProducto(i);
        }

        // listar los productos ordenados por codigo, junto con su cantidad existente
        Nodo<Producto> aux2 = campeonDelSiglo.getProductos().inorden().getPrimero();
        while (aux2 != null) {
            System.out.println(aux2.getDato().getEtiqueta().toString() + aux2.getDato().getStock());
            aux2 = aux2.getSiguiente();
        }

        // simular las ventas a partir del archivo "ventaspruebas.txt"
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/ventasPrueba.txt");
        String[][] ventas = new String[lineas2.length][2];
        for (int i = 0; i < lineas2.length; i++) {
            ventas[i] = lineas2[i].split(",", -1);
            campeonDelSiglo.restarStock(Integer.parseInt(ventas[i][0]), Integer.parseInt(ventas[i][1]));
        }
        System.out.println("Monto Actual" + " " + (precioTotal - campeonDelSiglo.obtenerMontoTotal()));
        
        
        /**
         * EJERCICIO 2
         * 
         */
        
        //(1) EQUIPO A
        /**
         * Eliminar productos desde un archivo y mostrar el monto total de stock perdido
         */
        int montoActual = campeonDelSiglo.obtenerMontoTotal();
        String[] productosEliminar2 = ManejadorArchivosGenerico.leerArchivo("src/elim.txt");
        for (int i = 0; i < productosEliminar2.length; i++) {
            campeonDelSiglo.eliminarProducto(i);
        }
        System.out.println("Perdida de valor de stock: " + (montoActual - campeonDelSiglo.obtenerMontoTotal()));
        
        //(2) EQUIPO B
        /**
         * Escribir archivo con los productos ordenados alfabeticamente con su precio unitario
         */
        Nodo<Producto> aux3 = campeonDelSiglo.getProductos().inorden().getPrimero();
        TArbolBB<Producto> arbolOrdenAlfa = new TArbolBB<>();
        while (aux3 != null) {
            arbolOrdenAlfa.insertar(new TElementoAB<>(aux3.getDato().getNombre(),aux3.getDato()));
            aux3 = aux3.getSiguiente();
        }
        
        Nodo<Producto> aux4 = arbolOrdenAlfa.inorden().getPrimero();
        while (aux4 != null) {
            String[] escritura = {aux4.getEtiqueta().toString() + "," + aux4.getDato().getPrecio().toString()};
            ManejadorArchivosGenerico.escribirArchivo("src/productos.txt", escritura);
            aux4 = aux4.getSiguiente();
        }
        System.out.println("Valor total del stock: " + campeonDelSiglo.obtenerMontoTotal());
        
        /**
         * Dado un codigo de producto, mostrar existencia y cantidad de stock
         */
        int unProducto = 0; //Anotar codigo a buscar
        Producto auxProducto = campeonDelSiglo.buscarPorCodigo(unProducto);
        if ( auxProducto != null)
                System.out.println("Disponible " + auxProducto.getStock());
        
        campeonDelSiglo.getProductos();
        
    }
    
    

}
