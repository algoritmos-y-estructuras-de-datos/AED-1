/**
 *
 * @author ernesto
 * @param <T>
 */
public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;

    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

   

    @Override
    public String imprimirEtiqueta() {
        return (this.etiqueta.toString());
    }

    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

    /**
     *
     * @param unNodo
     * @return
     */

    
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    @Override
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    
}
