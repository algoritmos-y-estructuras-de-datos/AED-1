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
public class Alumno {
    private final int id;
    private final String nombre;
    
    public Alumno (int id , String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void imprimir(){
        System.out.println("id "+this.id+" nombre "+this.nombre);
    }
}
