
import java.util.ArrayList;


/**
 *
 * @author lucas
 */
public class Team {
    
    /**
     * id del equipo
     */
    public String id;

    /**
     * Nombre del equipo
     */
    public String name;

    /**
     * Integer que representa los goles del equipo
     */
    public Integer goles;

    /**
     * Integer que representa los goles recibidos por el equipo
     */
    public Integer golesRecibidos;

    /**
     * Lista con los goles Hechos en una temporada
     */
    public ArrayList<Integer> golesHechosEnTemporada;
    /**
     * Lista con goles recibidos en una temporada
     */
    public ArrayList<Integer> golesRecibidosEnTemporada;
    
    /**
     *
     * @param id para constructor
     * @param name nombnre para constructor
     */
    public Team(String id, String name){
        
        this.id = id;   
        this.name = name;
        this.goles = 0;
        this.golesRecibidos = 0;
        this.golesHechosEnTemporada = new ArrayList<>();
        this.golesRecibidosEnTemporada = new ArrayList<>();
    }
    
    /**
     *
     * @return id del equipo
     */
    public String getId(){
        return this.id;
    }
    
    /**
     *
     * @return nombre del equipo
     */
    public String getName(){
        return this.name;
    }
    
    /**
     *
     * @return string con informacion del equipo
     */
    @Override
    public String toString(){
        String retorno = "ID: " + this.id + "\n" 
                + "Nombre: " + this.name + "\n";
        return retorno;
    }
}
