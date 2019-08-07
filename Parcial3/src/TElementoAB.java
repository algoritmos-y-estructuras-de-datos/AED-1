
public class TElementoAB<T> implements IElementoAB<T> {

    /**
     * @return the frec
     */
    public int getFrec() {
        return frec;
    }

    /**
     * @param frec the frec to set
     */
    public void setFrec(int frec) {
        this.frec = frec;
    }

    /**
     * @return the frecNEizq
     */
    public int getFrecNEizq() {
        return frecNEizq;
    }

    /**
     * @param frecNEizq the frecNEizq to set
     */
    public void setFrecNEizq(int frecNEizq) {
        this.frecNEizq = frecNEizq;
    }

    /**
     * @return the frecNEder
     */
    public int getFrecNEder() {
        return frecNEder;
    }

    /**
     * @param frecNEder the frecNEder to set
     */
    public void setFrecNEder(int frecNEder) {
        this.frecNEder = frecNEder;
    }

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;
    private int frec;
    private int frecNEizq;
    private int frecNEder;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        this.frec = 0;
        this.frecNEizq = 0;
        this.frecNEder = 0;
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
    public int nivelClave(Comparable unaClave) {
        int nivel = 0;

        if (unaClave.compareTo(etiqueta) == 0) {
            return 1;
        } else if (unaClave.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                nivel = hijoIzq.nivelClave(unaClave);
            } else {
                return -2;
            }
        } else if (hijoDer != null) {
            nivel = hijoDer.nivelClave(unaClave);
        } else {
            return -2;
        }
        if (nivel < 0) {
            return nivel - 1;
        } else {
            return nivel + 1;
        }
    }

    public void listarClavesyFrecuencias(String[] claves, int[] FE, int[] FNE, int[] indice) {
        if (hijoIzq != null) {
            hijoIzq.listarClavesyFrecuencias(claves, FE, FNE, indice);
        } else {
            FNE[indice[0]] = this.getFrecNEizq();
            indice[0]++;
        }
        claves[indice[0]] = this.etiqueta.toString();
        FE[indice[0]] = this.getFrec();

        if (hijoDer != null) {
            hijoDer.listarClavesyFrecuencias(claves, FE, FNE, indice);
        } else {
            FNE[indice[0]] = this.getFrecNEder();
            indice[0]++;
        }
    }

    @Override
    public int obtenerAltura() {
        int alturaIzquierda = 0;
        int alturaDerecha = 0;
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

    @Override
    public int obtenerTamanio() {
        int tempint = 0;
        if (hijoIzq != null) {
            tempint = hijoIzq.obtenerTamanio();
        }
        tempint++;
        if (hijoDer != null) {
            tempint = tempint + hijoDer.obtenerTamanio();
        }
        return tempint;

    }

    public void incFrec() {
        this.setFrec(this.getFrec() + 1);
    }

    public void incFNEIzq() {
        this.setFrecNEizq(this.getFrecNEizq() + 1);

    }

    public void incFNEDer() {
        this.setFrecNEder(this.getFrecNEder() + 1);
    }

    @Override
    public int nivelMasProfundo() {
        int N1 = 1;
        int N2 = 1;
        if (hijoIzq != null) {
            N1 += hijoIzq.nivelMasProfundo();
        }
        if (hijoDer != null) {
            N2 += hijoDer.nivelMasProfundo();
        }
        if (N2 > N1) {
            return N2;
        }
        return N1;
    }

    @Override
    public void clavesNivel(int unNivel, Lista<T> claves) {
        if (unNivel == 1) {
            claves.insertar(new Nodo(etiqueta, datos));
        }
        if (hijoIzq != null) {
            hijoIzq.clavesNivel(unNivel - 1, claves);
        }
        if (hijoDer != null) {
            hijoDer.clavesNivel(unNivel - 1, claves);
        }
    }

    @Override
    public void actualizarFrecuencias(Comparable unaClave) {
        int contadorIzq = 1;
        int contadorDer = 1;
        int contador = 1;
        if (unaClave.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq.actualizarFrecuencias(unaClave);
            } else {
                this.setFrecNEizq(contadorIzq+1);
            }
        }
        if (unaClave.compareTo(this.etiqueta) == 0) {
            this.setFrec(contador+1);
        }
        if (unaClave.compareTo(this.etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer.actualizarFrecuencias(unaClave);
            } else {
                this.setFrec(contadorDer+1);
                
            }
        }
    }

    @Override
    public void preOrden(Lista<T> unaLista) {
        unaLista.insertar(new Nodo<>(this.etiqueta, this.getDatos()));
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.insertar(new Nodo<>(this.etiqueta, this.getDatos()));
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
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

}
