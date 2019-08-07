package introduccionjavaii_parte2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas astor
 */
public class IntroduccionJAVAII_PARTE2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MazoDeCartas unodeoro = new MazoDeCartas("Oro", 1);
        MazoDeCartas dosdeoro = new MazoDeCartas("Oro", 2);
        MazoDeCartas tresdeoro = new MazoDeCartas("Oro", 3);
        MazoDeCartas cuatrodeoro = new MazoDeCartas("Oro", 4);
        MazoDeCartas cincodeoro = new MazoDeCartas("Oro", 5);
        MazoDeCartas seisdeoro = new MazoDeCartas("Oro", 6);
        MazoDeCartas sietedeoro = new MazoDeCartas("Oro", 7);
        MazoDeCartas ochodeoro = new MazoDeCartas("Oro", 8);
        MazoDeCartas nuevedeoro = new MazoDeCartas("Oro", 9);
        MazoDeCartas diezdeoro = new MazoDeCartas("Oro", 10);
        MazoDeCartas oncedeoro = new MazoDeCartas("Oro", 11);
        MazoDeCartas docedeoro = new MazoDeCartas("Oro", 12);

        MazoDeCartas cartasDeOro[] = {unodeoro, dosdeoro, tresdeoro, cuatrodeoro, cincodeoro, seisdeoro,
            sietedeoro, ochodeoro, nuevedeoro, diezdeoro, oncedeoro, docedeoro};
        //int i = 0;
        for (int i = 0; i < 12; i++) {
            System.out.println(cartasDeOro[i].numero);
        }
    }

}
