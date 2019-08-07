
public class Parcial3 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        /**
         *
         * LEER ATENTAMENTE LAS INDICACIONES.
         *
         * Paso 1:
         *
         * 1.1 - instanciar un árbol binario de búsqueda y cargar las palabras
         * del índice
         */
        TArbolIndice indice = new TArbolIndice();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/PalabrasIndice.txt");
        for (String l : lineas) {
            String[] datos = l.split(" ");
            TElementoAB<String> elem = new TElementoAB<>(datos[0], datos[0]);
            indice.insertar(elem);
        }

        int cantElementos = lineas.length;
        String[] lasClaves = new String[cantElementos + 1];
        int[] frecExito = new int[cantElementos + 1];
        int[] frecNoExito = new int[cantElementos + 1];

        /**
         * Paso 2:
         *
         * 2.1 - recorrer el archivo del libro, y para cada palabra actualizar
         * las frecuencias en el árbol
         *
         */
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo("./src/libro.txt");
        //......
        // ATENCIÓN: USAR VERSIÓN DE SPLIT : split("\\W+")
        for (String linea2 : lineasLibro) {
            String[] limpio = linea2.split("\\W+");
            for (String linea3 : limpio) {
                indice.actualizarFrecuencias(linea3);
            }
        }
        // cargar vectores de claves, frecExito y frecNoExito con el método "listarClavesyFrecuencias"
        indice.listarClavesyFrecuencias(lasClaves, frecExito, frecNoExito);
        //calcular matrices árbol óptimo
        // imprimir matrices por consola
        TArbolBB elArbol = new TArbolBB();
        CalculadorMatricesOptimo abo = new CalculadorMatricesOptimo(cantElementos);
        abo.encontrarOptimo(cantElementos, frecExito, frecNoExito);

        System.out.println("Raiz: " + abo.R[0][cantElementos]);
        System.out.println("Matriz R: ");
        Util.imprimirMatriz(abo.R);
        System.out.println("Matriz P: ");
        Util.imprimirMatriz(abo.P);
        System.out.println("Matriz W: ");
        Util.imprimirMatriz(abo.W);

        System.out.println("costo del arbol optimo : " + abo.P[0][cantElementos]);
        // imprimir costo del árbol óptimo
        // crear árbol binario de búsqueda a partir de la matriz R - método CalculadorMatricesOptimo.armarArbolBinario
        TArbolBB elArbolito = new TArbolBB();
        abo.armarArbolBinario(0, cantElementos, lasClaves, elArbolito);
        // obtener el preorden del árbol y escribir un archivo "preorden.txt"
        Nodo aux5 = elArbolito.preOrden().getPrimero();
        while (aux5 != null) {
            String[] escritura = {aux5.getEtiqueta().toString()};
            ManejadorArchivosGenerico.escribirArchivo("./src/preorden.txt", escritura);
            aux5 = aux5.getSiguiente();
        }
        // imprimir en consola el costo del árbol invocando a calcularCosto
        System.out.println("Costo del árbol invocando a calcularCosto: " + elArbolito.calcularCosto(frecExito, frecNoExito));
        String unaClave = "science"; // se indicará en el pizarrón
        // imprimir por consola el nivel en que se encuentra la clave indicada
        System.out.println("El nivel de "+unaClave+" es: "+elArbolito.nivelClave(unaClave));
        // imprimir por consola el nivel más profundo del árbol
        int nivelMasProfundo = elArbolito.nivelMasProfundo();
        System.out.println("El nivel mas profundo es: "+nivelMasProfundo);
        // obtener una lista con todas las claves del nivel más profundo y emitir 
        System.out.println(elArbolito.clavesNivel(nivelMasProfundo).imprimir());
        // un archivo "clavesnivel.txt" con estas claves en orden ascendente
        TArbolBB al = new TArbolBB();
        Nodo aux6 = elArbolito.clavesNivel(nivelMasProfundo).getPrimero();
        while (aux6 != null) {
            al.insertar(new TElementoAB(aux6.getEtiqueta(),aux6.getEtiqueta()));
            aux6 = aux6.getSiguiente();
        }
        Nodo aux7 = al.inOrden().getPrimero();
        while (aux7 != null) {
            String[] escritura = {aux7.getEtiqueta().toString()};
            ManejadorArchivosGenerico.escribirArchivo("./src/clavesnivel.txt", escritura);
            aux7 = aux7.getSiguiente();
        }
    }
}
