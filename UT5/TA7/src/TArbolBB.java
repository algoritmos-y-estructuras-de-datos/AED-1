
public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    public void completarNodosExternos(int[] vectorBetas) {
        if (!esVacio()) {
            Integer[] contador = new Integer[1];
            contador[0] = 0;
            raiz.completarNodosExternos(vectorBetas, contador);
        }
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

    public float trayectInterMedia() {
        int tam = raiz.obtenerTamanio();
        int nivel = 1;
        int trayectoriaInterna = raiz.trayectoriaInterna(nivel);
        return (float) trayectoriaInterna / (float) tam;
    }

    public float trayectInterMediaMejorado() {
        int nivel = 1;
        int[] tam = new int[]{0};
        int trayectoriaInterna = raiz.trayectoriaInternaMejor(nivel, tam);
        return (float) trayectoriaInterna / (float) tam[0];
    }

    public int obtenerTamanio() {
        if (esVacio()) {
            return 0;
        }
        return raiz.obtenerTamanio();
    }

    public int nivelMasProfundo() {
        if (!esVacio()) {
            return raiz.nivelMasProfundo();
        }
        return -1;
    }

    public Lista clavesNivel(int nivel) {
        Lista listaClaves = new Lista();
        if (!esVacio()) {
            raiz.clavesNivel(nivel, listaClaves);
        }
        return listaClaves;
    }
}
