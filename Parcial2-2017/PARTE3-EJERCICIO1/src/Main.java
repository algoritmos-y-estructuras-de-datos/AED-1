import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBBU ucu  = new TArbolBBU();
        // cargar los alumnos en el árbol "ucu" desde el archivo de datos "datos.csv"
        /*String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/datos.csv");
        
        for (String datosAlumno : lineas)
        {
            String[] alumno = datosAlumno.split(",");
            Alumno nuevoAlumno = new Alumno(Integer.parseInt(alumno[0]),alumno[1],alumno[2]);
            ucu.insertar(new TNodoAlumnoAB(nuevoAlumno.getCodigo(),nuevoAlumno));
        }*/
        
        ucu.insertar(new TNodoAlumnoAB(10,new Alumno(10,"abc","cls")));
        ucu.insertar(new TNodoAlumnoAB(5,new Alumno(5,"asc","cls")));
        ucu.insertar(new TNodoAlumnoAB(2,new Alumno(2,"aaa","cls")));
        ucu.insertar(new TNodoAlumnoAB(15,new Alumno(15,"agf","cls")));
        ucu.insertar(new TNodoAlumnoAB(19,new Alumno(19,"aac","cls")));
        ucu.insertar(new TNodoAlumnoAB(14,new Alumno(14,"acc","cls")));
        ucu.insertar(new TNodoAlumnoAB(11,new Alumno(11,"azc","cls")));
        System.out.println(ucu.mayorValor(11,15));
                
        String laCarrera = "Derecho";
      /* 
        TArbolBBU porCarrera = ucu.armarIndiceCarrera(laCarrera);
        
        String xCarrera = porCarrera.inOrden();
        String [] salida = xCarrera.split("-");
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt",salida);*/
        // escribir en el archivo "salida.txt" el listado emitido de los alumnos
        // de la carrera indicada, en orden alfabético ascendente
        
        
    }

   

}

