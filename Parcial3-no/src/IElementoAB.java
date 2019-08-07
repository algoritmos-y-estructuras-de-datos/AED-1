
public interface IElementoAB<T> {

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB buscar(Comparable unaEtiqueta);

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(TElementoAB elemento);

    public void preOrden(Lista<T> unaLista);

    public void inOrden(Lista<T> unaLista);

    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel);

    /**
     * Retorna la altura del arbol cuya raiz es la del nodo actual.
     *
     * @return Altura del subarbol.
     */
    public int obtenerAltura();

    /**
     * Retorna el tamaño del arbol cuya raiz es la del nodo actual.
     *
     * @return tamaño del subarbol.
     */
    public int obtenerTamanio();

    public void actualizarFrecuencias(Comparable unaClave);

    /**
     * Retorna el nivel del elemento cuya etiqueta es la pasada por par�metro.
     *
     * @param unaClave
     * @return Nivel
     */
    public int nivelClave(Comparable unaClave);

    public int nivelMasProfundo();

    /**
     *
     * @param unNivel
     * @return
     */
    public Lista<T> clavesNivel(int unNivel);

}
