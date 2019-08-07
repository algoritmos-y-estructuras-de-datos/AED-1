package UT03.TA2.TAD;

/**
 * Implementación de un TDA Lista ordenado
 * @author Grupo 7
 */
public class ListaOrdenada<T> extends Lista<T> {

    /**
     * Constructor que recibe el nodo primero
     * @param primero 
     */
    public ListaOrdenada(INodo<T> primero) {
        super(primero);
    }
    
    /**
     * Constructor por defecto
     */
    public ListaOrdenada() {
        super();
    }
    
    /**
     * Inserta de forma ordenada un nodo
     * @param nodo
     */
    @Override
    public void insertar(INodo<T> nodo) {
        INodo<T> actual;
        INodo<T> siguiente;

        // Si la lista está vacía, lo defino como primero
        if (this.esVacia()) {
           this.primero = nodo;
        }
        else {
            // Valido que no exista ya el nodo
            if (this.buscar(nodo.getEtiqueta()) == null) {
                actual = this.getPrimero();
                siguiente = actual.getSiguiente();
                
                // Caso primer elemento ya es mayor
                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
                    // Lo agrego primero a la lista
                    nodo.setSiguiente(actual);
                    this.primero = nodo;
                }
                // Caso de un sólo elemento y es menor
                else if (siguiente == null) {
                    // Lo agrego como siguiente y último
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                }
                // Caso sólo dos elementos y estamos entre medio
                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                }
                else {
                    // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                    while(actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        // Llegué al final de la lista, lo inserto al final
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                            break;
                        }
                        // Si actual es menor y el siguiente es mayor, encontré un hueco
                        else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                            // Se inserta nodo en el hueco encontrado y dejo de recorrer la lista
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(siguiente);
                            break;
                        }
                    }
                }
            }
        }
    }
    
}