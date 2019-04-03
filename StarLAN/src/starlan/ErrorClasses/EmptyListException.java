/* This error is thrown when operations that require nodes to be inside the accessed linked list are performed on an empty list */
package starlan.ErrorClasses;

/**
 *
 * @author mweya
 */
public class EmptyListException extends Exception {
    public EmptyListException() {
        super("The list you've tried to access is empty");
    }
    
    public EmptyListException(String message) {
        super(message);
    }
}
