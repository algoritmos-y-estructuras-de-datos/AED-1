
public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (getRaiz() == null);
    }

    /**
     * @return the raiz
     */
    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        Boolean t = false;
        if (raiz == null) {
            raiz = unElemento;
        } else {
            t = this.raiz.insertar(unElemento);

        }
        return t;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public Lista<T> inorden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            this.raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }

    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

}
