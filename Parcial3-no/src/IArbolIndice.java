/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface IArbolIndice {
  public void actualizarFrecuencias(Comparable clave);   
  public void listarClavesyFrecuencias(String[] claves, int[] FE, int[] FNE);
}
