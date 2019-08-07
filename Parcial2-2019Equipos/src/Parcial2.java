
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Parcial2 {

    public static void main(String[] args) throws IOException {

        /**
         *
         * LEER ATENTAMENTE LAS INDICACIONES.
         *
         * Paso 1:
         *
         * 1.1 - instanciar un árbol de piezas (desciende de árbol binario de
         * búsqueda)
         *
         * 1.2 - cargar las piezas del archivo "piezas.txt" e insertarlas en el
         * árbol
         *
         */
        TArbolPiezas piezas = new TArbolPiezas();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/piezas.txt");
        String[][] productoAux = new String[lineas.length][5];
        for (int i = 0; i < lineas.length; i++) {
            productoAux[i] = lineas[i].split(",", -1);
            if (productoAux[i][0] != null && productoAux[i][1] != null && productoAux[i][2] != null && productoAux[i][3] != null && productoAux[i][4] != null) {
                Pieza nuevo = new Pieza(productoAux[i][0], productoAux[i][1], productoAux[i][2], Integer.parseInt(productoAux[i][3]), Integer.parseInt(productoAux[i][4]));

                piezas.insertar(new TElementoAB<>(productoAux[i][0], nuevo));

            }
        }
        /**
         * Paso 2:
         *
         * 2.1 - Invocar al método “cantYvalorStock” del árbol y mostrar por
         * pantalla los valores de cantidad total de piezas existentes y valor
         * total del stock.
         *
         */
        int[] cantidadYvalor = piezas.cantYvalorStock();
        System.out.println("Cantidad: " + cantidadYvalor[1]);
        System.out.println("Valor stock: " + cantidadYvalor[0]);
        /**
         * Paso 3:
         *
         * guardar un archivo "deposito.txt" conteniendo el listado - ordenado
         * ascendentemente por código de pieza - de todas las piezas del stock.
         * en cada línea debe aparecer: CODIGO, VALOR MONETARIO de la pieza en
         * stock - cantidad * precio
         *
         */
        Nodo<Pieza> aux3 = piezas.inorden().getPrimero();
        TArbolBB<Pieza> arbolOrdenCodigo = new TArbolBB<>();
        while (aux3 != null) {
            arbolOrdenCodigo.insertar(new TElementoAB<>(aux3.getDato().getCodigoCatalogo(), aux3.getDato()));
            aux3 = aux3.getSiguiente();
        }

        Nodo<Pieza> aux4 = arbolOrdenCodigo.inorden().getPrimero();
        while (aux4 != null) {
            String[] escritura = {aux4.getEtiqueta().toString() + "," + aux4.getDato().getValorEnStock()};
            ManejadorArchivosGenerico.escribirArchivo("src/deposito.txt", escritura);
            aux4 = aux4.getSiguiente();
        }
        /**
         * Paso 4:
         *
         * crear un nuevo arbol de piezas que contenga solamente las piezas del
         * rubro indicado en el pizarron, y luego emitir un archivo
         * "porRubro.txt" conteniendo el listado - ordenado ascendentemente por
         * código de pieza - de todas las piezas contenidas en este árbol, con
         * el mismo formato que el archivo "deposito.txt"
         *
         */
        /* por último, imprimir por consola la cantidad de piezas y el valor de stock
        de las piezas del rubro indicado
         */
        // rubro 11
        TArbolPiezas arbolRubro11 = piezas.piezasPorRubro("11");
        Lista<Pieza> lista = piezas.inorden();
        Nodo<Pieza> nodoActual = lista.getPrimero();
        lista = arbolRubro11.inorden();
        nodoActual = lista.getPrimero();
        Pieza piezaActual;
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/porRubro.txt"));
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            bw.write(piezaActual.getCodigoPieza() + ", " + piezaActual.getValorEnStock() + "\n");
            nodoActual = nodoActual.getSiguiente();
        }
        bw.close();

        cantidadYvalor = arbolRubro11.cantYvalorStock();
        System.out.println("Cantidad total de rubro 11:" + cantidadYvalor[0]);
        System.out.println("Valor total de rubro 11:" + cantidadYvalor[1]);
    }

}
