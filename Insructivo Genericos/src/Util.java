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

    public static <K, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {

        return p1.getKey().equals(p2.getKey())
                && p1.getValue().equals(p2.getValue());
    }
    
    
}
