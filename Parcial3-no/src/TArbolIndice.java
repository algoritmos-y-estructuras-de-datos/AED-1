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
public class TArbolIndice<T> extends TArbolBB implements IArbolIndice {

 
    @Override
    public void listarClavesyFrecuencias(String[] claves, int[] FE, int[] FNE) {
        if(this.esVacio()) return;
        int[] indice = new int[1];
        this.getRaiz().listarClavesyFrecuencias(claves, FE, FNE, indice);
    }

    @Override
    public void actualizarFrecuencias(Comparable clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
