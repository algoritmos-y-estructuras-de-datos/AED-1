
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

/**
 *
 * @author lucas
 */
public class OnceIdeal {

    /**
     * Lista de equipos
     */
    public Lista<Team> listaEquipos;

    /**
     * Lista con los jugadores
     */
    public Lista<Player> listaJugadores;

    /**
     * Lista de partidos
     */
    public Lista<Match> listaPartidos;

    /**
     *
     */
    public OnceIdeal() {
        this.listaEquipos = new Lista<>();
        this.listaJugadores = new Lista<>();
        this.listaPartidos = new Lista<>();
    }

    /**
     *
     * @param nombreArchivo de jugadores
     */
    public void cargarJugador(String nombreArchivo) {
        BufferedReader lector;
        String contenido;
        try {
            lector = new BufferedReader(new java.io.FileReader(nombreArchivo));
            lector.readLine();
            contenido = lector.readLine() + "\n";
            String lineaLeida;
            while ((lineaLeida = lector.readLine()) != null) {
                contenido += lineaLeida + "\n";
            }
            lector.close();
            for (String linea : contenido.split("\n")) {
                String columnas[] = linea.split(";");
                if (columnas.length == 2) {
                    Player jugador = new Player(columnas[0].trim().replaceAll("\"", ""), columnas[1].trim().replaceAll("\"", ""));
                    Nodo<Player> jugadorInsertar = new Nodo<>(jugador.getId(), jugador);
                    if (listaJugadores.buscar(jugadorInsertar.getEtiqueta()) == null) {
                        listaJugadores.insertarOrdenado(jugadorInsertar.clonar());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreArchivo);
        }
    }

    /**
     *
     * @param nombreArchivo de equipos
     */
    public void cargarTeams(String nombreArchivo) {
            File archivo;
            FileReader fr;
            BufferedReader br;
            try {
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

                        contenido = lineasArch.split(";");
                        for (int i = 0; i < contenido.length; i++) {
                            contenido[i] = contenido[i].replaceAll("\"", "");
                        }
                        if (contenido.length == 2) {
                            String id = contenido[0];
                            String name = contenido[1];
                            Team equipo = new Team(id,name);

                            Nodo<Team> equipoInsertar = new Nodo<>(id, equipo);

                            listaEquipos.insertar(equipoInsertar);
                            }
                        }
                    }

                br.close();
                fr.close();

            } catch (IOException e) {
                System.out.println("Error al leer el archivo " + nombreArchivo);
            }

        }

