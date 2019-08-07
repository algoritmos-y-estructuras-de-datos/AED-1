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
public class BinaryNode <T> {
    T element;
    BinaryNode<T> lt;
    BinaryNode<T> rt;
    public BinaryNode() {
        this(null, null, null);
    }
    public BinaryNode(T theElement,BinaryNode<T> lt,BinaryNode<T> rt ){
        element = theElement; this.lt = lt; this.rt = rt;
    }
    public static <T> int size(BinaryNode<T> t){
        if (t == null){
            return 0;
        }else{
            return 1 + size(t.lt) + size (t.rt);
        }
    }
    public static <T> int height(BinaryNode<T> t){
        return 0;
    }
    public BinaryNode<T> duplicate(){
        BinaryNode<T> root = new BinaryNode<>(element,null,null);
        if (lt != null){
            root.lt = lt.duplicate();
        }
        if (rt != null){
            root.rt = rt.duplicate();
        }
        return root;
    }

}
