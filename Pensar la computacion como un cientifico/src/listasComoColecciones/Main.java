/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasComoColecciones;

/**
 *
 * @author lucas
 */
public class Main {

    public static void main(String[] args) {

        //14.1 Listas enlazadas referencias a objetos
        Nodo nodo = new Nodo(1, null);
        System.out.println(nodo);
        Nodo nodo1 = new Nodo(1, null);
        Nodo nodo2 = new Nodo(2, null);
        Nodo nodo3 = new Nodo(3, null);
        nodo1.prox = nodo2;
        nodo2.prox = nodo3;
        nodo3.prox = null;
        //14.3 Listas como colecciones
        Lista.imprimirLista(nodo1);
        //15.11 Implementando TDAs
        Stack stack = new Stack();
        stack.push(12);
        stack.push(12);
        System.out.println(stack.tam());
        System.out.println(stack.arreglo[1]);
        //16.1 El TDA Cola
        Cola cola = new Cola();
        cola.agregar(9);
        cola.agregar(9);
        cola.agregar(9);
        cola.agregar(9);
        cola.imprimirCola();
        //16.4 Buffer circular
        BufferCircular buff = new BufferCircular();
        buff.agregar(8);
        buff.agregar(8);
        buff.agregar(8);
        buff.agregar(8);
        //Imprimiendo el Buffer
        for (int i = 0; i< buff.arreglo.length; i++){
            System.out.println(buff.arreglo[i]);
        }
    }

}
