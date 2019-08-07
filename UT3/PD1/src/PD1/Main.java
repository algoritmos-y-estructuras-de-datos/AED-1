package PD1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

         // Ejercicio 1
        /*
         Letra del ejercicio:
         Sean nodo1, nodo2 y nodo3 tres nodos consecutivos de una lista (nodo2 es el siguiente a
         nodo1 y nodo3 es el siguiente a nodo2).
         Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
         que sucede):
         Nuevo nodo otroNodo
         otroNodo.siguiente  nodo1
         nodo2.siguiente  nodo3
         --> RESPUESTA CORRECTA a) Inserta “otroNodo” en la lista, quedando como anterior a nodo1.
         b) Inserta “otroNodo” en la lista, quedando entre nodo1 y nodo2.
         c) Elimina nodo2 de la lista.
         d) No tiene ningún efecto sobre la lista.
         */
        // Creo una lista: nodo1 -> nodo2 -> nodo3
        Nodo nodo3 = new Nodo(new String("nodo3"), null);
        Nodo nodo2 = new Nodo(new String("nodo2"), nodo3);
        Nodo nodo1 = new Nodo(new String("nodo1"), nodo2);
        Lista lista = new Lista(nodo1);

        Nodo otroNodo = new Nodo(new String("otroNodo"), null);
        otroNodo.siguiente = nodo1;
        nodo2.siguiente = nodo3;
        System.out.println("Slida ejercicio 1:");
        lista.imprimirLista(lista.getCabeza());

        // Ejercicio 2
        /*
         Sean nodo1, nodo2 y nodo3 tres nodos consecutivos de una lista (nodo2 es el siguiente a
         nodo1 y nodo3 es el siguiente a nodo2).
         Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
         que sucede):
         Nuevo nodo otroNodo
         otroNodo  nodo1.siguiente
         nodo1.siguiente  nodo3
         a) Inserta “otroNodo” en la lista, quedando como anterior a nodo1.
         b) Inserta “otroNodo” en la lista, quedando entre nodo1 y nodo2.
         --> RESPUESTA CORRECTA c) Elimina nodo2 de la lista.
         d) No tiene ningún efecto sobre la lista.
         */
        // Creo una lista: nodo4 -> nodo5 -> nodo6
        Nodo nodo6 = new Nodo(new String("nodo6"), null);
        Nodo nodo5 = new Nodo(new String("nodo5"), nodo6);
        Nodo nodo4 = new Nodo(new String("nodo4"), nodo5);
        Lista lista2 = new Lista(nodo4);

        Nodo otroNodo2 = nodo4.siguiente;
        nodo4.siguiente = nodo6;
        System.out.println("Slida ejercicio 2:");
        lista2.imprimirLista(nodo4);

        // Ejercicio 3
        /*
         Sean nodo1, nodo2 y nodo3 tres nodos consecutivos de una lista (nodo2 es el siguiente a
         nodo1 y nodo3 es el siguiente a nodo2).
         Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
         que sucede) y responda las preguntas proyectadas en pantalla:
         Nuevo nodo otroNodo
         otroNodo.siguiente  nodo1.siguiente
         nodo1.siguiente  otroNodo
         a) Inserta “otroNodo” en la lista, quedando como anterior a nodo1.
         --> RESPUESTA CORRECTA b) Inserta “otroNodo” en la lista, quedando entre nodo1 y nodo2.
         c) Elimina nodo2 de la lista.
         d) Dará error en tiempo de ejecución si nodo1 es el primero o nodo3 es el último.
         */
        // Creo una lista: nodo7 -> nodo8 -> nodo9
        Nodo nodo9 = new Nodo(new String("nodo9"), null);
        Nodo nodo8 = new Nodo(new String("nodo8"), nodo9);
        Nodo nodo7 = new Nodo(new String("nodo7"), nodo8);
        Lista lista3 = new Lista(nodo7);

        Nodo otroNodo3 = new Nodo(new String("otroNodo3"), null);
        otroNodo3.siguiente = nodo7.siguiente;
        nodo7.siguiente = otroNodo3;
        System.out.println("Slida ejercicio 3:");
        lista3.imprimirLista(nodo7);

        //Ejercicio 4
        /*
         Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
         que sucede) y responda las preguntas proyectadas en pantalla:
         Nuevo nodo otroNodo
         Nuevo nodo nodoActual
         nodoActual  primero
         mientras nodoActual <> nulo hacer
         nodoActual  nodoActual.siguiente
         fin mientras
         nodoActual.siguiente  otroNodo
         a) Inserta correctamente “otroNodo” en la lista, quedando como último nodo.
         b) Inserta correctamente “otroNodo” en la lista, quedando como primer nodo.
         c) El algoritmo está mal hecho, ya que dará error en tiempo de ejecución si la lista está
         vacía.
         --> RESPUESTA CORRECTA d) El algoritmo está mal hecho, ya que dará siempre error en tiempo de ejecución.
         */
        // Creo una lista: nodo10 -> nodo11 -> nodo12
        Nodo nodo12 = new Nodo(new String("nodo12"), null);
        Nodo nodo11 = new Nodo(new String("nodo11"), nodo12);
        Nodo nodo10 = new Nodo(new String("nodo10"), nodo11);
        Lista lista4 = new Lista(nodo10);

        Nodo otroNodo4 = new Nodo(new String("otroNodo4"), null);
        Nodo nodoActual = nodo10;
        /*while (nodoActual != null) {
         nodoActual = nodoActual.siguiente;
         }*/
        nodoActual.siguiente = otroNodo; // Null pointer acá
        //Al salir del "mientras" nodoActual <- nulo, y al intentar hacer nodoActual.siguiente <- otroNodo siempre dará error

    //Ejercicio 5
    /*
         Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
         que sucede) y responda las preguntas proyectadas en pantalla:
         Nuevo nodo otroNodo
         Nuevo nodo nodoActual
         nodoActual  primero
         mientras nodoActual.siguiente <> nulo hacer
         nodoActual  nodoActual.siguiente
         fin mientras
         nodoActual.siguiente  otroNodo
         --> RESPUESTA CORRECTA a) Inserta correctamente “otroNodo” en la lista, quedando como último nodo.
         b) Inserta correctamente “otroNodo” en la lista, quedando como primer nodo.
         c) El algoritmo está mal hecho, ya que dará error en tiempo de ejecución si la lista está
         vacía.
         d) El algoritmo está mal hecho, ya que dará siempre error en tiempo de ejecución.
         */
        // Creo una lista: nodo13 -> nodo14 -> nodo15
        Nodo nodo15 = new Nodo(new String("nodo15"), null);
        Nodo nodo14 = new Nodo(new String("nodo14"), nodo15);
        Nodo nodo13 = new Nodo(new String("nodo13"), nodo14);
        Lista lista5 = new Lista(nodo13);

        Nodo otroNodo5 = new Nodo(new String("otroNodo5"), null);
        Nodo nodoActual5 = nodo13;
        while (nodoActual5.siguiente != null) {
            nodoActual5 = nodoActual5.siguiente;
        }
        nodoActual5.siguiente = otroNodo5;
        System.out.println("Salida ejercicio 5:");
        lista5.imprimirLista(nodo13);

        /*
         Ejercicio #6
         a) ¿Cuál es el costo de memoria en cada caso?
         La implementación de los elementos de la lista es igual para ambos. La diferencia está en cómo almacenar cada elemento 
         (arreglos o lista enlazada). En el caso de arreglos, se reserva inicialmente una cantidad de espacio en el "heap" para cada 
         elemento del arreglo, y si fuese necesario más espacio se debe redimensionar el arreglo. En el caso de la lista enlazada, la JVM 
         va solicitando memoria a medida que vamos creando y enlazando los objetos, por lo tanto técnicamente nuestra situación inicial es 
         simplemente pedir 4 bytes para la referencia al primer elemento de la lista (más 8 bytes de la clase lista).

         b) ¿Cuáles son las consideraciones que tu Equipo haría referentes...
         Ambas estructuras soportan la misma cantidad de alumnos, sólo que los arreglos deben ser redimensionados. 
         Para una cantidad no estática de alumnos la cual crece progresivamente, creemos que es siempre mejor una lista enlazada.
        
        @Respuestas By: @bcattaneo but I can tottally agree.
         */
    }
}
