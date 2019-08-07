/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaOrdenada<T> extends Lista<T> {

    
    
    public ListaOrdenada() {
        super();
    }
    
    @Override
    public void insertar(Nodo<T> nodo) {
        Nodo<T> actual;
        Nodo<T> siguiente;
        if (this.esVacia()) {
           this.setPrimero(nodo);
        }
        else {
            if (this.buscar(nodo.getEtiqueta()) == null) {
                actual = this.getPrimero();
                siguiente = actual.getSiguiente();
                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
                    nodo.setSiguiente(actual);
                    this.setPrimero(nodo);
                }
                else if (siguiente == null) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                }
                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                }
                else {
                    while(actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                            break;
                        }
                        else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(siguiente);
                            break;
                        }
                    }
                }
            }
        }
    }
}