
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static javafx.scene.input.KeyCode.T;

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
    public static void main(String[] args) throws IOException {
        //Carga claves
        File archivo;
        FileReader fr;
        BufferedReader br;
        archivo = new File("src/clavesPrueba.txt");
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        String lineasArch;
        TArbolBB retorno = new TArbolBB();
        while ((lineasArch = br.readLine()) != null) {
            String[] contenido;

            contenido = lineasArch.split(",");
            for (int i = 0; i < contenido.length; i++) {
                contenido[i] = contenido[i].replaceAll("\"", "");
            }
            if (contenido.length == 1) {

                TElementoAB inserto = new TElementoAB(contenido[0].trim());
                System.out.println(inserto.getEtiqueta());
                retorno.insertar(inserto);

            }
        }
        System.out.println(retorno.inOrden());
        System.out.println(retorno.preOrden());
        
    }

}
