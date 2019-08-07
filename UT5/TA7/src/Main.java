
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/palabras2.txt");
        int cantElementos = lineas.length;
        System.out.println(cantElementos);
        CalculadorMatricesOptimo abo = new CalculadorMatricesOptimo(cantElementos);

        String[] claves = new String[cantElementos + 1];
        int[] frecExito = new int[cantElementos + 1];
        int[] frecNoExito = new int[cantElementos + 1];

        for (int i = 0; i < cantElementos; i++) {
            String[] datos = lineas[i].split(" ");
            claves[i + 1] = datos[0].trim();
            System.out.println(datos[0]);
            frecExito[i + 1] = Integer.parseInt(datos[1]);
        }
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/nopalabras2.txt");
        for (int i = 0; i <= cantElementos; i++) {
            frecNoExito[i] = Integer.parseInt(lineas2[i]);
        }

        abo.encontrarOptimo(cantElementos, frecExito, frecNoExito);

        System.out.println("Raiz: " + abo.r[0][cantElementos]);
        System.out.println("Matriz R: ");
        Util.imprimirMatriz(abo.r);
        System.out.println("Matriz P: ");
        Util.imprimirMatriz(abo.p);
        System.out.println("Matriz W: ");
        Util.imprimirMatriz(abo.w);

        System.out.println("costo del arbol optimo : " + abo.p[0][cantElementos]);
        
        TArbolBB elArbol = new TArbolBB();
        abo.armarArbolBinario(0, cantElementos, claves, elArbol);

        // emitir un archivo "preorden.txt" con el listado de las claves en preorden
        // emitir un archivo "inorden.txt" con el listado de las claves en inorden
        // emitir un archivo "postorden.txt" con el listado de las claves en postorden
        System.out.println("inorden: " + elArbol.inOrden());
        Nodo aux4 = elArbol.inOrden().getPrimero();
        while (aux4 != null) {
            String[] escritura = {aux4.getEtiqueta().toString()};
            ManejadorArchivosGenerico.escribirArchivo("src/inorden.txt", escritura);
            aux4 = aux4.getSiguiente();
        }
        System.out.println("preorden: " + elArbol.preOrden());
        Nodo aux5 = elArbol.preOrden().getPrimero();
        while (aux5 != null) {
            String[] escritura = {aux5.getEtiqueta().toString()};
            ManejadorArchivosGenerico.escribirArchivo("src/preorden.txt", escritura);
            aux5 = aux5.getSiguiente();
        }
        System.out.println("postorden: " + elArbol.postOrden());
        Nodo aux6 = elArbol.postOrden().getPrimero();
        while (aux6 != null) {
            String[] escritura = {aux6.getEtiqueta().toString()};
            ManejadorArchivosGenerico.escribirArchivo("src/postorden.txt", escritura);
            aux6 = aux6.getSiguiente();
        }
        System.out.println("costo del arbol iterando: " + elArbol.calcularCosto(frecExito, frecNoExito));

        // invocar a nivelClave, con el parámetro indicado en el pizarrón         
        String laClave = "return"; // se indica en el pizarrón
        String laClave2 = "strict";
        // indicar si la clave está o no en el árbol y cuál sería el nivel correspondiente, 
        // invocando al método alArbol.nivelClave
        System.out.println("Resultado 1: " + elArbol.nivelClave(laClave));
        System.out.println("Resultado 2: " + elArbol.nivelClave(laClave2));
        System.out.println(elArbol.trayectInterMediaMejorado());
        TArbolBB arbol = new TArbolBB();

        String[] lineas5 = ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        for (String l : lineas5) {
            String[] datos = l.split(" ");
            TElementoAB<String> elem = new TElementoAB<>(Integer.parseInt(datos[1]), datos[0]);
            arbol.insertar(elem);
        }
        int cant_claves = arbol.obtenerTamanio();
        String[] lineasBetas = ManejadorArchivosGenerico.leerArchivo("nopalabras.txt");
        int[] vectorBetas = new int[cant_claves + 1];
        for (int h = 0; h < lineasBetas.length; h++) {
            String linea = lineasBetas[h];
            String[] datos = linea.split(" ");
//vectorBetas[h] = Integer.parseInt(datos[1]);
            vectorBetas[h] = Integer.parseInt(datos[0]);
        }
        int[] vectorAlfas = new int[cant_claves + 1];
        String[] vectorClaves = new String[cant_claves + 1];
        arbol.completarNodosExternos(vectorBetas);
        System.out.println(arbol.calcularCosto(frecExito, frecNoExito));
    }
}
