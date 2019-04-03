/* These classes define the linked list which stores information */
package starlan.misc;

/**
 *
 * @author mweya
 */
public class LinkedList<AnyType> {
    private Node<AnyType> head = null;
    
    public LinkedList() {}
    
    public LinkedList(Node head) {
        this.head = head;
    }
    
    public LinkedList(AnyType data) {
        this.head = new Node<AnyType>(data);
    }
    
    public void add(AnyType data) {
        Node toadd = new Node<AnyType>(data);
        add(toadd);
    }
    
    public void  add(Node toadd) {
        if (head == null) {
            this.head = toadd;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(toadd);
        }
    }
    
    
}