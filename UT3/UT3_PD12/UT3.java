/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD12;

/**
 *
 * @author Meki
 */
public class UT3 {


    public static void main(String[] args) {
        Manejador m = new Manejador();
        
        m.cargarListaA();
        m.cargarListaB();
        m.imprimir(m.listaA);
        System.out.println("-----------------------");
        m.imprimir(m.listaB);
        m.escribirArchivo("src\\UT3PD12\\listaA.txt", m.listaA);
        m.escribirArchivo("src\\UT3PD12\\listaB.txt", m.listaB);
    }
    
}
