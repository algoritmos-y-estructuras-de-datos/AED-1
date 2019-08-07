
/*
 *
 * @author lucas
 */
public class Player {
    
    /**
     * id del jugador
     */
    public String id;

    /**
     * Nombre del jugador
     */
    public String name;

    /**
     * Posiciones del jugador
     */
    public Lista<String> playerPositions;

    /**
     * Ligas y temporadas donde ha jugado un jugador
     */
    public Lista<String> playerLeagueNSeason;

    /**
     * Ligas donde ha jugado el jugador
     */
    public Lista<String> playerLeagues;

    /**
     * Temporadas en las que ha jugado un jugador
     */
    public Lista<Integer> playerSeasons;

    /**
     * Equipos en los que ha jugado un jugador
     */
    public Lista<Team> playerTeams;

    /**
     * Goles y equipos a los que se lo ha hecho un jugador
     */
    public Lista<String> goalsToTeams;

    /**
     * Intentos de un  jugador
     */
    public Integer attempt;

    /**
     * Corners de un jugador
     */
    public Integer corner;

    /**
     * Fouls de un jugador
     */
    public Integer foul;

    /**
     * Tarjetas amarillas de un jugador
     */
    public Integer yellow;

    /**
     * Tarejetas rojas de un jugador
     */
    public Integer red;

    /**
     * Tiros libres ganados de un jugador
     */
    public Integer freeKickWon;

    /**
     * Offisdes de un jugador
     */
    public Integer offside;

    /**
     * Penales concedidos por un jugador
     */
    public Integer penalty;

    /**
     * Paases buenos de un jugador
     */
    public Integer keyPass;

    /**
     * Gol en contra de un jugador
     */
    public Integer ownGoal;

    /** 
     * Tapadas de un golero
     */
    public Integer tapadas;
    /** 
     * Tapadas de un golero
     */
    public Integer goal;
    
    /**
     *
     * @param id
     * @param name
     */
    public Player(String id, String name){
        this.id = id;
        this.name = name;
        this.playerPositions = new Lista<>();
        this.playerLeagueNSeason = new Lista<>();
        this.playerLeagues = new Lista<>();
        this.goalsToTeams = new Lista<>();
        this.playerTeams = new Lista<>();
        this.playerSeasons = new Lista<>();
        this.goal = 0;
        this.attempt = 0;
        this.corner = 0;
        this.foul = 0;
        this.yellow = 0;
        this.red = 0;
        this.freeKickWon = 0;
        this.offside = 0;
        this.penalty = 0;
        this.keyPass = 0;
        this.ownGoal = 0;
        this.tapadas = 0;
    }
    
    /**
     *
     * @return id
     */
    public Comparable getId(){
        return this.id;
    }
    
    /**
     *
     * @return nombre
     */
    public String getName(){
        return this.name;
    }
    
    /**
     *
     * @return liga y temporada con mayor participacion
     */
    public String getMostLeageNSeasonParticipations(){
        Comparable retorno = this.playerLeagueNSeason.masComun();
        return retorno.toString();
    }

    /**
     *
     * @return String con la informacion completa de un jugador
     */
    @Override
    public String toString(){
       Nodo<Team> equipo = this.playerTeams.buscar(this.playerTeams.masComun().toString());
       String retorno = "\n" + "ID: " + this.id + "\n"
               + "Nombre: " + this.name +"\n"
               + "Equipos: " + equipo.getDato().name + "\n"
               + "Posiciones: " + this.playerPositions.masComun() + "\n"
               + "Goles: " + this.goalsToTeams.cantElementos() + "\n"
               + "Liga y temporada con mayores participaciones: " + "\n" + this.getMostLeageNSeasonParticipations();
       return retorno;
    }
    /**
     * 
     * @param y boolean para no imprimir liga
     * @return 
     */
    public String toString(Boolean y){
       Nodo<Team> equipo = this.playerTeams.buscar(this.playerTeams.masComun().toString());
       String retorno = "\n" + "Nombre: " + this.name +"\n"
               + "Equipos: " + equipo.getDato().name + "\n"
               + "Posiciones: " + this.playerPositions.masComun();
               
       return retorno;
    }
    /**
     * 
     * @return 
     */
    public String toStringGolero(){
       Nodo<Team> equipo = this.playerTeams.buscar(this.playerTeams.masComun().toString());
       String retorno = "\n" + "Nombre: " + this.name +"\n"
               + "Equipos: " + equipo.getDato().name + "\n"
               + "Posiciones: " + this.playerPositions.masComun() + "\n"
               + "Tapadas: " + this.tapadas;
       return retorno;
    }
    /**
     * 
     * @return String con la posicion de un jugador
     */
    public String getPosicion(){
        String retorno = this.playerPositions.masComun().toString();
        return retorno;
    }
}
