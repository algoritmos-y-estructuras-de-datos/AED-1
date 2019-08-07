public class Lista<T> implements ILista<T> {

    /** Nodo primero */
    protected INodo<T> primero;

    /**
     * Constructor que recibe el nodo primero
     * @param primero 
     */
    public Lista(INodo<T> primero) {
        this.primero = primero;
    }
    
    /**
     * Constructor por defecto
     */
    public Lista() {
        this.primero = null;
    }
    
    /**
     * Inserta nodo al final de la lista
     * @param nodo
     */
    @Override
    public void insertar(INodo<T> nodo) {
        INodo<T> actual;
        // Si la lista está vacía, lo defino como primero
        if (this.esVacia()) {
           this.primero = nodo;
        }
        else {
            // Valido que no exista ya el nodo
            if (this.buscar(nodo.getEtiqueta()) == null) {
                // Me ubico en el último nodo y le defino su siguiente
                actual = this.getPrimero();
                while(actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nodo);
                nodo.setSiguiente(null);
            }
        }
    }

    @Override
    public INodo<T> buscar(Comparable clave) {
        INodo<T> actual;
        
        // Si está vacía, retorno nulo
        if (this.esVacia())
            return null;

        actual = this.getPrimero();
        // Verifico si es el primero
        if (actual.compareTo(clave) == 0)
            return actual;

        // Recorro cada elemento y verifico con cada uno
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            // Verifico igualdad
            if (actual.compareTo(clave) == 0)
                return actual;
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        INodo<T> actual;
        INodo<T> anterior;
        
        // Si está vacía, retorno falso
        if (this.esVacia())
            return false;

        actual = this.getPrimero();
        // Verifico si debo eliminar el primero
        if (actual.compareTo(clave) == 0) {
            // Elimino el primer elemento
            this.primero = actual.getSiguiente();
            return true;
        }

        // Recorro cada elemento y verifico con cada uno
        while(actual.getSiguiente() != null) {
            anterior = actual;
            actual = actual.getSiguiente();
            // Verifico igualdad con el siguiente y elimino elemento
            if (actual.compareTo(clave) == 0) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna una cadena de caracteres representando la lista completa, sin separador.
     * @return cadena de caracteres representando la lista
     */
    @Override
    public String imprimir() {
        return imprimir(null);
    }

    /**
     * Retorna una cadena de caracteres representando la lista completa, con separador.
     * @return cadena de caracteres representando la lista
     */
    @Override
    public String imprimir(String separador) {
        INodo<T> actual;
        String lista = "";
        
        // Retorno vacío si está vacía la lista
        if (this.esVacia())
            return lista;
        
        actual = this.getPrimero();
        // Recorro cada elemento y lo agrego a lista para retornar
        while(actual != null) {
            lista += actual.getEtiqueta() + ((separador != null && actual.getSiguiente() != null) ? separador : "");
            actual = actual.getSiguiente();
        }
        return lista;
    }

    /**
     * Retorna la cantidad de nodos
     * @return cantidad de nodos
     */
    @Override
    public int cantElementos() {
        INodo<T> actual;
        int cantidad;
        
        // Si está vacía, retorno 0.
        if (this.esVacia())
            return 0;

        cantidad = 0;
        actual = this.getPrimero();
        // Recorro cada elemento y acumulo cantidad
        while(actual != null) {
            actual = actual.getSiguiente();
            cantidad++;
        }
        return cantidad;
    }

    /**
     * Determina si la lista está vacía
     * @return booleano
     */
    @Override
    public boolean esVacia() {
        return (this.getPrimero() == null);
    }

    /**
     * Retorna el primer nodo
     * @return primero
     */
    @Override
    public INodo<T> getPrimero() {
        return this.primero;
    }
    
}