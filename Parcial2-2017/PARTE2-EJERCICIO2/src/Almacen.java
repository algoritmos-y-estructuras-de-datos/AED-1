
public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;

    private TArbolBB<Producto> productos;

    public TArbolBB<Producto> getProductos() {
        return productos;
    }

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        productos.insertar(new TElementoAB<>(unProducto.getEtiqueta(), unProducto));
    }

    @Override
    public String imprimirProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> buscado = productos.buscar(clave);
        if (buscado != null) {
            buscado.getDatos().setStock(buscado.getDatos().getStock() + cantidad);
            return true;
        }
        return false;
    }


    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> aux = productos.buscar(clave);
        if (aux != null){
             if (aux.getDatos().restarStock(cantidad) != -1)
                return aux.getDatos().getStock(); 
        }
        return -1;
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB<Producto> aux = productos.buscar(clave);
        if (aux != null){
            return aux.getDatos();
        }
        return null;
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        productos.eliminar(clave);
        return productos.buscar(clave) == null;
    }

    public Boolean ventaProducto(Comparable id, int ventas){
        TElementoAB<Producto> producto = productos.buscar(id);
        if ( producto != null){
            if (producto.getDatos().getStock()>= ventas){
                 producto.getDatos().restarStock(ventas);
                return true;
            }
           return false;
        }
        else
            return false;
    }
    
    public int obtenerMontoTotal(){
        Nodo<Producto> nodo = productos.inorden().getPrimero();
        int monto = 0;
        while (nodo != null){
            monto += nodo.getDato().getValor();
            nodo = nodo.getSiguiente();
        }
        return monto;
    }
    
    
    public Integer mayorValor(Comparable menorClave, Comparable mayorClave){
        Lista inOrden = this.getProductos().inorden();
    }
   

   

   

}
