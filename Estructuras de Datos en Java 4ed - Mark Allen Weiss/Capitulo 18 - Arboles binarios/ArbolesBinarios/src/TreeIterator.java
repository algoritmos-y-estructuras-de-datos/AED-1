
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 * @param <T>
 */
public abstract class TreeIterator <T> {
    protected BinaryTree<T> t;
    protected BinaryNode<T> current;
    public TreeIterator(BinaryTree<T> theTree){
        t = theTree;
        current = null;
    }
    //comprobar si la posicion actual hace referencia a un elemento valido del arbol
    public boolean isValid(){
        return current != null;
    }
    final public T retrieve(){
        if (current == null){
            throw new NoSuchElementException();
        }
        return current.element;
    }
    abstract public void advance();
}
