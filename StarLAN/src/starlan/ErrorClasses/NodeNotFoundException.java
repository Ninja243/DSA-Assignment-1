/* This exception is thrown when the node searched for has not been found */
package starlan.ErrorClasses;

/**
 *
 * @author mweya
 */
import starlan.misc.Node;
public class NodeNotFoundException extends Exception {
    public NodeNotFoundException() {
        super("The node was not found");
    }
    
    public NodeNotFoundException(Node node) {
        super("The following node was not found:\n"+node.toString());
    }
    
    public NodeNotFoundException(String message) {
        super(message);
    }
}
