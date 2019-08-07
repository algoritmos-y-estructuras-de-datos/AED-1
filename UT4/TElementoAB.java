
public class TElementoAB<T> implements IElementoAB<T> {
    
    /** Etiqueta del elemento */
    private final Comparable etiqueta;
    
    /** Elemento hijo izquierdo */
    private TElementoAB<T> hijoIzq;
    
    /** Elemento hijo derecho */
    private TElementoAB<T> hijoDer;
    
    /** Datos del elemento */
    private T datos;
    
    /**
     * Constructor que recibe la etiqueta del elemento
     * @param etiqueta etiqueta del elemento
     */
    public TElementoAB(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.datos = null;
    }
    
    /**
     * Constructor que recibe etiqueta y datos del elemento
     * @param etiqueta etiqueta del elemento
     * @param datos datos del elemento
     */
    public TElementoAB(Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.datos = datos;
    }

    /**
     * Retorna elemento hijo izquierdo
     * @return elemento izquierdo
     */
    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    /**
     * Retorna elemento hijo derecho
     * @return elemento derecho
     */
    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;    
    }
    
    /**
     * Retorna etiqueta del elemento
     * @return etiqueta del elemento
     */
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }
    
    /**
     * Retorna datos del elemento
     * @return datos del elemento
     */
    @Override
    public T getDatos() {
        return this.datos;
    }

    /**
     * Define hijo izquierdo del elemento
     * @param elemento elemento a definir como hijo izquierdo
     */
    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    /**
     * Define hijo derecho del elemento
     * @param elemento elemento a definir como hijo derecho
     */
    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
}

    /**
     * Busca el elemento que coincida con la etiqueta
     * @param etiqueta etiqueta a buscar
     * @param contador contador de invocaciones
     * @return elemento
     */
    public TElementoAB<T> buscar(Comparable etiqueta, int contador[]) {
        TElementoAB<T> resultado;
        
        // Incremento contador
        contador[0]++;
        
        resultado = null;
        if (this.getEtiqueta().compareTo(etiqueta) == 0){
            resultado = this;
        }
        else {
            if (etiqueta.compareTo(this.getEtiqueta()) < 0) {
                if (this.getHijoIzq() != null)
                    resultado = this.getHijoIzq().buscar(etiqueta, contador);
            }
            else {
                if (this.getHijoDer() != null)
                    resultado = this.getHijoDer().buscar(etiqueta, contador);
            }
        }
        
        // Si no encontr�, defino negativo al contador
        if (resultado == null)
            contador[0] *= -1;
        
        return resultado;
    }
    
    /**
     * Busca el elemento que coincida con la etiqueta, sin contador
     * @param etiqueta etiqueta a buscar
     * @return elemento
     */
    @Override
    public TElementoAB<T> buscar(Comparable etiqueta) {
        int contadorAux[] = {0};
        return this.buscar(etiqueta, contadorAux);
    }

    /**
     * Inserta elemento en el �rbol de b�squeda binaria
     * @param elemento elemento a insertar
     * @param contador contador de invocaciones
     * @return verdadero si insert� correctamente
     */
    public boolean insertar(TElementoAB<T> elemento, int contador[]) {
        Comparable unaEtiqueta;
        
        // Incremento contador
        contador[0]++;
        
        unaEtiqueta = elemento.getEtiqueta();
        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {
            contador[0] = 0; // restauro contador
            return false;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() == null)
                this.setHijoIzq(elemento);
            else 
                return this.getHijoIzq().insertar(elemento, contador);
        }
        else {
            if (this.getHijoDer() == null)
                this.setHijoDer(elemento);
            else 
                return this.getHijoDer().insertar(elemento, contador);
        }
        return true;
    }
    
    /**
     * Inserta elemento en el �rbol de b�squeda binaria, sin contador
     * @param elemento elemento a insertar
     * @return verdadero si insert� correctamente
     */
    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        int contadorAux[] = {0};
        return this.insertar(elemento, contadorAux);
    }
    
    /**
     * Retorna un listado Inorden de los elementos del �rbol
     * @return listado
     */
    @Override
    public String inOrden() {
        String listado;

        listado = "";
        // Hijo izquierdo
        if (this.getHijoIzq() != null)
            listado += this.getHijoIzq().inOrden();
        
        // Este elemento
        listado += this.getEtiqueta() + " ";
        
        // Hijo derecho
        if (this.getHijoDer() != null)
            listado += this.getHijoDer().inOrden();
        
        // Retorno listado
        return listado;
    }

    /**
     * Retorna un listado Preorden de los elementos del �rbol
     * @return listado
     */
    @Override
    public String preOrden() {
        String listado;

        listado = "";
        // Este elemento
        listado += this.getEtiqueta() + " ";
        
        // Hijo izquierdo
        if (this.getHijoIzq() != null)
            listado += this.getHijoIzq().preOrden();
        
        // Hijo derecho
        if (this.getHijoDer() != null)
            listado += this.getHijoDer().preOrden();
        
        // Retorno listado
        return listado;
    }

    /**
     * Retorna un listado Postorden de los elementos del �rbol
     * @return listado
     */
    @Override
    public String postOrden() {
        String listado;

        listado = "";
        
        // Hijo izquierdo
        if (this.getHijoIzq() != null)
            listado += this.getHijoIzq().postOrden();
        
        // Hijo derecho
        if (this.getHijoDer() != null)
            listado += this.getHijoDer().postOrden();
        
        // Este elemento
        listado += this.getEtiqueta() + " ";
        
        // Retorno listado
        return listado;
    }

    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.getEtiqueta())<0){ // si esta, est� en el sub�rbol izquierdo
            if (this.getHijoIzq()!=null){
                this.setHijoIzq(this.getHijoIzq().eliminar(unaEtiqueta));
            }
            return this;
        }
        if(unaEtiqueta.compareTo(this.getEtiqueta())>0){ // si esta, est� en el sub�rbol izquierdo
            if (this.getHijoDer()!=null){
                this.setHijoDer(this.getHijoDer().eliminar(unaEtiqueta));
            }
            return this;
        }
        return quitaElNodo();
    }

    private TElementoAB<T> quitaElNodo() {
        if (this.getHijoIzq()==null){
            return this.getHijoDer();
        }
        if (this.getHijoDer()==null){
            return this.getHijoIzq();
        }
        
        TElementoAB elHijo = this.getHijoIzq();
        TElementoAB elPadre = this;
        
        while (elHijo.getHijoDer()!=null){
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre!=this){
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(this.getHijoIzq());
        }
        elHijo.setHijoDer(this.getHijoDer());
        return elHijo;
    }
    
    /**
     * Retorna mayor elemento del sub-�rbol
     * @return elemento mayor
     */
    public TElementoAB<T> obtenerMayorElemento() {
        // Si es el �ltimo a la derecha, es el mayor
        if (this.getHijoDer() == null)
            return this;
        
        // Sigo buscando en los elementos a la derecha
        return this.getHijoDer().obtenerMayorElemento();
    }
    
    /**
     * Retorna menor elemento del sub-�rbol
     * @return elemento menor
     */
    public TElementoAB<T> obtenerMenorElemento() {
        // Si es el �ltimo a la izquierda, es el menor
        if (this.getHijoIzq() == null)
            return this;
        
        // Sigo buscando en los elementos a la izquierda
        return this.getHijoIzq().obtenerMenorElemento();
    }
    
    /**
     * Retorna suma de las claves del �rbol
     * @return suma claves
     */
    public int sumaClaves() {
        int suma;
        
        suma = 0;
        if (this.getEtiqueta() instanceof Integer)
            suma = (Integer)this.getEtiqueta();
        
        // Hijo izquierdo
        if (this.getHijoIzq() != null)
            suma += this.getHijoIzq().sumaClaves();
        
        // Hijo derecho
        if (this.getHijoDer() != null)
            suma += this.getHijoDer().sumaClaves();
        
        // Retorno suma
        return suma;
    }
    
    /**
     * Retorna nivel de un cierto nodo
     * @param unaEtiqueta
     * @return nivel
     */
    public int obtenerNivelSinContador(Comparable unaEtiqueta) {
        int nivel = 0;

        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {
            return nivel;
        }
        else {
            if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
                if (this.getHijoIzq() != null)
                    nivel = 1 + this.getHijoIzq().obtenerNivelSinContador(unaEtiqueta);
            }
            else {
                if (this.getHijoDer() != null)
                    nivel = 1 + this.getHijoDer().obtenerNivelSinContador(unaEtiqueta);
            }
        }

        // Si estoy parado en una hoja y no encontr�, retorno -1 as� empieza a restar en la recursi�n
        // Si vengo acumulando nivel, es porque encontr� en un momento. Retorno el nivel acumulado
        return (nivel == 0 ? -1 : nivel);
    }
    
    /**
     * Retorna la cantidad de nodos en un nivel
     * @param nivel nivel a buscar
     * @param raiz ra�z del �rbol
     * @return cantidad nodos
     */
    public int cantidadNodosEnNivel(int nivel, TElementoAB<T> raiz) {
        int nodos;
        
        nodos = 0;
        // Si el nodo actual est� en el nivel recibido por par�metro
        if (raiz.obtenerNivelSinContador(this.getEtiqueta()) == nivel)
            nodos = 1;
        
        // Hijo izquierdo
        if (this.getHijoIzq() != null)
            nodos += this.getHijoIzq().cantidadNodosEnNivel(nivel, raiz);
        
        // Hijo derecho
        if (this.getHijoDer() != null)
            nodos += this.getHijoDer().cantidadNodosEnNivel(nivel, raiz);
        
        // Retorno total
        return nodos;
    }
    
    /**
     * Verifica si se trata de un �rbol de b�squeda binaria
     * @return verdadero si es un �rbol binario de b�squeda
     */
    public boolean verificarSiEsArbolBB() {
        boolean esBB = true;
        
        // Comparo etiquetas de este elemento con sus hijos
        if (this.getHijoIzq() != null && esBB)
            // Si tiene hijo izquierdo, deber�a tener menor etiqueta
            esBB = (this.getHijoIzq().getEtiqueta().compareTo(this.getEtiqueta()) < 0);
        if (this.getHijoDer() != null && esBB)
            // Si tiene hijo derecho, deber�a tener mayor etiqueta
            esBB = (this.getHijoDer().getEtiqueta().compareTo(this.getEtiqueta()) > 0);
        
        // Si ya encontr� un caso err�neo, corto la recursi�n.
        if (!esBB)
            return esBB;
        
        // Hijo izquierdo
        if (this.getHijoIzq() != null)
            esBB = this.getHijoIzq().verificarSiEsArbolBB();
        
        // Si ya encontr� un caso err�neo, corto la recursi�n.
        if (!esBB)
            return esBB;
        
        // Hijo derecho
        if (this.getHijoDer() != null)
            esBB = this.getHijoDer().verificarSiEsArbolBB();
        
        // Retorno valor actual
        return esBB;
    }
    
}