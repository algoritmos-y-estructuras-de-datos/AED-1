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
public class BinaryTree <T> {
    private BinaryNode<T> root;
    public BinaryTree(T root){
        this.root = new BinaryNode<>(null,null,null);
    }
    public boolean isEmpty(){
        return root == null;
    }
    //Utiliza un elemento para crear la raiz y posiciona ambos arboles como arbol derecho e izquierdo
    public void merge(T elemtRoot, BinaryTree<T> t1, BinaryTree<T> t2){
        if (t1.root == t2.root && t1.root != null){
            throw new IllegalArgumentException();
        }
        root = new BinaryNode<>(elemtRoot,t1.root,t2.root);
        if (this != t1){
            t1.root = null;
        }
        if (this != t2){
            t2.root = null;
        }
    }
    public BinaryNode<T> getRoot(){
        return this.root;
    }
}
