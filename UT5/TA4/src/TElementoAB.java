
public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }
    public TElementoAB(Comparable unaEtiqueta) {
        etiqueta = unaEtiqueta;
        datos = null;
    }
    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    /**
     * @return recorrida en preOrden del subArbol que cuelga del elemento actual
     */
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @return recorrida en postOrden del subArbol que cuelga del elemento
     * actual
     */
    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    public T getDatos() {
        return datos;
    }

    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }

        if (hijoDer == null) {
            return hijoIzq;
        }

        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        return elHijo;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    @Override
    public void preOrden(Lista<T> unaLista) {
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }

    }

    @Override
    public void postOrden(Lista<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
    }

    @Override
    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
        int costo;

        if (hijoIzq != null) {
            costo = hijoIzq.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else {
            costo = FrecNoExito[indiceFNE[0]++] * (nivel + 1);
        }

        costo += FrecExito[indiceFE[0]] * nivel;

        if (hijoDer != null) {
            costo += hijoDer.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else {
            costo += FrecNoExito[indiceFNE[0]++] * (nivel + 1);
        }

        return costo;
    }

    @Override
    public int nivelClave(Comparable unaClave) {
        int nivel = -1;

        if (this.etiqueta.compareTo(unaClave) == 0) {
            return 1;
        } else if (unaClave.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                return 1 + hijoIzq.nivelClave(unaClave);
            }
            return nivel - 1;

        } else if (hijoDer != null) {
            return 1 + hijoDer.nivelClave(unaClave);
        }
        return nivel - 1;

    }

    public void preOrden2(Lista<T> unaLista) {

        // Inserto este elemento
        unaLista.insertar(new Nodo<>(this.etiqueta, this.datos));

        // Hijo izquierdo
        if (this.hijoIzq != null) {
            this.hijoIzq.preOrden(unaLista);
        }

        // Hijo derecho
        if (this.hijoDer != null) {
            this.hijoDer.preOrden(unaLista);
        }
    }

    public Integer esArbolAvlSinAltura() {
        Integer alturaIzq, alturaDer; // Integer para poder retornar null

        alturaIzq = alturaDer = -1;
        if (this.getHijoIzq() != null) {
            alturaIzq = this.getHijoIzq().esArbolAvlSinAltura();
        }

        if (this.getHijoDer() != null) {
            alturaDer = this.getHijoDer().esArbolAvlSinAltura();
        }

        // Si en retorno ya vengo con "error" (no es AVL)
        // sigo retornando el error.
        if (alturaIzq == null || alturaDer == null) {
            return null;
        } else {
            // Determino si la diferencia está OK
            if (Math.abs(alturaDer - alturaIzq) > 1) // Retorno nulo para agarrar en la vuelta
            {
                return null;
            } else // Sigo retornando la altura
            {
                return Math.max(alturaIzq + 1, alturaDer + 1);
            }
        }
    }

    public boolean esArbolAvl() {
        boolean esAvlIzq, esAvlDer;
        int alturaIzq, alturaDer;

        // TODO: Mejorar. Se puede hallar altura
        // recursivamente en la vuelta, así queda
        // un algoritmo O(N) y no O(N^2).
        // Por defecto ambos son AVL
        esAvlIzq = esAvlDer = true;

        // Obtengo alturas de ambos subárboles
        alturaIzq = alturaDer = 0;
        if (this.hijoIzq != null) {
            alturaIzq = 1 + this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            alturaDer = 1 + this.hijoDer.obtenerAltura();
        }

        // Determino en preorden qué ocurre
        if (Math.abs(alturaDer - alturaIzq) > 1) {
            // Encontré nodo con subárboles que difieren más de 1 en altura
            // así que corto la recursión por este lado
            return false;
        } else {
            // Sigo la recursión si corresponde
            if (this.hijoIzq != null) {
                esAvlIzq = this.hijoIzq.esArbolAvl();
            }
            if (this.hijoDer != null) {
                esAvlDer = this.hijoDer.esArbolAvl();
            }
        }

        // Retorno resultado.
        // Si estoy acá es porque es una hoja
        // o porque terminó el algoritmo
        return (esAvlIzq && esAvlDer);
    }

    public int obtenerAltura() {
        int alturaIzquierda = -1;
        int alturaDerecha = -1;
        if (this.hijoIzq != null) {
            alturaIzquierda = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            alturaDerecha = this.hijoDer.obtenerAltura();
        }
        if (alturaIzquierda > alturaDerecha) {
            return alturaIzquierda + 1;
        } else {
            return alturaDerecha + 1;
        }
    }
}
