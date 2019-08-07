/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolescompletos;

import java.util.LinkedList;

/**
 *
 * @author Meki
 */
class TElementoAB_Base<T> implements IElementoAB {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;

    public TElementoAB(Comparable unaEtiqueta, T dato) {
        etiqueta = unaEtiqueta;
        datos = dato;
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
        this.hijoDer = elemento;
    }

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
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    @Override
    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr = tempStr + "~" + imprimir();
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }

        return tempStr;
    }

    @Override
    public String preOrden() {
        String tempStr = "";
        tempStr = tempStr + "~" + imprimir();
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
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

    public void preOrden(LinkedList<Comparable> unaLista) {
        unaLista.add(this.getEtiqueta());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }

    }

    public void postOrden(LinkedList<Comparable> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());

    }

    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public Object getDatos() {
        return this.datos;
    }

    /**
     * imprime etiqueta del elemento
     *
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    /**
     * *
     * Metodo que inserta un nuevo elemento al arbol y devuelve un contador con
     * el numero de veces que se llamo al metodo recursivamente
     *
     * @param elemento
     * @return contador
     */
    public int insertarContador(TElementoAB elemento) {
        // verifico si la etiqueta del elemento a insertar es menor a la etiqueta del elemento

        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertarContador(elemento) + 1;

            } else {
                hijoIzq = elemento;
                return 1;
            }
            // verifico si la etiqueta del elemento a insertar es mayor a la etiqueta del elemento
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertarContador(elemento) + 1;

            } else {
                hijoDer = elemento;
                return 1;
            }
        } else {
            return 1;
        }
    }
    //insertar con contador usando array

    public int[] insertarContadorArray(TElementoAB elemento, int[] contador) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            contador[0]++;
            if (hijoIzq != null) {
                return getHijoIzq().insertarContadorArray(elemento, contador);

            } else {
                hijoIzq = elemento;
                return contador;
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            contador[0]++;
            if (hijoDer != null) {
                return getHijoDer().insertarContadorArray(elemento, contador);

            } else {
                hijoDer = elemento;
                return contador;
            }
        } else {
            contador[0] = contador[0] * -1;
            return contador;
        }
    }

    public int[] buscarContador(Comparable unaEtiqueta, int[] contador) {
        contador[0]++;
        int comparador = unaEtiqueta.compareTo(this.etiqueta);
        if (comparador == 0) {
            return contador;
        } else {
            if (comparador < 0) {
                if (this.hijoIzq != null) {

                    return this.hijoIzq.buscarContador(unaEtiqueta, contador);
                } else {
                    contador[0] = -contador[0];
                    return contador;
                }
            } else {
                if (this.hijoDer != null) {
                    return this.hijoDer.buscarContador(unaEtiqueta, contador);
                } else {
                    contador[0] = -contador[0];
                    return contador;
                }
            }
        }
    }

    /**
     * devuelve la altura del elemento
     *
     * @return
     */
    public int getAltura() {
        int alturaIzquierda = -1;
        int alturaDerecha = -1;
        if (this.hijoIzq != null) {
            alturaIzquierda = this.hijoIzq.getAltura();
        }
        if (this.hijoDer != null) {
            alturaDerecha = this.hijoDer.getAltura();
        }
        if (alturaIzquierda > alturaDerecha) {
            return alturaIzquierda + 1;
        } else {
            return alturaDerecha + 1;
        }
    }

    /**
     * devuelve true si el elemento es completo (tiene dos hijos)
     *
     * @return
     */
    public boolean esCompleto() {
        if ((hijoIzq != null && hijoDer == null) || (hijoIzq == null && hijoDer != null)) {
            return false;
        }
        if (hijoIzq != null) {
            return hijoIzq.esCompleto();

        }
        if (hijoDer != null) {
            return hijoDer.esCompleto();
        }
        return true;
    }

    /**
     * devuelve la cantidad de elementos externos (hojas)
     *
     * @return
     */
    public int getCantidadHojas() {
        //int contador = 0;
        if (hijoIzq == null && hijoDer == null) {
            return 1;
            //contador =1;
            //return contador;
        } else if (hijoIzq == null && hijoDer != null) {
            return hijoDer.getCantidadHojas();
            //contador =hijoDer.getCantidadHojas();
            //return contador;
        } else if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.getCantidadHojas();
            //contador = hijoIzq.getCantidadHojas();
            //return contador;
        } else {
            return hijoIzq.getCantidadHojas() + hijoDer.getCantidadHojas();
            //contador = hijoIzq.getCantidadHojas() + hijoDer.getCantidadHojas();
            //return contador;

        }
    }

    /**
     * devuelve el nivel de un elemento deseado(si exite)
     *
     * @param etiqueta
     * @return
     */
    public int getNivel(Comparable etiqueta) {
        if (this.buscar(etiqueta) != null) {
            if (this.etiqueta.compareTo(etiqueta) == 0) {
                return 0;
            } else if (etiqueta.compareTo(this.etiqueta) < 0) {
                if (hijoIzq != null) {
                    return 1 + hijoIzq.getNivel(etiqueta);
                } else {
                    return 0;
                }

            } else if (hijoDer != null) {
                return 1 + hijoDer.getNivel(etiqueta);
            } else {
                return 0;
            }

        } else {
            return 0;
        }

    }

    /**
     * devuelve el tamaño del elemento (cantidad de elementos totales)
     *
     * @return
     */
    public int getTamanio() {
        int subIzquierdo = 0;
        int subDerecho = 0;
        if (hijoIzq != null) {
            subIzquierdo += hijoIzq.getTamanio();
        }
        if (hijoDer != null) {
            subDerecho += hijoDer.getTamanio();
        }
        return subIzquierdo + subDerecho + 1;
    }

    /**
     * devuelve true su el elemento es una hoja
     *
     * @return
     */
    public boolean esHoja() {
        return hijoIzq == null && hijoDer == null;
    }

    /**
     * devuelve cantidad de elementos internos del elemento
     *
     * @return
     */
    public int getInternos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
