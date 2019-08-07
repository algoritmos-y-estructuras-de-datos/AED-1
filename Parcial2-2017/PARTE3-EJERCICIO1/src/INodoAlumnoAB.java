
import java.util.LinkedList;

public interface INodoAlumnoAB {

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TNodoAlumnoAB buscar(Comparable unaEtiqueta);

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(TNodoAlumnoAB elemento);

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * pone las etiquetas del recorrido en inorden en una linkedlist.
     *
     * @param unaLista
     */
    public void inOrden(LinkedList<Comparable> unaLista);

    public void indizar(TArbolBBU indice, Comparable laCarrera);
    
    public String mayorValor(int claveMenor,int claveMayor);

}
