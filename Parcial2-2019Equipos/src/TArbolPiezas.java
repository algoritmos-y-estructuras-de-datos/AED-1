
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
        Nodo<Pieza> actual;
        Lista<Pieza> lista;
        Pieza pieza;

        arbol = new TArbolPiezas();

        if (this.getRaiz() == null) {
            return arbol;
        }

        lista = this.inorden();
        actual = lista.getPrimero();
        while (actual != null) {
            pieza = actual.getDato();

            if (pieza.obtenerRubro().equals(unRubro)) {
                arbol.insertar(new TElementoAB<>(pieza.getCodigoCatalogo(), pieza));
            }
            actual = actual.getSiguiente();
        }
        return arbol;
    }

    @Override
    public int[] cantYvalorStock() {
        Nodo<Pieza> pieza = this.inorden().getPrimero();
        int[] retorno = new int[2];
        while (pieza != null) {
            retorno[0] += pieza.getDato().getValorEnStock();
            retorno[1] += pieza.getDato().getCantidad();
            pieza = pieza.getSiguiente();
        }
        return retorno;
    }

}