    /**
     *
     * @param nombreArchivo de partidos
     */
    public void cargarMatches(String nombreArchivo) {
        File archivo;
        FileReader fr;
        BufferedReader br;
        try {
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

                    contenido = lineasArch.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                    if (contenido.length == 6) {
                        String idOdsp = contenido[0];
                        String date = contenido[1];
                        String league = contenido[2];
                        String season = contenido[3];
                        String ht = contenido[4];
                        String at = contenido[5];
                        

                        Match partido = new Match(idOdsp, date, league, Integer.parseInt(season), ht, at);

                        Nodo<Match> partidoInsertar = new Nodo<>(idOdsp, partido);
                        
                        listaPartidos.insertar(partidoInsertar);
                    }
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreArchivo);
        }

    }

    /**
     *
     * @param nombreArchivo nombre del archivo de eventos
     */
    public void cargarEvents(String nombreArchivo) {
        File archivo;
        FileReader fr;
        BufferedReader br;
        try {
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

                    contenido = lineasArch.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                    if (contenido.length == 22) {
                        String idOdsp = contenido[0];
                        String typeEvent = contenido[5];
                        String type2Event = contenido[6];
                        String teamEvent = contenido[8];
                        String opponentEvent = contenido[9];
                        String playerEvent = contenido[10]; 
                        String shotOutcome = contenido[15];
                        String isGoal = contenido[16];
                        Nodo<Player> buscado = this.buscarJugadorPorNombre(playerEvent);
                        Nodo<Team> team = this.buscarEquipoPorNombre(teamEvent);
                        Nodo<Team> opponent = this.buscarEquipoPorNombre(opponentEvent);
                        if (buscado != null) {
                            
                            String n2 = this.buscarPartidoLeague(idOdsp);
                            buscado.getDato().playerLeagues.insertarOrdenado(new Nodo<>(n2,n2));
                            
                            if (typeEvent.equals("1")) {
                                
                                String nn = this.buscarPartidoLeagueSeason(idOdsp);
                   
                                buscado.getDato().playerLeagueNSeason.insertarPrincipio(new Nodo<>(nn,idOdsp));
                                                                                             
                                buscado.getDato().attempt++;
                            }
                            
                            if (typeEvent.equals("2")) {
                                                                                                                     
                                buscado.getDato().corner++;
                            }
                            
                            if (typeEvent.equals("3")) {
                         
                                String nn = this.buscarPartidoLeagueSeason(idOdsp);
                                
                                buscado.getDato().playerLeagueNSeason.insertarPrincipio(new Nodo<>(nn,idOdsp));
                                
                                buscado.getDato().foul++;
                            }
                            if (typeEvent.equals("4")) {
                                                            
                                buscado.getDato().yellow++;
                            }
                            if (typeEvent.equals("5")) {buscado.getDato().yellow++;}
                            if (typeEvent.equals("6")) {
                                
                                String nn = this.buscarPartidoLeagueSeason(idOdsp);
                                
                                buscado.getDato().playerLeagueNSeason.insertarPrincipio(new Nodo<>(nn,idOdsp));
                                buscado.getDato().red++;
                            }
                            if (typeEvent.equals("8")) {
                                
                                String nn = this.buscarPartidoLeagueSeason(idOdsp);
                                
                                buscado.getDato().playerLeagueNSeason.insertarPrincipio(new Nodo<>(nn,idOdsp));
    
                                buscado.getDato().freeKickWon++;
                            }
                            if (typeEvent.equals("9")) {
                                
                                buscado.getDato().offside++;
                            }
                            if (typeEvent.equals("11")) {
                                
                                buscado.getDato().penalty++;
                            }
                            if (type2Event.equals("12")) {
                                String nn = this.buscarPartidoLeagueSeason(idOdsp);
                                buscado.getDato().playerLeagueNSeason.insertarPrincipio(new Nodo<>(nn,idOdsp));
                                buscado.getDato().keyPass++;
                            }
                            if (type2Event.equals("15")) {
                                String nn = this.buscarPartidoLeagueSeason(idOdsp);
                                buscado.getDato().playerLeagueNSeason.insertarPrincipio(new Nodo<>(nn,idOdsp));
                                buscado.getDato().ownGoal++;
                            }
                            
                            if (isGoal.equals("1") && shotOutcome.equals("1")) {
                                if (team != null && opponent != null){
                                    Integer nn = this.buscarPartidoSeason(idOdsp);
                                    team.getDato().golesHechosEnTemporada.add(nn);
                                    opponent.getDato().golesRecibidosEnTemporada.add(nn);
                                }
                                String nn = this.buscarPartidoLeagueSeason(idOdsp);
                                buscado.getDato().goalsToTeams.insertar(new Nodo(nn,opponentEvent));
                            }
                            if (isGoal.equals("0") && shotOutcome.equals("1")){
                                if (buscado.getDato().getPosicion().equals("A")){
                                    buscado.getDato().tapadas++;
                                }
                               
                                
                            }
                           
                        }
                    }
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreArchivo + e);
        }

    }
    
    /**
     *
     * @param nombreArchivo
     */
    public void cargarMatchSt(String nombreArchivo) {
        File archivo;
        FileReader fr;
        BufferedReader br;
        try {
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

                    contenido = lineasArch.split(";");
                    for (int i = 0; i < contenido.length; i++) {
                        contenido[i] = contenido[i].replaceAll("\"", "");
                    }
                    if (contenido.length == 49) {
                        String ht = contenido[0], at = contenido[1], hp1 = contenido[2], hp2 = contenido[3], hp3 = contenido[4], hp4 = contenido[5], hp5 = contenido[6], hp6 = contenido[7], hp7 = contenido[8], hp8 = contenido[9], hp9 = contenido[10], hp10 = contenido[11], hp11 = contenido[12], 
                                ap1 = contenido[13], ap2 = contenido[14], ap3 = contenido[15], ap4 = contenido[16], ap5 = contenido[16], ap6 = contenido[17], ap7 = contenido[18], ap8 = contenido[19], ap9 = contenido[20], ap10 = contenido[21], ap11 = contenido[22],
                                hp1pos = contenido[24], hp2pos = contenido[25], hp3pos = contenido[26], hp4pos = contenido[27], hp5pos = contenido[28], hp6pos = contenido[29], hp7pos = contenido[30], hp8pos = contenido[31], hp9pos = contenido[32], hp10pos = contenido[33], hp11pos = contenido[34],
                                ap1pos = contenido[35], ap2pos = contenido[36], ap3pos = contenido[37], ap4pos = contenido[38], ap5pos = contenido[39], ap6pos = contenido[40], ap7pos = contenido[41], ap8pos = contenido[42], ap9pos = contenido[43], ap10pos = contenido[44], ap11pos = contenido[45];
                        
                        
                        Nodo<Player> buscado1 = this.listaJugadores.buscar(hp1);
                        if (buscado1 != null) {buscado1.getDato().playerPositions.insertar(new Nodo(hp1pos,hp1pos));buscado1.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado2 = this.listaJugadores.buscar(hp2);
                        if (buscado2 != null) {buscado2.getDato().playerPositions.insertar(new Nodo(hp2pos,hp2pos));buscado2.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado3 = this.listaJugadores.buscar(hp3);
                        if (buscado3 != null) {buscado3.getDato().playerPositions.insertar(new Nodo(hp3pos,hp3pos));buscado3.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado4 = this.listaJugadores.buscar(hp4);
                        if (buscado4 != null) {buscado4.getDato().playerPositions.insertar(new Nodo(hp4pos,hp4pos));buscado4.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado5 = this.listaJugadores.buscar(hp5);
                        if (buscado5 != null) {buscado5.getDato().playerPositions.insertar(new Nodo(hp5pos,hp5pos));buscado5.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado6 = this.listaJugadores.buscar(hp6);
                        if (buscado6 != null) {buscado6.getDato().playerPositions.insertar(new Nodo(hp6pos,hp6pos));buscado6.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado7 = this.listaJugadores.buscar(hp7);
                        if (buscado7 != null) {buscado7.getDato().playerPositions.insertar(new Nodo(hp7pos,hp7pos));buscado7.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado8 = this.listaJugadores.buscar(hp8);
                        if (buscado8 != null) {buscado8.getDato().playerPositions.insertar(new Nodo(hp8pos,hp8pos));buscado8.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado9 = this.listaJugadores.buscar(hp9);
                        if (buscado9 != null) {buscado9.getDato().playerPositions.insertar(new Nodo(hp9pos,hp9pos));buscado9.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado10 = this.listaJugadores.buscar(hp10);
                        if (buscado10 != null) {buscado10.getDato().playerPositions.insertar(new Nodo(hp10pos,hp10pos));buscado10.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado11 = this.listaJugadores.buscar(hp11);
                        if (buscado11 != null) {buscado11.getDato().playerPositions.insertar(new Nodo(hp11pos,hp11pos));buscado11.getDato().playerTeams.insertar(this.listaEquipos.buscar(ht));}
                        Nodo<Player> buscado12 = this.listaJugadores.buscar(ap1);
                        if (buscado12 != null) {buscado12.getDato().playerPositions.insertar(new Nodo(ap1pos,ap1pos));buscado12.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado13 = this.listaJugadores.buscar(ap2);
                        if (buscado13 != null) {buscado13.getDato().playerPositions.insertar(new Nodo(ap2pos,ap2pos));buscado13.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado14 = this.listaJugadores.buscar(ap3);
                        if (buscado14 != null) {buscado14.getDato().playerPositions.insertar(new Nodo(ap3pos,ap3pos));buscado14.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado15 = this.listaJugadores.buscar(ap4);
                        if (buscado15 != null) {buscado15.getDato().playerPositions.insertar(new Nodo(ap4pos,ap4pos));buscado15.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado16 = this.listaJugadores.buscar(ap5);
                        if (buscado16 != null) {buscado16.getDato().playerPositions.insertar(new Nodo(ap5pos,ap5pos));buscado16.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado17 = this.listaJugadores.buscar(ap6);
                        if (buscado17 != null) {buscado17.getDato().playerPositions.insertar(new Nodo(ap6pos,ap6pos));buscado17.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado18 = this.listaJugadores.buscar(ap7);
                        if (buscado18 != null) {buscado18.getDato().playerPositions.insertar(new Nodo(ap7pos,ap7pos));buscado18.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado19 = this.listaJugadores.buscar(ap8);
                        if (buscado19 != null) {buscado19.getDato().playerPositions.insertar(new Nodo(ap8pos,ap8pos));buscado19.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado20 = this.listaJugadores.buscar(ap9);
                        if (buscado20 != null) {buscado20.getDato().playerPositions.insertar(new Nodo(ap9pos,ap9pos));buscado20.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado21 = this.listaJugadores.buscar(ap10);
                        if (buscado21 != null) {buscado21.getDato().playerPositions.insertar(new Nodo(ap10pos,ap10pos));buscado21.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                        Nodo<Player> buscado22 = this.listaJugadores.buscar(ap11);
                        if (buscado22 != null) {buscado22.getDato().playerPositions.insertar(new Nodo(ap11pos,ap11pos));buscado22.getDato().playerTeams.insertar(this.listaEquipos.buscar(at));}
                    }
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreArchivo);
        }

    }
    
    /**
     *
     * @param lista de jugadores
     * @return nodo con el jugador mas participativo
     */
    public Nodo<Player> getMostParticipativePlayer(Lista<Player> lista){
        
        Nodo<Player> actual = lista.getPrimero();
        Nodo<Player> mayor = lista.getPrimero();
        
        if (lista.esVacia()) {
            return null; 
        }
        while (actual != null) {
            if (actual.getDato().playerLeagueNSeason.cantElementos() >= mayor.getDato().playerLeagueNSeason.cantElementos()) {
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    
    /**
     *
     * @return nodo con el golero mas efectivo
     */
    public Nodo<Player> getMostEffectiveGoalkeeper(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            if (actual.getDato().tapadas >= mayor.getDato().tapadas) {
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el golero mas efectivo
     */
    public Nodo<Player> getMostEffectiveForward(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            if (actual.getDato().goalsToTeams.cantElementos() >= mayor.getDato().goalsToTeams.cantElementos()) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el ZD mas efectivo
     */
    public Nodo<Player> getMostEffectiveZD(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().foul <= mayor.getDato().foul && actual.getDato().playerPositions.masComun().equals("ZD")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @param number para saber cual zaguero central se quiere
     * @return nodo con el ZC mas efectivo
     */
    public Nodo<Player> getMostEffectiveZC(Integer number){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        if (number == 1){
            while (actual != null) {

                if (actual.getDato().foul <= mayor.getDato().foul && actual.getDato().playerPositions.masComun().equals("ZC")) {

                    mayor = actual;

                }
                actual = actual.getSiguiente();
            }
            return mayor.clonar();
    } else {
           while (actual != null) {
            
            if (actual.getDato().yellow <= mayor.getDato().yellow && actual.getDato().playerPositions.masComun().equals("ZC")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar(); 
        }
    }
    /**
     *
     * @return nodo con el ZI mas efectivo
     */
    public Nodo<Player> getMostEffectiveZI(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().penalty <= mayor.getDato().penalty && actual.getDato().playerPositions.masComun().equals("ZI")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el MD mas efectivo
     */
    public Nodo<Player> getMostEffectiveMD(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().attempt <= mayor.getDato().attempt && actual.getDato().playerPositions.masComun().equals("MD")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el MC mas efectivo
     */
    public Nodo<Player> getMostEffectiveMC(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().keyPass <= mayor.getDato().keyPass && actual.getDato().playerPositions.masComun().equals("MC")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el MI mas efectivo
     */
    public Nodo<Player> getMostEffectiveMI(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().keyPass <= mayor.getDato().keyPass && actual.getDato().playerPositions.masComun().equals("MI")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el DD mas efectivo
     */
    public Nodo<Player> getMostEffectiveDD(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().freeKickWon <= mayor.getDato().freeKickWon && actual.getDato().playerPositions.masComun().equals("DD")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el DC mas efectivo
     */
    public Nodo<Player> getMostEffectiveDC(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().goalsToTeams.cantElementos() <= mayor.getDato().goalsToTeams.cantElementos() && actual.getDato().playerPositions.masComun().equals("DC")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @return nodo con el DI mas efectivo
     */
    public Nodo<Player> getMostEffectiveDI(){
        Nodo<Player> actual = this.listaJugadores.getPrimero();
        Nodo<Player> mayor = this.listaJugadores.getPrimero();
        
        if (listaJugadores.esVacia()) {
            return null; 
        }
        while (actual != null) {
            
            if (actual.getDato().goalsToTeams.cantElementos() <= mayor.getDato().goalsToTeams.cantElementos() && actual.getDato().playerPositions.masComun().equals("DI")) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @param temporada temporada de la cual se quiere el equipo mas efectivo
     * @return nodo con el equipo mas efectivo
     */
    public Nodo<Team> getMostEffectiveTeam(Integer temporada){
        
        Nodo<Team> actual = this.listaEquipos.getPrimero();
        Nodo<Team> mayor = this.listaEquipos.getPrimero();
        
        if (listaEquipos.esVacia()) {
            return null; 
        }
        while (actual != null) {
            int oc1 = Collections.frequency(actual.getDato().golesHechosEnTemporada, temporada);
            int oc2 = Collections.frequency(mayor.getDato().golesHechosEnTemporada, temporada);
            
            if (oc1 >= oc2) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    /**
     *
     * @param temporada de la cual se quiere el equipo que mas goles recibio
     * @return nodo con el equipo que mas goles recibio
     */
    public Nodo<Team> getLeastEffectiveTeam(Integer temporada){
        
        Nodo<Team> actual = this.listaEquipos.getPrimero();
        Nodo<Team> mayor = this.listaEquipos.getPrimero();
        
        if (listaEquipos.esVacia()) {
            return null; 
        }
        while (actual != null) {
            int oc1 = Collections.frequency(actual.getDato().golesRecibidosEnTemporada, temporada);
            int oc2 = Collections.frequency(mayor.getDato().golesRecibidosEnTemporada, temporada);
            
            if (oc1 >= oc2) {
                
                mayor = actual;
                
            }
            actual = actual.getSiguiente();
        }
        return mayor.clonar();
    }
    
    /**
     *
     * @param name nombre del jugador a buscar
     * @return Nodo con el jugador buscado por su nombre
     */
    public Nodo<Player> buscarJugadorPorNombre(String name) {
        String nombre = name.toLowerCase();
        if (listaJugadores.esVacia()) {
            return null;
        } else {
            Nodo<Player> aux = listaJugadores.getPrimero();
            while (aux != null) {
                if (aux.getDato().getName().equals(nombre)) {
                    return aux.clonar();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    /**
     *
     * @param name nombre del equipo a buscar
     * @return nodo con el equipo a buscar
     */
    public Nodo<Team> buscarEquipoPorNombre(String name) {
        String nameLower = name.toLowerCase();
        if (listaEquipos.esVacia()) {
            return null;
        } else {
            Nodo<Team> aux = listaEquipos.getPrimero();
            while (aux != null) {
                if (aux.getDato().getName().toLowerCase().compareTo(nameLower) == 0) {
                    return aux.clonar();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    /**
     *
     * @param id id del partido que se quiere la liga y la temporada
     * @return String conteniendo los datos de la liga y la temporada
     */
    public String buscarPartidoLeagueSeason(String id) {
        String retorno;
        if (listaPartidos.esVacia()) {
            return null;
        } else {
            Nodo<Match> aux = listaPartidos.getPrimero();
            while (aux != null) {
                if (aux.getDato().getId().compareTo(id) == 0) {
                    retorno = "Liga: " + aux.getDato().getLeague() + "\n"
                            + "Temporada: " + aux.getDato().getSeason().toString();
                    return retorno;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    /**
     *
     * @param id del partido que se quiere obetener la liga
     * @return String con la liga del partido que se paso como parametro
     */
    public String buscarPartidoLeague(String id) {
        String retorno;
        if (listaPartidos.esVacia()) {
            return null;
        } else {
            Nodo<Match> aux = listaPartidos.getPrimero();
            while (aux != null) {
                if (aux.getDato().getId().compareTo(id) == 0) {
                    retorno = aux.getDato().getLeague();
                    return retorno;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
     
    /**
     *
     * @param id del partido que se quiere obtener la temporada
     * @return String con la liga del partido que se paso como parametro
     */
    public Integer buscarPartidoSeason(String id) {
        Integer retorno;
        if (listaPartidos.esVacia()) {
            return null;
        } else {
            Nodo<Match> aux = listaPartidos.getPrimero();
            while (aux != null) {
                if (aux.getDato().getId().compareTo(id) == 0) {
                    retorno = aux.getDato().getSeason();
                    return retorno;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    /**
     *
     * @param lista con los teams de un jugador
     */
    public void imprimirNombrePlayerTeams(Lista<Team> lista) {
        if (!lista.esVacia()) {
            Nodo<Team> temp = lista.getPrimero();
            while (temp != null) {
                System.out.println(temp.getDato().getName());
                temp = temp.getSiguiente();
            }
        }
    }
}
