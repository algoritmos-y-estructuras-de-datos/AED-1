
public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public TElementoAB<T> getRaiz() {
        return raiz;
    }

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
    public int obtenerAltura() {
        if (raiz != null) {
            return raiz.obtenerAltura();
        } else {
            return 1;
        }
    }

    @Override
    public int obtenerTamanio() {
        if (this.esVacio()) {
            return 0;
        }
        return raiz.obtenerTamanio();

    }

    @Override
    public int nivelClave(Comparable unaClave) {
        if (esVacio()) {
            return -1;
        }
        return raiz.nivelClave(unaClave);
    }

    @Override
    public int nivelMasProfundo() {
        if (!esVacio()) {
            return raiz.nivelMasProfundo();
        }
        return -1;
    }

    @Override
    public Lista<T> clavesNivel(int unNivel) {
        Lista listaClaves = new Lista();
        if (!esVacio()) {
            raiz.clavesNivel(unNivel, listaClaves);
        }
        return listaClaves;
    }

    @Override
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito) {
        if (esVacio()) {
            return 0;
        }
        return raiz.calcularCosto(FrecExito, FrecNoExito, FrecExito, FrecExito, 1);
    }

    @Override
    public Lista<T> preOrden() {
        Lista<T> listaPreOrden = null;
        if (!esVacio()) {
            listaPreOrden = new Lista<>();
            raiz.preOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    @Override
    public Lista<T> inOrden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }

}
