/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starlan.misc;

/**
 *
 * @author mweya
 */
public class Node<AnyType> {
    private Node next = null;
    private AnyType data = null;
    
    public Node() {}
  
    public Node(AnyType data) {
        this.data = data;
    }
    
    public Node(AnyType data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public void setData(AnyType data) {
        this.data = data;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public AnyType getData() {
        return this.data;
    }
    
    @Override
    public String toString() {
        return "Node=("+data+",  "+next+" >)";
    }
    
}
