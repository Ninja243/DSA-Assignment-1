/* This error class defines the error raised when an object that does not exist is attempted to be accessed */
package starlan.ErrorClasses;

/**
 *
 * @author mweya
 */
public class ObjectNotCreatedException extends Exception {
    public ObjectNotCreatedException() {
        super("The object attempted to be accessed does not exist");
    }
    
    public ObjectNotCreatedException(String object) {
        super("The object attempted to be accessed ("+object+") does not exist");
    }
    
    public ObjectNotCreatedException(String object, String method) {
        super("The object attempted to be accessed ("+object+") does not exist (induced by "+method+")");
    }
}
