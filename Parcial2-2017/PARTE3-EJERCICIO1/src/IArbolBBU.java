import java.util.LinkedList;

public interface IArbolBBU {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operaci�n
     */

    public boolean insertar(TNodoAlumnoAB unElemento);

 

    /**
     * Busca un elemento dentro del �rbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TNodoAlumnoAB buscar(Comparable unaEtiqueta);

   
   
    
    /**
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();
    
    /**
     *
     * 
     * @return una LinkedList con las etiquetas del recorrido.
     * 
     */
    public LinkedList<Comparable> inorden( );

  
	 /**
     *
     * @param laCarrera
     * @return
     */
    public TArbolBBU armarIndiceCarrera(Comparable laCarrera);
	
}

