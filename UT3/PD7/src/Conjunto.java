/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class Conjunto extends Lista {

    public Conjunto union(Conjunto otroConjunto) {
        INodo aux = this.getPrimero();
        INodo aux2 = otroConjunto.getPrimero();
        Conjunto union = new Conjunto();
        if (otroConjunto.esVacia()) {
            return this;
        }
        while (aux != null) {
            while (aux2 != null) {
                if (this.buscar(aux2.getEtiqueta()) == null) {
                    union.insertar(aux);

                }
                aux2 = aux2.getSiguiente();
            }
            aux = aux.getSiguiente();
        }
        return union;
    }

    public IConjunto interseccion(IConjunto otroConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
