
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
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public Lista<T> inOrden() {
        Lista<T> listaInorden = new Lista<>();
        if (!esVacio()) {

            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public Lista<T> preOrden() {
        Lista<T> listaPreOrden = new Lista<>();
        if (!esVacio()) {

            raiz.preOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    @Override
    public Lista<T> postOrden() {
        Lista<T> listaPostOrden = new Lista<>();
        if (!esVacio()) {

            raiz.postOrden(listaPostOrden);
        }
        return listaPostOrden;

    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito) {
        if (esVacio()) {
            return 0;
        }
        return raiz.calcularCosto(FrecExito, FrecNoExito, FrecExito, FrecExito, 1);
    }

    @Override
    public int nivelClave(Comparable unaClave) {
        if (esVacio()) {
            return -1;
        }
        return raiz.nivelClave(unaClave);
    }

    public boolean esArbolAvl() {
        if (this.raiz == null) {
            return true;
        }

        //return this.raiz.esArbolAvl();
        Integer esAvl = this.raiz.esArbolAvlSinAltura();

        // Retorno verdadero si fue distinto de nulo
        // y falso si es nulo
        return (esAvl != null);
    }

    public int obtenerAltura() {
        if (raiz != null) {
            return raiz.obtenerAltura();
        } else {
            return 0;
        }
    }
    /**
 * Determina si este árbol BB es AVL
 * @return verdadero si es árbol AVL
 */

}
