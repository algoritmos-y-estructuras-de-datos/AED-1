
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    /**
     *
     * @param Nodo que se quiere insertar al principio
     */
    public void insertarPrincipio(Nodo<T> Nodo) {
        if (esVacia()) {
            primero = Nodo;

        } else {
            Nodo<T> aux = primero;
            primero = Nodo;
            primero.setSiguiente(aux);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux.clonar();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    /**
     *
     * @param clave
     * @return
     */
    public Nodo<T> buscarNormal(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp1 = aux;
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                aux += temp.getEtiqueta() + " ";
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    /**
     * Metodo para insertar ordenadamente en una lista
     * @param nodo que se quiere insertar
     */
    public void insertarOrdenado(Nodo<T> nodo) {
        Nodo<T> actual;
        Nodo<T> siguiente;
        if (this.esVacia()) {
            this.primero = nodo;
        } else {
            if (this.buscar(nodo.getEtiqueta()) == null) {
                actual = this.getPrimero();
                siguiente = actual.getSiguiente();
                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
                    nodo.setSiguiente(actual);
                    this.primero = nodo;
                } else if (siguiente == null) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                } else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                } else {
                    while (actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                            break;
                        } else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(siguiente);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param <T>
     * @return en base a un lista, devuelve la etiqueta del elemento mas comun
     */
    public <T> Comparable masComun() {
        Map<Comparable, Integer> map = new HashMap<>();
        Nodo aux = this.getPrimero();
        while (aux != null) {
            Integer val = map.get(aux.getEtiqueta());
            map.put(aux.getEtiqueta(), val == null ? 1 : val + 1);
            aux = aux.getSiguiente();
        }

        Entry<Comparable, Integer> max = null;

        for (Entry<Comparable, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue()) {
                max = e;
            }
        }
        if (max != null){
            return max.getKey();
        } else{
            return 0;
        }
    }
    
}
