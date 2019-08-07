public class Util {
public static void imprimirMatriz(int [][] matriz) {
		System.out.println();
	
    for (int[] matriz1 : matriz) {
        for (int j = 0; j < matriz.length; j++) {
            System.out.print(matriz1[j] + " ");
        }
        System.out.println();
    }
}
}

	

