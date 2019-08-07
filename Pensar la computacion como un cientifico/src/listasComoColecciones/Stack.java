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
public class Stack {

    Object[] arreglo;
    int indice;

    public Stack() {
        this.arreglo = new Object[128];
        this.indice = 0;
    }
    
    public int tam(){
        return this.arreglo.length;
    }

    public boolean isEmpty() {
        return indice == 0;
    }

    public void push(Object item) {
        if (lleno()) {
            redimensionar();
        }
// en este punto podemos probar
// que indice < arreglo.length
        arreglo[indice] = item;
        indice++;
    }

    public Object pop() {
        indice--;
        return arreglo[indice];
    }

    private boolean lleno() {
        return indice == arreglo.length;
    }

    private void redimensionar() {
        Object[] nuevoArreglo = new Object[arreglo.length * 2];
// asumimos que el arreglo anterior estaba lleno
        for (int i = 0; i < arreglo.length; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }

}
