
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class TArbolPiezas extends TArbolBB<Pieza> implements IArbolPiezas {

    @Override
    public TArbolPiezas piezasPorRubro(String unRubro) {
        TArbolPiezas arbol;
        Nodo<Pieza> nodoActual;
        Lista<Pieza> lista;
        Pieza piezaActual;

        arbol = new TArbolPiezas();

        if (this.getRaiz() == null) {
            return arbol;
        }

        // Genero lista inorden del arbol y recorro
        lista = this.inorden();
        nodoActual = lista.getPrimero();
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Inserto pieza si coincide con rubro
            if (piezaActual.obtenerRubro().equals(unRubro)) {
                arbol.insertar(new TElementoAB<>(piezaActual.getCodigoCatalogo(), piezaActual));
            }
            nodoActual = nodoActual.getSiguiente();
        }

        // Retorno nuevo arbol
        return arbol;
    }

    @Override
    public int[] cantYvalorStock() {
        Nodo<Pieza> pieza = this.inorden().getPrimero();
        int valorStock = 0;
        int cantidad = 0;
        int[] retorno = new int[2];
        while (pieza != null) {
            valorStock += pieza.getDato().getValorEnStock();
            cantidad += pieza.getDato().getCantidad();
            pieza = pieza.getSiguiente();
        }
        retorno[0] = valorStock;
        retorno[1] = cantidad;
        return retorno;
    }

}
