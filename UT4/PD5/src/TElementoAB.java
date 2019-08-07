
import java.util.LinkedList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 * @param <T>
 */
public class TElementoAB<T> implements IElementoAB {

    public Comparable etiqueta;
    TElementoAB<T> hijoIzq, hijoDer;
    T dato;

    public TElementoAB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.dato = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override

    public void setHijoDer(TElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    public String imprimir() {
        return this.getEtiqueta().toString();
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
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
    public boolean insertar(TElementoAB elemento) {
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
    public String preOrden() {
        String tempStr = "";
        if (this != null) {
            tempStr = this.imprimir() + "/";
        }
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
        }
        return tempStr;
    }

    @Override
    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr = tempStr + imprimir() + "/";
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }
        return tempStr;
    }

    @Override
    public String postOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.postOrden();
        }
        tempStr = tempStr + "~" + imprimir();
        return tempStr;
    }

    @Override
    public Object getDatos() {
        return this.dato;
    }

    public TElementoAB<T> getMenorClave() {
        if (hijoIzq == null) {
            return this;
        }
        if (hijoIzq.etiqueta.compareTo(etiqueta) < 0) {
            return hijoIzq.getMenorClave();
        }
        return this;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
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
        TElementoAB<T> elHijo = hijoIzq;
        TElementoAB<T> elPadre = this;
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
    }

    public TElementoAB obtenerMenorClave() {
        TElementoAB menor = this;
        if (hijoIzq == null) {
            return menor;
        }
        if (hijoIzq != null) {
            menor = hijoIzq.obtenerMenorClave();
        }

        return menor;
    }

    public Boolean arbolBinario() {
        Boolean retorno = true;
        if (this.hijoDer != null) {
            if (this.getEtiqueta().compareTo(this.hijoDer.getEtiqueta()) > 0) {
                retorno = false;
            }
        }
        if (this.hijoIzq != null) {
            if (this.getEtiqueta().compareTo(this.hijoIzq.getEtiqueta()) < 0) {
                retorno = false;

            }
        }

        if (hijoDer != null) {
            retorno = hijoDer.arbolBinario();
        }
        if (hijoIzq != null) {
            retorno = hijoIzq.arbolBinario();
        }

        return retorno;

    }

    public TElementoAB obtenerMayorClave() {
        TElementoAB mayor = this;

        if (hijoDer == null) {
            return mayor;
        }
        if (hijoDer != null) {
            mayor = hijoDer.obtenerMayorClave();
        }

        return mayor;
    }

    /**
     * Retorna padre del elemento con la clave buscada
     *
     * @param clave
     * @return elemento padre
     */
    public TElementoAB<T> obtenerPadre(Comparable clave) {

        // Busco por izquierda o derecha
        if (clave.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                if (this.hijoIzq.etiqueta.equals(clave)) {
                    return this;
                } else {
                    return this.hijoIzq.obtenerPadre(clave);
                }
            }
        } else {
            if (this.hijoDer != null) {
                if (this.hijoDer.etiqueta.equals(clave)) {
                    return this;
                } else {
                    return this.hijoDer.obtenerPadre(clave);
                }
            }
        }

        // No encontré
        return null;
    }

    public int obtenerAltura() {
        Integer alturaIzq = -1;
        Integer alturaDer = -1;
        if (hijoIzq != null) {
            alturaIzq = this.hijoIzq.obtenerAltura();
        }
        if (hijoDer != null) {
            alturaDer = this.hijoDer.obtenerAltura();
        }
        if (alturaIzq > alturaDer) {
            return alturaIzq + 1;
        } else {
            return alturaDer + 1;
        }
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

    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivel = -1;
        if (etiqueta.compareTo(unaEtiqueta) == 0) {
            return 0;
        }
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
            }
        }
        if (hijoDer != null) {

            return 1 + hijoDer.obtenerNivel(unaEtiqueta);
        }
        return nivel;
    }

    public int obtenerCantidadHojas() {

        if (hijoIzq == null && hijoDer == null) {
            return 1;

        } else if (hijoIzq == null && hijoDer != null) {
            return hijoDer.obtenerCantidadHojas();

        } else if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerCantidadHojas();

        } else {
            return hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();

        }
    }

    public void listarHojas(LinkedList<Comparable> retorno) {
        if (hijoIzq == null && hijoDer == null) {
            retorno.add(this.etiqueta);
            retorno.add(obtenerNivel(this.getEtiqueta()));

        }
        if (hijoIzq == null && hijoDer != null) {
            hijoDer.listarHojas(retorno);

        }
        if (hijoIzq != null && hijoDer == null) {
            hijoIzq.listarHojas(retorno);

        }
        if (hijoIzq != null && hijoDer != null) {
            hijoIzq.listarHojas(retorno);
            hijoDer.listarHojas(retorno);

        }

    }

    public int cantidadNodosEnNivel(int nivel, TElementoAB<T> raiz) {
        int nodos;

        nodos = 0;
        // Si el nodo actual está en el nivel recibido por parámetro
        if (raiz.obtenerNivel(this.getEtiqueta()) == nivel) {
            nodos = 1;
        }

        // Hijo izquierdo
        if (this.getHijoIzq() != null) {
            nodos += this.getHijoIzq().cantidadNodosEnNivel(nivel, raiz);
        }

        // Hijo derecho
        if (this.getHijoDer() != null) {
            nodos += this.getHijoDer().cantidadNodosEnNivel(nivel, raiz);
        }

        // Retorno total
        return nodos;
    }

    public int internosNoCompletos() {
        int noCompletos = 0;

        // Si es hoja, retorno 0
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 0;
        }

        // Si tiene izquierdo...
        if (this.hijoIzq != null) {
            if (this.hijoDer == null) // ... pero a la vez es interno no completo
            {
                noCompletos += 1 + this.hijoIzq.internosNoCompletos();
            } else // ... pero tiene ambos hijos
            {
                noCompletos += 0 + this.hijoIzq.internosNoCompletos();
            }
        }

        // Si tiene izquierdo...
        if (this.hijoDer != null) {
            if (this.hijoIzq == null) // ... pero a la vez es interno no completo
            {
                noCompletos += 1 + this.hijoDer.internosNoCompletos();
            } else // ... pero tiene ambos hijos
            {
                noCompletos += 0 + this.hijoDer.internosNoCompletos();
            }
        }

        // Retorno total.
        return noCompletos;
    }

    /**
     * Retorna cantidades de nodos internos completos
     *
     * @return cantidad de nodos internos completos
     */
    public int internosCompletos() {
        int completos = 0;

        // Si es hoja, retorno 0
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 0;
        }

        // Si tiene izquierdo...
        if (this.hijoIzq != null) {
            completos += this.hijoIzq.internosCompletos();
        }

        // Si tiene derecho...
        if (this.hijoDer != null) {
            completos += this.hijoDer.internosCompletos();
        }

        // Evalúo actual en postorden para volver
        if (this.hijoIzq != null && this.hijoDer != null) {
            completos += 1;
        }

        // Retorno total
        return completos;
    }

    public TElementoAB<T> obtenerMayorElemento() {
        // Si es el último a la derecha, es el mayor
        if (this.getHijoDer() == null) {
            return this;
        }

        // Sigo buscando en los elementos a la derecha
        return this.getHijoDer().obtenerMayorElemento();
    }

    public TElementoAB<T> obtenerMenorElemento() {
        // Si es el último a la izquierda, es el menor
        if (this.getHijoIzq() == null) {
            return this;
        }

        // Sigo buscando en los elementos a la izquierda
        return this.getHijoIzq().obtenerMenorElemento();
    }

    /**
     * Retorna clave inmediata posterior
     *
     * @param etiqueta clave del elemento
     * @param sucesor auxiliar para guardar sucesor
     * @return clave del elemento
     */
    public Comparable obtenerClaveInmediataPosterior(Comparable etiqueta, Comparable sucesor) {

        // Si el actual es el buscado
        if (this.etiqueta.equals(etiqueta)) {
            if (this.hijoDer != null) {
                return this.hijoDer.obtenerMenorElemento().getEtiqueta();
            }
        } // Si la clave buscada es menor, busco en árbol izquierdo y actualizo sucesor
        else if (etiqueta.compareTo(this.etiqueta) < 0) {
            sucesor = this.etiqueta;
            if (this.hijoIzq != null) {
                return this.hijoIzq.obtenerClaveInmediataPosterior(etiqueta, sucesor);
            }
        } // Si la clave buscada es mayor, busco en árbol derecho
        else {
            if (this.hijoDer != null) {
                return this.hijoDer.obtenerClaveInmediataPosterior(etiqueta, sucesor);
            }
        }
        // Retorno sucesor
        return sucesor;
    }

    /**
     * Retorna clave inmediata anterior
     *
     * @param etiqueta clave del elemento
     * @param predecesor auxiliar para guardar predecesor
     * @return clave del elemento
     */
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta, Comparable predecesor) {

        // Si el actual es el buscado
        if (this.etiqueta.equals(etiqueta)) {
            if (this.hijoIzq != null) {
                return this.hijoIzq.obtenerMayorElemento().getEtiqueta();
            }
        } // Si la clave buscada es menor, busco en árbol izquierdo
        else if (etiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                return this.hijoIzq.obtenerClaveInmediataAnterior(etiqueta, predecesor);
            }
        } // Si la clave buscada es mayor, busco en árbol derecho y actualizo predecesor
        else {
            predecesor = this.etiqueta;
            if (this.hijoDer != null) {
                return this.hijoDer.obtenerClaveInmediataAnterior(etiqueta, predecesor);
            }
        }
        // Retorno predecesor
        return predecesor;
    }
}
