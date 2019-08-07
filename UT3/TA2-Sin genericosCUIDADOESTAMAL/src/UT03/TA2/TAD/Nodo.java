package UT03.TA2.TAD;

import UT03.TA2.TAD.INodo;

/**
 * Implementación TDA Nodo
 * @author Grupo 7
 */
public class Nodo implements INodo {
    
    /** Etiqueta para comparar con otros nodos */
    private Comparable etiqueta;
    
    /** Dato del nodo */
    private Object dato;
    
    /** Siguiente nodo */
    private INodo siguiente;

    /**
     * Constructor que recibe todos los datos el nodo
     * @param etiqueta
     * @param dato
     * @param siguiente 
     */
    public Nodo(Comparable etiqueta, Object dato, INodo siguiente) {
        this.etiqueta = etiqueta;
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * Constructor que sólo recibe la etiqueta del nodo
     * @param etiqueta 
     */
    public Nodo(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.dato = null;
        this.siguiente = null;
    }

    /**
     * Constructor por defecto
     */
    public Nodo() {
        this.etiqueta = null;
        this.dato = null;
        this.siguiente = null;
    }
    
    /**
     * Retorna el dato del nodo
     * @return dato
     */
    @Override
    public Object getDato() {
        return this.dato;
    }

    /**
     * Define el dato del nodo
     * @param dato 
     */
    @Override
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Define nodo siguiente
     * @param nodo
     */
    @Override
    public void setSiguiente(INodo nodo) {
        this.siguiente = nodo;
    }

    /**
     * Retorna nodo siguiente
     * @return nodo siguiente
     */
    @Override
    public INodo getSiguiente() {
        return this.siguiente;
    }

    /**
     * Imprime una representación del nodo
     */
    @Override
    public void imprimir() {
        // Imprime siguiendo este formato: [etiqueta], [dato string], (opcional: etiqueta del nodo siguiente)
        System.out.print(this.getEtiqueta() + ", " + this.getDato().toString() + (this.getSiguiente() != null ? ", " + this.getSiguiente().getEtiqueta() : ""));
    }

    /**
     * Imprime la etiqueta del nodo
     */
    @Override
    public void imprimirEtiqueta() {
        System.out.print(this.getEtiqueta());
    }

    /**
     * Determina si dos nodos son iguales
     * @param unNodo
     * @return booleano
     */
    @Override
    public boolean equals(INodo unNodo) {
        return (this.compareTo(unNodo.getEtiqueta()) == 0);
    }

    /**
     * Retorna la etiqueta comparable del nodo
     * @return etiqueta comparable
     */
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * Compara etiqueta de dos nodos
     * @param etiqueta
     * @return entero producto de la comparación
     */
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.getEtiqueta().compareTo(etiqueta);
    }
    
}