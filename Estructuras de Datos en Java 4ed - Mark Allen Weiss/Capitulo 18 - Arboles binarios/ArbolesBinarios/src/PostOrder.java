
import java.util.NoSuchElementException;
import java.util.Stack;

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
public class PostOrder <T> extends TreeIterator<T> {
    protected Stack<StNode<T>> s;

    @Override
    public void advance() {
        if (s.isEmpty()){
            if(current == null){
                throw new NoSuchElementException();
            }
            current = null;
            return;
        }
        StNode<T> cnode;
        for(;;){
            cnode = s.pop();
            if(++cnode.timesPopped == 3){
                current = cnode.node;
                return;
            }
            s.push(cnode);
            if(cnode.node.lt != null){
                s.push( new StNode<>(cnode.node.lt));
            }else{
                if (cnode.node.rt != null){
                    s.push(new StNode<>(cnode.node.rt));
                }
            }
        }
    }
    protected static class StNode<T>{
        BinaryNode<T> node;
        int timesPopped;
        public StNode(BinaryNode<T> n){
            node = n;
            timesPopped = 0;
        }
    }
    public PostOrder(BinaryTree<T> theTree) {
        super(theTree);
        s = new Stack<StNode<T>>();
        s.push(new StNode<>(t.getRoot()));
    }
    public void first(){
        s.clear();
        if( t.getRoot() != null){
            s.push(new StNode<>(t.getRoot()));
            advance();
        }
    }
    
}
