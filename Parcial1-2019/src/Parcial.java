
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Parcial {

    public static void main(String[] args) throws IOException {

        // instanciar curso BasicoIng...
        Conjunto<Alumno> BasicoIng = cargarBasicos("src/basico-ing.txt");
        // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
        
        // instanciar curso BasicoEmp...
        Conjunto<Alumno> BasicoEmp = cargarBasicos("src/basico-emp.txt");
        // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”

        // generar el curso "integrador101" con los alumnos que están en condiciones de cursarlo
        Conjunto<Alumno> integrador101 = BasicoIng.union(BasicoEmp);
        // guardar en un archivo "integrador101.txt"  - IDEALMENTE ordenados por código de alumno -
        // generar el curso "exigente102" con los alumnos que están en condiciones de cursarlo 
        Conjunto<Alumno> exigente102 = BasicoIng.interseccion(BasicoEmp);
        // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de alumno -
        
    }

    public static Conjunto<Alumno> cargarBasicos(String nombreArchivo) {
        File archivo;
        FileReader fr;
        BufferedReader br;
        Conjunto<Alumno> conjunto = null;
        try {
            conjunto = new Conjunto<>();
            int contador = 0;
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String lineasArch;
            while ((lineasArch = br.readLine()) != null) {
                if (contador == 0) {
                    contador = 1;
                } else {

                    String[] contenido;

                    contenido = lineasArch.split(",");

                    Integer id = Integer.parseInt(contenido[0]);
                    String name = contenido[1];

                    Alumno alumno = new Alumno(id, name);

                    Nodo<Alumno> alumnoAInsertar = new Nodo<>(id, alumno);

                    conjunto.insertar(alumnoAInsertar);

                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreArchivo);
        }

        return conjunto;

    }
    
}
