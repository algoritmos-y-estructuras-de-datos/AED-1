
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OnceIdeal once = new OnceIdeal();
        once.cargarTeams("Archivos/teams.csv");
        once.cargarJugador("Archivos/players.csv");
        once.cargarMatches("Archivos/matches.csv");
        once.cargarMatchSt("Archivos/match-standings.csv");
        once.cargarEvents("Archivos/events.csv");
        while (true) {
            System.out.println("1 - Calcular jugador mas participativo");
            System.out.println("2 - Calcular arquero mas efectivo");
            System.out.println("3 - Calcular delantero mas efectivo");
            System.out.println("4 - Calcular equipo mas goleador y mas goleado");
            System.out.println("5 - Todas las ligas de determinado jugador");
            System.out.println("6 - Calcular 11 ideal");
            System.out.println("0 - Salir");
            Scanner entradaEscaner = new Scanner(System.in);

            int opcion = entradaEscaner.nextInt();
            menu(opcion, once);
        }
    }

    public static void menu(int opcion, OnceIdeal once) {

        switch (opcion) {
            case 1:
                Nodo<Player> jugador = once.getMostParticipativePlayer(once.listaJugadores);
                System.out.println("El jugador mas participativo es: " + jugador.getDato().toString());
                break;
            case 2:
                Nodo<Player> golero = once.getMostEffectiveGoalkeeper();
                System.out.println("El golero mas efectivo es: " + golero.getDato().toString());
                break;
            case 3:
                Nodo<Player> delantero = once.getMostEffectiveForward();
                System.out.println("El delantero mas efectivo es: " + delantero.getDato().toString());
                break;
            case 4:
                System.out.println("Ingrese la temporada: ");
                Scanner temporada = new Scanner(System.in);
                String temp = temporada.nextLine();
                Nodo<Team> team1 = once.getMostEffectiveTeam(Integer.parseInt(temp));
                int oc1 = Collections.frequency(team1.getDato().golesHechosEnTemporada, Integer.parseInt(temp));
                Nodo<Team> team2 = once.getLeastEffectiveTeam(Integer.parseInt(temp));
                int oc2 = Collections.frequency(team2.getDato().golesHechosEnTemporada, Integer.parseInt(temp));
                System.out.println("El equipo mas goleador es: " + team1.getDato().name + " con " + oc1 + " goles");
                System.out.println("El equipo mas goleado es: " + team2.getDato().name + " con " + oc2 + " goles");
                break;
            case 5:
                System.out.println("Ingrese nombre del jugador: ");
                Scanner jugadorABuscar = new Scanner(System.in);
                String jug = jugadorABuscar.nextLine();
                Nodo<Player> playero = once.buscarJugadorPorNombre(jug);
                if (playero != null) {
                    System.out.println("Las ligas donde jugo " + jug + " son: ");
                    System.out.println(playero.getDato().playerLeagues.imprimir() + "\n");
                } else {
                    System.out.println("El jugador buscado no existe");
                }
                break;
            case 6:
                System.out.println("------ONCE IDEAL------");
                Nodo<Player> A = once.getMostEffectiveGoalkeeper();
                System.out.println("Arquero: " + A.getDato().toString(Boolean.TRUE));
                Nodo<Player> ZD = once.getMostEffectiveZD();
                System.out.println("-------------------------------------------------------");
                System.out.println("Zaguero Derecho: " + ZD.getDato().toString(Boolean.TRUE));
                Nodo<Player> ZC = once.getMostEffectiveZC(1);
                System.out.println("-------------------------------------------------------");
                System.out.println("Zaguero Central: " + ZC.getDato().toString(Boolean.TRUE));
                Nodo<Player> ZC2 = once.getMostEffectiveZC(2);
                System.out.println("-------------------------------------------------------");
                System.out.println("Zaguero Central 2: " + ZC2.getDato().toString(Boolean.TRUE));
                Nodo<Player> ZI = once.getMostEffectiveZI();
                System.out.println("-------------------------------------------------------");
                System.out.println("Zaguero Izquierdo: " + ZI.getDato().toString(Boolean.TRUE));
                Nodo<Player> MD = once.getMostEffectiveMD();
                System.out.println("-------------------------------------------------------");
                System.out.println("Mediocampista: " + MD.getDato().toString(Boolean.TRUE));
                Nodo<Player> MC = once.getMostEffectiveMC();
                System.out.println("-------------------------------------------------------");
                System.out.println("Mediocampista Central : " + MC.getDato().toString(Boolean.TRUE));
                Nodo<Player> MI = once.getMostEffectiveMI();
                System.out.println("-------------------------------------------------------");
                System.out.println("Mediocampista Izquierdo: " + MI.getDato().toString(Boolean.TRUE));
                Nodo<Player> DD = once.getMostEffectiveDD();
                System.out.println("-------------------------------------------------------");
                System.out.println("Delantero derecho: " + DD.getDato().toString(Boolean.TRUE));
                Nodo<Player> DC = once.getMostEffectiveDC();
                System.out.println("-------------------------------------------------------");
                System.out.println("Delantero central: " + DC.getDato().toString(Boolean.TRUE));
                Nodo<Player> DI = once.getMostEffectiveDI();
                System.out.println("-------------------------------------------------------");
                System.out.println("Delantero izquierdo: " + DI.getDato().toString(Boolean.TRUE));
                break;
            case 0:

                System.exit(0);
                ;
                break;

            default:
                System.out.println("Opcion invalida");
                ;
                break;
        }

        System.out.println("Entrada recibida por teclado es: \"" + opcion + "\"");
    }
}
