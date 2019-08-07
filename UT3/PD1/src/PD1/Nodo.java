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
public class Nodo {

    Object carga;
    Nodo siguiente;

    public Nodo() {
        carga = null;
        siguiente = null;
    }

    public Nodo(Object carga, Nodo siguiente) {
        this.carga = carga;
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return carga.toString() + "";
    }

}
