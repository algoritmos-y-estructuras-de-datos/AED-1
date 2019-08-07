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
public class Nodo {

    Object carga;
    Nodo prox;

    public Nodo() {
        carga = 0;
        prox = null;
    }

    public Nodo(Object carga, Nodo prox) {
        this.carga = carga;
        this.prox = prox;
    }

    public String toString() {
        return carga + "";
    }
}
