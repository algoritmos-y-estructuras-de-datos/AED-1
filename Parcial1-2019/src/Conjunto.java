/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {
// MEJOR: public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {

    @Override
    public Conjunto union(Conjunto otroConjunto) {
        Conjunto<T> retorno = new Conjunto<>();
        Nodo<T> aux = otroConjunto.getPrimero();
        Nodo<T> aux2 = this.getPrimero();
        while (aux != null) {
            retorno.insertar(aux);
        }
        while (aux2 != null) {
            retorno.insertar(aux2);
        }
        return retorno;
    }

    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        Conjunto<T> retorno = new Conjunto<>();
        Nodo<T> buscado = otroConjunto.getPrimero();
        Nodo<T> buscado2 = this.getPrimero();
        while (buscado2 != null) {
            if (this.buscar(buscado.getEtiqueta()) != null) {
                retorno.insertar(buscado);
            }
        }
        return retorno;
    }

}
