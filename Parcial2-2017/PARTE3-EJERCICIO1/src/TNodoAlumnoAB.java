
import java.util.LinkedList;

public class TNodoAlumnoAB implements INodoAlumnoAB {

    private final Comparable etiqueta;
    private TNodoAlumnoAB hijoIzq;
    private TNodoAlumnoAB hijoDer;
    private final Alumno datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    public TNodoAlumnoAB(Comparable unaEtiqueta, Alumno unosDatos) {

        etiqueta = unaEtiqueta;
        datos = unosDatos;
        hijoIzq = null;
        hijoDer = null;
    }

    public Alumno getDatos() {
        return datos;
    }

    public TNodoAlumnoAB getHijoIzq() {
        return hijoIzq;
    }

    public TNodoAlumnoAB getHijoDer() {
        return hijoDer;

    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TNodoAlumnoAB buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return hijoDer.buscar(unaEtiqueta);
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
            tempStr.append(TArbolBBU.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBBU.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    @Override
    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    public void setHijoIzq(TNodoAlumnoAB elemento) {
        this.hijoIzq = elemento;

    }

    public void setHijoDer(TNodoAlumnoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public boolean insertar(TNodoAlumnoAB unElemento) {

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

    @Override
    public void indizar(TArbolBBU indice, Comparable laCarrera) {
        if (this.getDatos().getCarrera().equals(laCarrera)) {
            TNodoAlumnoAB nodoNuevo = new TNodoAlumnoAB(this.getDatos().getApellido(), this.getDatos());
            indice.insertar(nodoNuevo);
        }
        if (hijoIzq != null) {
            hijoIzq.indizar(indice, laCarrera);
        }

        if (hijoDer != null) {
            hijoDer.indizar(indice, laCarrera);
        }

    }

    @Override
    public String mayorValor(int claveMenor, int claveMayor) {
        String mayorClv = this.recorridoMayor(claveMayor, " ");
        String menorClv = this.recorridoMayor(claveMenor, mayorClv);
        return menorClv;
    }

    public String recorridoMayor(int clave, String mayorApellido) {
        String valorActual = this.getDatos().getApellido();

        if (this.etiqueta.compareTo(clave) == 0) {
            if (valorActual.compareTo(mayorApellido) > 0) {
                return valorActual;
            } else {
                return mayorApellido;
            }
        } else if (clave < (int) this.etiqueta) {
            if (hijoIzq != null) {
                if (valorActual.compareTo(mayorApellido) > 0) {
                    mayorApellido = valorActual;
                }
                return hijoIzq.recorridoMayor(clave, mayorApellido);
            }
        } else {
            if (hijoDer != null) {
                if (valorActual.compareTo(mayorApellido) > 0) {
                    mayorApellido = valorActual;
                }
                return hijoDer.recorridoMayor(clave, mayorApellido);
            }

        }
        return mayorApellido;
    }
}
