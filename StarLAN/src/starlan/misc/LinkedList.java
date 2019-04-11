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

    // Returns a position
    public int search(AnyType data) {
        // The list is not sorted so a linear search makes sense
        Node toSearch = new Node<AnyType>(data) ;
        return search(toSearch);
    }

    // Returns a position
    public int search(Node toSearch) {
        if (head == null) {
            return -1;
        } else {
            int position = 0;
            Node currentNode = head;
            while (currentNode != toSearch) {
                // Check if we're about to crash
                if (currentNode.getNext() == null) {
                    return -1;
                } else {
                    currentNode = currentNode.getNext();
                    position = position+1;
                }
            }
            // We can only get to this point if we found the node
            return position;
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


    @Override
    public String toString() {
        String out = "Linked List:\n";
        if (head == null) {
            out = out+"null";
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                out = out+currentNode.toString()+"\n";
                currentNode = currentNode.getNext();
            }
        }
        return out;
    }
}