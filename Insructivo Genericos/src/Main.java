
import java.util.ArrayList;
import java.util.List;

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
        // Implementacion sin genericos
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);
        System.out.println(s);

        // Misma implementacion CON genericos
        List<String> list2 = new ArrayList<String>();
        list2.add("Hello");
        String s2 = list2.get(0); // No hay cast
        System.out.println(s2);

        // Implementacion Clase Box sin Genericos
        Box caja = new Box();
        caja.set("Prueba_Box_sin_genericos");
        System.out.println(caja.get());

        // Implementacion Box con Genericos
        BoxG<Box> cajaDeCajas = new BoxG<>();
        cajaDeCajas.set(caja);
        System.out.println(cajaDeCajas.get().get() + " imprimiendola desde una BoxG con genericos");

        // Implementacion de clase con multiples parametros de tipo
        iPair<String, Integer> p = new OrderedPair<>("String_p", 8);
        iPair<String, Integer> p2 = new OrderedPair<>("String_p2", 9);

        System.out.println(p.getKey());
        System.out.println(p.getValue());

        System.out.println(p2.getKey());
        System.out.println(p2.getValue());

        // Implementacion con tipos parametrizados
        iPair<String, BoxG<Integer>> p3 = new OrderedPair<>("String_p3", new BoxG<Integer>());
        // imprimo el numero guardado en el tipo del value
        p3.getValue().set(89);
        System.out.println(p3.getValue().get());

        // Implementacion metodos genericos
        OrderedPair<Integer, String> pp = new OrderedPair<>(1, "manzana");
        OrderedPair<Integer, String> pq = new OrderedPair<>(2, "pera");
        boolean same = Util.<Integer, String>compare(pp, pq);
        System.out.println(same + " con el tipo EXPLICITO");

        /* El tipo puede ser provisto de forma explicita como la sentencia de arriba pero normalmente se
         puede dejar para que el compilador infiera quie es lo que necesita como a continuacion
         */
        boolean sameInferido = Util.compare(pp, pq);
        System.out.println(sameInferido + " con el tipo INFERIDO por el compilador");

        // Implementacion parametros ligados/limitados
        BoxG<Integer> integerBox = new BoxG<Integer>();
        
        integerBox.set(new Integer(10));
        
        integerBox.inspect(12);
        //Si descomentamos esta sentencia se puede apreciar el error de compilacion
        //integerBox.inspect("some text"); // error: esto sigue siendo un String
        /*
        A su vez tambien pueden haber varios tipos ligados, declarandolos de la forma: class D<T extends A & B &C ...
        */

    }

}
