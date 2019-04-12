/* This class describes a Node which stores information  */
package starlan.misc;

public class Node<AnyType> {
    private Node next = null;
    private Node prev = null;
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
    
    public Node getPrev() {
        return this.prev;
    }
    
    public void setPrev(Node prev) {
        this.prev = prev;
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
