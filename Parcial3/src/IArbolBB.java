
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
     * Retorna la altura del arbol.
     *
     * @return Altura del arbol.
     */
    public int obtenerAltura();

    /**
     * Retorna el tamaño del arbol.
     *
     * @return Tamaño del arbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna el nivel del arbol a partir de la etiqueta indicada
     *
     * @param unaClave
     * @param unaEtiqueta
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

