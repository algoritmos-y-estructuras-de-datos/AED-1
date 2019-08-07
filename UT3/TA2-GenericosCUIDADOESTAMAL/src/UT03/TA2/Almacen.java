package UT03.TA2;

import UT03.TA2.TAD.Lista;
import UT03.TA2.TAD.IProducto;
import UT03.TA2.TAD.IAlmacen;
import UT03.TA2.TAD.INodo;
import UT03.TA2.TAD.Nodo;
import UT03.TA2.TAD.ListaOrdenada;

/**
 * Implementación TDA Almacen
 * @author Grupo 7
 */
public class Almacen implements IAlmacen {
    
    /** Dirección del almacen */
    private String direccion;
    
    /** Teléfono del almacen */
    private String telefono;
    
    /** Nombre del almacen */
    private String nombre;
    
    /** Lista de productos */
    private Lista<Producto> listaProductos;

    /**
     * Constructor por defecto de la clase
     * @param direccion
     * @param telefono
     * @param nombre 
     */
    public Almacen(String direccion, String telefono, String nombre) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.listaProductos = new Lista<>();
    }

    /**
     * Retorna dirección del almacen
     * @return direccion
     */
    @Override
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Retorna teléfono del almacen
     * @return teléfono
     */
    @Override
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Retorna nombre del almacen
     * @return nombre
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Retorna lista de productos del almacen
     * @return lista
     */
    @Override
    public Lista<Producto> getListaProductos() {
        return this.listaProductos;
    }

    /**
     * Define dirección del almacen
     * @param direccion 
     */
    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Define teléfono del almacen
     * @param telefono 
     */
    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Agrega un nuevo producto al almacen
     * @param unProducto 
     */
    @Override
    public void insertarProducto(Producto unProducto) {
        // Lista ya está validando por duplicados
        this.getListaProductos().insertar(new Nodo<>(unProducto.getEtiqueta(), unProducto, null));
    }

    /**
     * Elimina un producto del almacen
     * @param clave
     * @return booleano
     */
    @Override
    public boolean eliminar(Comparable clave) {
        return this.getListaProductos().eliminar(clave);
    }

    /**
     * Imprime una lista de productos, sin separador.
     * @return lista de caracteres
     */
    @Override
    public String imprimirProductos() {
        return this.imprimirSeparador(null);
    }

    /**
     * Imprime una lista de productos, con separador.
     * @param separador
     * @return lista de caracteres
     */
    @Override
    public String imprimirSeparador(String separador) {
        return this.getListaProductos().imprimir(separador);
    }

    /**
     * Agrega stock a un producto
     * @param clave
     * @param cantidad
     * @return booleano
     */
    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        IProducto producto;
        Integer nuevoStock;
        
        // Busco el producto
        producto = this.buscarPorCodigo(clave);
        
        // Retorno nulo si no encontré producto
        if (producto == null)
            return null;
        
        // Aumento stock del producto
        nuevoStock = producto.getStock() + cantidad;
        producto.setStock((nuevoStock < 0) ? 0 : nuevoStock);
        
        return true;
    }

    /**
     * Disminuye y retorna nuevo stock de un producto
     * @param clave
     * @param cantidad
     * @return nuevo stock
     */
    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        IProducto producto;
        Integer nuevoStock;
        
        // Busco el producto
        producto = this.buscarPorCodigo(clave);
        
        // Retorno nulo si no encontré producto
        if (producto == null)
            return null;
        
        // Resto stock del producto
        nuevoStock = producto.getStock() - cantidad;
        producto.setStock((nuevoStock < 0) ? 0 : nuevoStock);
        
        // Retorno nuevo stock
        return producto.getStock();
    }

    /**
     * Busca y retorna un producto según su código
     * @param clave
     * @return producto
     */
    @Override
    public IProducto buscarPorCodigo(Comparable clave) {
        INodo<Producto> nodoProducto;
        IProducto producto;
        
        // Busco el nodo del producto
        nodoProducto = this.getListaProductos().buscar(clave);
        
        // Retorno falso si no encontré producto
        if (nodoProducto == null)
            return null;
        
        // Retorno el producto (dato del nodo)
        return nodoProducto.getDato();
    }

    /**
     * Imprime los productos de forma ordenada
     */
    @Override
    public void listarOrdenadoPorNombre() {
        ListaOrdenada<Producto> lista;
        INodo<Producto> actual;
        Producto productoActual;
        
        // Si la lista de productos está vacía, no imprimo.
        if (this.getListaProductos().esVacia())
            return;

        // Debo recorrer manualmente la lista de nodos e ir "casteando" el producto
        actual = this.getListaProductos().getPrimero();
        productoActual = actual.getDato();

        // Creo lista ordenada y agrego el primero
        lista = new ListaOrdenada(new Nodo<>(productoActual.getNombre(), productoActual, null));

        // Recorro cada elemento y voy agregando de forma ordenada cada uno
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            productoActual = actual.getDato();
            lista.insertar(new Nodo<>(productoActual.getNombre(), productoActual, null));
        }

        // Imprimo la lista con saltos de línea
        System.out.print(lista.imprimir("\n"));
    }

    /**
     * Busca y retorna un producto según descripción
     * @param descripcion
     * @return producto
     */
    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        Producto productoActual;
        INodo<Producto> actual;
        
        // Si la lista de productos está vacía, retorno nulo.
        if (this.getListaProductos().esVacia())
            return null;

        // Debo recorrer manualmente la lista de nodos e ir "casteando" el producto para comparar
        actual = this.getListaProductos().getPrimero();
        productoActual = actual.getDato();
        // Verifico si es el primero
        if (productoActual.getNombre().compareTo(descripcion) == 0)
            return productoActual;

        // Recorro cada elemento y verifico con cada uno
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            productoActual = actual.getDato();
            // Verifico igualdad de nombre
            if (productoActual.getNombre().compareTo(descripcion) == 0)
                return productoActual;
        }
        return null;
    }

    /**
     * Retorna cantidad de productos
     * @return cantidad
     */
    @Override
    public int cantidadProductos() {
        return this.getListaProductos().cantElementos();
    }
    
    /**
     * Retorna el valor total del stock
     * @return valor
     */
    public Integer valorTotalStock() {
        Producto productoActual;
        INodo<Producto> actual;
        Integer valor;
        
        // Si la lista de productos está vacía, retorno cero
        if (this.getListaProductos().esVacia())
            return 0;

        // Debo recorrer manualmente la lista de nodos e ir "casteando" el producto sumarizar
        valor = 0;
        actual = this.getListaProductos().getPrimero();
        productoActual = actual.getDato();
        // Acumulo primero
        valor += (productoActual.getPrecio() * productoActual.getStock());

        // Recorro cada elemento y acumulo con cada uno
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            productoActual = actual.getDato();
            // Acumulo producto actual
            valor += (productoActual.getPrecio() * productoActual.getStock());
        }
        return valor;
    }
    
    /**
     * Inserta un producto o actualiza su stock si existe
     * @param unProducto 
     */
    public void insertarProductoStock(Producto unProducto) {
        IProducto producto;
        
        // Busco el producto
        producto = this.buscarPorCodigo(unProducto.getEtiqueta());
        
        // Ingreso producto si no lo encontré
        if (producto == null) {
            this.insertarProducto(unProducto);
        }
        else {
            // Aumento stock del producto
            producto.setStock(producto.getStock() + unProducto.getStock());
        }
    }
}