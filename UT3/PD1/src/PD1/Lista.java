/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PD1;

/**
 *
 * @author lucas
 */
public class Lista {
    
    Nodo primero;
    
    public Lista(Nodo cabeza){
        primero = cabeza;
    }
    
    public Nodo getCabeza(){
        return primero;
    }
    
    public void imprimirLista (Nodo primero) {
        Nodo nodo = primero;
        while (nodo != null) {
            System.out.print (nodo);
            nodo = nodo.siguiente;
            if (nodo != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    
}
