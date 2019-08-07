
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlantillaMedicos hospital = new PlantillaMedicos();
        /**
         * 1. Crear los médicos y cargarlos en la planilla del hospital a partir
         * del archivo "medicos.txt” Cada línea tiene cédula, nombre,
         * especialidad y año de ingreso del médico
         */
        String[] lineasMedicos = ManejadorArchivosGenerico.leerArchivo("src/medicos.txt");

        Medico medico;
        for (String l : lineasMedicos) {
            String[] datos = l.split(",");
            medico = new Medico(Integer.valueOf(datos[0]), datos[1], datos[2], Integer.valueOf(datos[3]));
            TElementoAB<Medico> nuevoNodo = new TElementoAB<>(medico.getCedula(), medico);
            hospital.insertar(nuevoNodo);
        }

        
        /*
        
2.      Emitir por consola el listado de médicos de la plantilla del hospital 
        ordenado en forma ascendente por número de Cédula y la Cantidad total de
        medicos en la plantilla.

3.	Eliminar de la plantilla los médicos con las siguientes Cédulas: 
        7669, 
        1632, 
        5328, 
        1081,
        9069
        
4.      Emitir por consola la nueva cantidad de medicos en la plantilla (invocando
        al metodo correspondiente del arbol de plantilla)
        
5.	Dados los siguientes números de cédula, recuperar los médicos 
        correspondientes de la plantilla e imprimir por consola sus datos completos: 
        8948, 
        5683 y 
        822

6.	Ejecutar el método “obtenerDirectorio” de la plantilla del hospital, 
        para la especialidad que se indicará en el pizarrón. 
         */
//  String especialidad = // se comunica en el pizarron;
//        DirectorioEspecialidad arbolEspecialidad = hospital.obtenerDirectorio(especialidad);
/*

7.	Escribir un archivo “medicos_policlinica.txt” que contenga todos los 
datos de los médicos incluidos en la instancia de DirectorioEspecialidad obtenida, 
uno por cada línea, ordenados alfabéticamente por nombre.

8.	Ejecutar el método “listadoIngresos” del directorio de la especialidad, 
pasando por parámetro el año indicado en el pizarrón.

9.	Escribir un archivo “médicos_poli_anio.txt” con los datos resultantes del 
punto anterior, un médico por línea (todos los datos), ordenados alfabéticamente 
por nombre.

         */
    }

}
