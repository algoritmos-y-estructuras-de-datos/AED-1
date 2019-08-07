
import java.util.Objects;


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
    public Lista<Integer> golesHechosEnTemporada;
    /**
     * Lista con goles recibidos en una temporada
     */
    public Lista<Integer> golesRecibidosEnTemporada;
    
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
        this.golesHechosEnTemporada = new Lista<>();
        this.golesRecibidosEnTemporada = new Lista<>();
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
    public int getGolesHechos(Integer temporada){
        Nodo<Integer> aux = this.golesHechosEnTemporada.getPrimero();
        int resultado = 0;
        while(aux!=null){
            if(Objects.equals(aux.getDato(), temporada)){
                resultado++;
            }
            aux = aux.getSiguiente();
        }
        return resultado;
    }
    public int getGolesRecibidos(Integer temporada){
        Nodo<Integer> aux = this.golesRecibidosEnTemporada.getPrimero();
        int resultado = 0;
        while(aux!=null){
            if(Objects.equals(aux.getDato(), temporada)){
                resultado++;
            }
            aux = aux.getSiguiente();
        }
        return resultado;
    }
}
