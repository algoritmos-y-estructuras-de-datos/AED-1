
public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;
    private float frecuencia;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        frecuencia = 0;
    }

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

    public void clavesNivel(int nivel, Lista listaClaves) {
        
        if (nivel == 1) {
            listaClaves.insertar(new Nodo(etiqueta, datos));
        }
        if (hijoIzq != null) {
            hijoIzq.clavesNivel(nivel - 1, listaClaves);
        }
        if (hijoDer != null) {
            hijoDer.clavesNivel(nivel - 1, listaClaves);
        }
    }

    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

    public void setFrecuencia(float frec) {
        this.frecuencia = frec;
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

    public int trayectoriaInterna(int nivel) {
        int tamPorNivel = 0;//orden 1
        if (hijoIzq != null)//orden 1
        {
            tamPorNivel += hijoIzq.trayectoriaInterna(nivel + 1);//orden ??
        }
        if (hijoDer != null)//orden 1
        {
            tamPorNivel += hijoDer.trayectoriaInterna(nivel + 1);//orden ??
        }
        return tamPorNivel + nivel;//orden 1
        //Orden: este es el bloque ue voy a ejecutar. 1+1+??+1+??+1 = orden 4, ejecuto este bloque N veces * 4 = orden de N.
    }

    public int trayectoriaInternaMejor(int nivel, int[] tamanio) {
        int tamPorNivel = 0;//orden 1

        tamanio[0]++;

        if (hijoIzq != null)//orden 1
        {
            tamPorNivel += hijoIzq.trayectoriaInternaMejor(nivel + 1, tamanio);//orden ??
        }
        if (hijoDer != null)//orden 1
        {
            tamPorNivel += hijoDer.trayectoriaInternaMejor(nivel + 1, tamanio);//orden ??
        }
        return tamPorNivel + nivel;//orden 1
        //Orden: este es el bloque ue voy a ejecutar. 1+1+??+1+??+1 = orden 4, ejecuto este bloque N veces * 4 = orden de N.
    }

    public int obtenerTamanio() {
        int T1 = 0;
        int T2 = 0;
        if (hijoIzq != null) {
            T1 += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null) {
            T2 += hijoDer.obtenerTamanio();
        }
        return T1 + T2 + 1;
    }

    public void completarNodosExternos(int[] vector_betas, Integer[] contador) {
        if (hijoIzq != null) {
            hijoIzq.completarNodosExternos(vector_betas, contador);
        } else {
            TElementoAB elemento = new TElementoAB("hoja", null);
            elemento.setFrecuencia(vector_betas[contador[0]]);
            hijoIzq = elemento;
            contador[0]++;
        }
        if (hijoDer != null) {
            hijoDer.completarNodosExternos(vector_betas, contador);
        } else {
            TElementoAB elemento = new TElementoAB("hoja", null);
            elemento.setFrecuencia(vector_betas[contador[0]]);
            hijoDer = elemento;
            contador[0]++;
        }
    }

}
