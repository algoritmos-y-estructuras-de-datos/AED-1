/**
 *
 * @author lucas
 */
public class Match {
    
    final String id;
    final String date;
    final String league;
    final Integer season;
    final String homeTeam;
    final String awayTeam;
    
    /**
     *
     * @param id del partido
     * @param date fecha del partido
     * @param league Liga donde se jugo el partido
     * @param season temporada donde se jugo el partido
     * @param homeTeam equipo local
     * @param awayTeam equipo visitante
     */
    public Match(String id, 
            String date, String league, 
            Integer season, String homeTeam, String awayTeam){
        this.id = id;
        this.date = date;
        this.league = league;
        this.season = season;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    /**
     *
     * @return id del partido
     */
    public String getId(){
        return this.id;
    }
    
    /**
     *
     * @return fecha del partido
     */
    public String getDate(){
        return this.date;
    }
    
    /**
     *
     * @return liga del partido
     */
    public String getLeague(){
        return this.league;
    }
    
    /**
     *
     * @return temporada del partido
     */
    public Integer getSeason(){
        return this.season;
    }
    
    /**
     *
     * @return equipo local
     */
    public String getHomeTeam(){
        return this.homeTeam;
    }
    
    /**
     *
     * @return equipo visitante
     */
    public String getAwayTeam(){
        return this.awayTeam;
    }
}
