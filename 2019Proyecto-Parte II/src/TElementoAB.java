
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        hijoIzq = null;
        hijoDer = null;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDato() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        TElementoAB buscar = null;
        if (unaEtiqueta.equals(this.etiqueta)) {
            buscar = this;
        } else {
            if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
                if (hijoIzq != null) {
                    buscar = hijoIzq.buscar(unaEtiqueta);
                }
            } else {
                if (hijoDer != null) {
                    buscar = hijoDer.buscar(unaEtiqueta);
                }
            }
        }
        return buscar;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(elemento);
            } else {
                hijoIzq = elemento;
                return true;
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(elemento);
            } else {
                hijoDer = elemento;
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        if (this.getHijoIzq() != null) {
            this.getHijoIzq().inOrden(unaLista);
        }
        unaLista.insertar(new Nodo<>(this.getEtiqueta(), this.getDato()));
        if (this.getHijoDer() != null) {
            this.getHijoDer().inOrden(unaLista);
        }
    }

    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr = tempStr + imprimir()+" ";
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }
        return tempStr;
    }

}
