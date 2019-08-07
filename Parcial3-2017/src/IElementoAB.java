public interface IElementoAB<T> {

    
    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(IElementoAB elemento);

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el PostOrden
     */
    public String postOrden();

   
    
    public int calcularCosto (int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel);

    
    public Comparable getEtiqueta() ;
    public IElementoAB buscar(Comparable unaEtiqueta);
}
