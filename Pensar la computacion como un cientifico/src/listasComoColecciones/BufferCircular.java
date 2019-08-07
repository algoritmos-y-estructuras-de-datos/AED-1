/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasComoColecciones;

/**
 *
 * @author lucas
 */
public class BufferCircular {

    public Object[] arreglo;
    public int primero, prox;

    public BufferCircular() {
        arreglo = new Object[3];
        primero = 0;
        prox = 0;
    }

    public boolean estaVacia() {
        return primero == prox;
    }

    public void agregar(Object elemento) {
        arreglo[prox] = elemento;
        prox++;
        if (prox == arreglo.length) prox = 0;
        if ((prox + 1) % arreglo.length == primero){
            System.out.println("El arreglo esta lleno");
        }
    }

    public Object quitar() {
        Object resultado = arreglo[primero];
        primero++;
        return resultado;
    }

}
