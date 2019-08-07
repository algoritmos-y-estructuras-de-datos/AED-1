/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolescompletos;

import java.util.LinkedList;

/**
 *
 * @author Meki
 */
public class TArbolBB_Base<T> implements IArbolBB {

    private TElementoAB<T> raiz;
    /**
     * 
     */
    public TArbolBB() {
        raiz = null;
    }
    @Override
    public boolean insertar(TElementoAB unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }
    /**
     * 
     * @param unaEtiqueta
     * @return 
     */
    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     *
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);

        }
        return listaInorden;
    }

    public LinkedList<Comparable> preorden() {
        LinkedList<Comparable> listaPreorden = null;
        if (!esVacio()) {
            listaPreorden = new LinkedList<>();
            raiz.preOrden(listaPreorden);

        }
        return listaPreorden;
    }

    public LinkedList<Comparable> postorden() {
        LinkedList<Comparable> ListaPostorden = null;
        if (!esVacio()) {
            ListaPostorden = new LinkedList<>();
            raiz.postOrden(ListaPostorden);

        }
        return ListaPostorden;
    }
    
     public int insertarContador(TElementoAB unElemento) {
        if (raiz==null) {
            raiz = unElemento;
            return 0;
        } else {
            return raiz.insertarContador(unElemento);
        }
    }

    public int[] insertarContadorArray(TElementoAB unElemento) {
        int[] contador = new int[1];
        if (raiz == null) {
            raiz = unElemento;
            contador[0] = 0;
            return contador;
        } else {

            return raiz.insertarContadorArray(unElemento, contador);
        }
    }

    public int buscarContador(Comparable unaEtiqueta) {
        int[] contador = new int[]{0};
        return this.raiz.buscarContador(unaEtiqueta, contador)[0];
    }
    
    
    public int getAltura(){
        if (raiz != null){
            return raiz.getAltura();
        }
        else{
            return 0;
        }
    }
    
    public boolean esCompleto(){
        if (!esVacio()){
            return raiz.esCompleto();
        }else{
            return false;
        }
    }

    public int getCantidadHojas() {
        if (!esVacio()) {
            return raiz.getCantidadHojas();
        } else {
            return 0;
        }
    }
    
    public int getNivel(Comparable etiqueta){
        if(!esVacio()){
            return raiz.getNivel(etiqueta);
        }else{
            return 0;
        }
    }

    public int getTamaño() {
        if (!esVacio()) {
            return raiz.getTamaño();
        } else {
            return 0;
        }
    }
}

