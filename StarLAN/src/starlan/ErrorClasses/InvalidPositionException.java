/* This exception is thrown when an invalid position is supplied to a linked list */
package starlan.ErrorClasses;

/**
 *
 * @author mweya
 */
public class InvalidPositionException extends Exception {
    public InvalidPositionException() {
        super("The position you attempted to access does not exist in this list");
    }
    
        public InvalidPositionException(int position) {
        super("The position you attempted to access does not exist in this list (position supplied: "+position+")");
    }
    
   public InvalidPositionException(String message) {
        super(message);
    }
}
