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

    public TElementoAB(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.dato = null;
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
        //tempStr = tempStr + imprimir();
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

    public boolean esHoja() {
        return hijoIzq == null && hijoDer == null;
    }

    public Boolean etiquetaCaminoBusqueda(Comparable unaEtiqueta) {
        System.out.println(etiqueta);
        if (unaEtiqueta.equals(etiqueta)) {
            return true;
        } else {
            if (etiqueta.compareTo(unaEtiqueta) < 0) {
                if (hijoIzq != null) {
                    return hijoIzq.etiquetaCaminoBusqueda(unaEtiqueta);
                } else {
                    return false;
                }
            } else {
                if (hijoDer != null) {
                    return hijoDer.etiquetaCaminoBusqueda(unaEtiqueta);
                } else {
                    return false;
                }
            }
        }

    }
}
