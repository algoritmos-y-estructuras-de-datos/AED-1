/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class Util {

    public static void imprimirMatriz(int[][] matriz) {
        int max;
        String espacios;

        // Primero obtengo número más grande
        max = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > max) {
                    max = matriz[i][j];
                }
            }
        }

        // Recorro matriz y voy imprimiendo, agregando
        // la cantidad de espacios correspondiente
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(generarEspacios(numeroDeDigitos(max) - numeroDeDigitos(matriz[i][j])) + matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Retorna número de dígitos de un entero
     *
     * @param numero entero
     * @return número de dígitos
     */
    private static int numeroDeDigitos(int numero) {
        return String.valueOf(numero).length();
    }

    /**
     * Genera espacios según cantidad recibida
     *
     * @param cantidad cantidad a generar
     * @return cadena de espacios
     */
    private static String generarEspacios(int cantidad) {
        String espacios = "";
        for (int i = 0; i < cantidad; i++) {
            espacios += " ";
        }
        return espacios;
    }
}
