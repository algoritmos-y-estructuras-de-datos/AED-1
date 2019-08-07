package UT03.TA2.TAD;

public interface INodo<T> {

    /**
     * Retorna el dato contenido en el nodo.
     *
     * @return Dato contenido en el nodo.
     */
    public T getDato();

    /**
     * Asigna un dato al nodo.
     *
     * @param dato a asignar.
     */
    public void setDato(T dato);

    /**
     * Asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
    public void setSiguiente(INodo<T> nodo);

    /**
     * Retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    public INodo<T> getSiguiente();

    /**
     * Imprime los datos del nodo
     */
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     *
     * @param unNodo
     * @return si son iguales, por la clave
     */
    public boolean equals(INodo<T> unNodo);

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();
//	/**
//	 *
//	 * @param unNodo
//	 * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si es mayor
//	 */
//	public int compareTo(INodo unNodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
