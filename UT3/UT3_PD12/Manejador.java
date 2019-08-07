/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Meki
 */
public class Manejador {
    
    public Manejador(){
        
    }
    
    Lista<Alumno> listaA = new Lista<>();
    Lista<Alumno> listaB = new Lista<>();

    public void imprimir(Lista<Alumno> lista) {

        Nodo<Alumno> nodo = lista.getPrimero();
        while (nodo != null) {
            nodo.getDato().imprimir();
            nodo = nodo.getSiguiente();
        }
    }

    public void cargarListaA() {

        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File("src\\UT3PD12\\basico-emp.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ;
                contenido = lineas.split(",");
                for (int i = 0; i < contenido.length; i++) {
                    //quitan las comillas de cada dato
                    contenido[i] = contenido[i].replaceAll("\"", "");
                }
                int id = Integer.valueOf(contenido[0]);
                String nombre = contenido[1];

                Alumno alumno = new Alumno(id, nombre);
                Nodo<Alumno> nodo = new Nodo(alumno.getId(), alumno);
                listaA.insertar(nodo);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }

    }

    public void cargarListaB() {
        File archivo2;
        FileReader fr2;
        BufferedReader br2;
        String lineas2;
        try {
            archivo2 = new File("src\\UT3PD12\\basico-ing.txt");
            fr2 = new FileReader(archivo2);
            br2 = new BufferedReader(fr2);

            while ((lineas2 = br2.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ;
                contenido = lineas2.split(",");
                for (int i = 0; i < contenido.length; i++) {
                    //quitan las comillas de cada dato
                    contenido[i] = contenido[i].replaceAll("\"", "");
                }
                int id = Integer.valueOf(contenido[0]);
                String nombre = contenido[1];

                Alumno alumno = new Alumno(id, nombre);
                Nodo<Alumno> nodo = new Nodo(alumno.getId(), alumno);
                listaB.insertar(nodo);

            }

            br2.close();
            fr2.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }

    }
    
        public void escribirArchivo(String nombreCompletoArchivo, Lista<Alumno> listaLineasArchivo) {
        
        FileWriter fw;
        try {
            fw = new FileWriter(nombreCompletoArchivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Nodo<Alumno> nodo = listaLineasArchivo.getPrimero();
            while(nodo != null) {
                
                String linea = String.valueOf(nodo.getDato().getId()).concat("/").concat(nodo.getDato().getNombre());
                bw.write(linea);
                bw.newLine();
                
                nodo = nodo.getSiguiente();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "
                    + nombreCompletoArchivo);

        }
    }
    
}
