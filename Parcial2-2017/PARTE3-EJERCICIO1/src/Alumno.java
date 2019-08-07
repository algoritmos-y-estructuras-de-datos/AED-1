/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ernesto
 */
public class Alumno {

    private final int Codigo;
    private final String Apellido;
    private final String Carrera;

    public Alumno(int Codigo, String Apellido, String Carrera) {

        this.Codigo = Codigo;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
    }

    public int getCodigo() {
        return this.Codigo;
    }

    public String getApellido() {
        return this.Apellido;
    }

    public String getCarrera() {
        return this.Carrera;
    }

    public String imprimir() {
        return (this.Codigo + " " + this.Apellido + " " + this.Carrera);

    }

}
