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
public class Lista {
    //Generic list
    public static void imprimirLista(Nodo lista) {
        Nodo nodo = lista;
        System.out.print("(");
        while (nodo != null) {
            System.out.print(nodo);
            nodo = nodo.prox;
            
            System.out.print(" , ");

        }
        System.out.println(")");
    }

}
