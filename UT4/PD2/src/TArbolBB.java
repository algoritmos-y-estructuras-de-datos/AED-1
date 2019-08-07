/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class TArbolBB<T> implements IArbolBB {

    TElementoAB<T> raiz;

    public TArbolBB() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB unElemento) {
        Boolean t = false;
        if (raiz == null) {
            raiz = unElemento;
        } else {
            t = this.raiz.insertar(unElemento);

        }
        return t;
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (esVacio()) {
            return "Arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (esVacio()) {
            return "Arbol vacio";
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio()) {
            return "Arbol vacio";
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    public Boolean esVacio() {
        return this.raiz == null;
    }

}
