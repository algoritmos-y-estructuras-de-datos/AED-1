
public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operaci�n
     */

    public boolean insertar(TElementoAB<T> unElemento);

 

    /**
     * Busca un elemento dentro del �rbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /*
     * Imprime en PreOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     
    public String preOrden();

    
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
    
    public String inOrden();

    
     * Imprime en PostOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
    
    public String postOrden();

   */
    /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta
     * @return 
     */
    public void eliminar(Comparable unaEtiqueta);
    
    /**
     *
     * @param FrecExito
     * @param FrecNoExito
     * @return
     */
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito); 


    /**
     *
     *
     * @return una Lista con los elementos del recorrido en preorden.
     *
     */
    public Lista<T> preOrden();

    /**
     *
     *
     * @return una Lista con los elementos del recorrido en inorden.
     *
     */
    public Lista<T> inOrden();
    
    
    /**
     *
     *
     * @return una Lista con los elementos del recorrido en postorden.
     *
     */
    public Lista<T> postOrden();

    public int nivelClave(Comparable unaClave);
   
}

