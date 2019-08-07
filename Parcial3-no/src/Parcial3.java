
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
        //...
        //...
        //...
        
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

        
        // cargar vectores de claves, frecExito y frecNoExito con el método "listarClavesyFrecuencias"
       
        

        //calcular matricees árbol óptimo
        // imprimir matrices por consola
        
     
        TArbolBB elArbol = new TArbolBB();
        
        // imprimir costo del árbol óptimo
        
        // crear árbol binario de búsqueda a partir de la matriz R - método CalculadorMatricesOptimo.armarArbolBinario
     
        // obtener el preorden del árbol y escribir un archivo "preorden.txt"
        
        // imprimir en consola el costo del árbol invocando a calcularCosto
     
        
        String unaClave = "xx"; // se indicará en el pizarrón
        // imprimir por consola el nivel en que se encuentra la clave indicada
     
        
        // imprimir por consola el nivel más profundo del árbol
        int nivelMasProfundo = elArbol.nivelMasProfundo();
     
        
        // obtener una lista con todas las claves del nivel más profundo y emitir 
        // un archivo "clavesnivel.txt" con estas claves en orden ascendente
     
        
        
    }
}
