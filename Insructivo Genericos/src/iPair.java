/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public interface iPair<K, V> {

    public K getKey();

    public V getValue();
    
     public void setKey(K key);

    public void setValue(V value);
}
