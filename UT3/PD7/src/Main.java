/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conjunto uno = new Conjunto();

        INodo nodo3 = new Nodo(3, 3, null);

        INodo nodo2 = new Nodo(2, 2, nodo3);

        INodo nodo1 = new Nodo(1, 1, nodo2);
        uno.insertar(nodo1);
        
        Conjunto otro = new Conjunto();

        INodo nodo6 = new Nodo(3, 3, null);

        INodo nodo5 = new Nodo(5, 5, nodo6);

        INodo nodo4 = new Nodo(4, 4, nodo5);
        otro.insertar(nodo4);
        //System.out.println(otro.imprimir());
        Conjunto nuevo = uno.union(otro);
        
        System.out.println(nuevo.imprimir());
    }

}
