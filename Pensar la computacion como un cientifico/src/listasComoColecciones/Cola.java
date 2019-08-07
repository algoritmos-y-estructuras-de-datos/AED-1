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
public class Cola {

    public Nodo primero, ultimo;

    public Cola() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void agregar(Object obj) {
        Nodo nodo = new Nodo(obj, null);
        if (ultimo != null) {
            ultimo.prox = nodo;
        }
        ultimo = nodo;
        if (primero == null) {
            primero = ultimo;
        }
    }

    public Object quitar() {
        Nodo resultado = primero;
        if (primero != null) {
            primero = primero.prox;
        }
        if (primero == null) {
            ultimo = null;
        }
        return resultado;
    }
    
    public void imprimirCola(){
        Nodo aux = new Nodo();
        aux = primero;
        while (aux != ultimo.prox ){
            System.out.println(primero.carga);
            aux = aux.prox;
        }
    }
}
