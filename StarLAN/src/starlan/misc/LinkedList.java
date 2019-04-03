/* These classes define the linked list which stores information */
package starlan.misc;

/**
 *
 * @author mweya
 */
import starlan.ErrorClasses.EmptyListException;
import starlan.ErrorClasses.InvalidPositionException;
import starlan.ErrorClasses.NodeNotFoundException;
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
    
    public void remove(int position) throws EmptyListException, InvalidPositionException {
        if (head == null) {
                throw new EmptyListException();
          } else {
                int j = 0;
                Node currentNode = head;
                while (j<position-1) {
                    // Break out of loop before crash
                    if (currentNode.getNext() == null) {
                        throw new InvalidPositionException();
                        //break;
                    } else {
                        currentNode = currentNode.getNext();
                    }
                   j = j+1; 
                }
                // We stopped at the node before the node we need to remove
                // Therefore we can "delete" the next node by setting this node's next
                // to the one after the next one.
                if (currentNode.getNext().getNext() != null) {
                    currentNode.setNext(currentNode.getNext().getNext());
                } else {
                    currentNode.setNext(null);
                }
        }
    }
    
    public void remove(Node toremove) throws EmptyListException, NodeNotFoundException {
        if (head == null) {
            throw new EmptyListException();
        } else {
            int j = 0;
            Node currentNode = head;
            Node prevNode = null;
            while (toremove != currentNode) {
                // Catch crashes before they happen
                if (currentNode.getNext() == null) {
                    throw new NodeNotFoundException();
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.getNext();
                }
            } 
            // We can only get here if the node was found
            if (prevNode.getNext().getNext() == null) {
                prevNode.setNext(null);
            } else {
                prevNode.setNext(prevNode.getNext().getNext());
            }
        }
    }
    
}