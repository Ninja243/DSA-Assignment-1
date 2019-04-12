/* This error class defines the error raised when an invalid address is parsed */
package starlan.ErrorClasses;

public class InvalidAddressException extends Exception {
    public InvalidAddressException() {
        super("The address recieved is invalid");
    }
    
    public InvalidAddressException(String address) {
        super("The address ("+address+") recieved is invalid");
    }
    
    public InvalidAddressException(String address, String message) {
        super(message+" ("+address+")");
    }
}
