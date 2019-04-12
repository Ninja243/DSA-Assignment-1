/* This error class defines the error raised when a client attempts to communicate with a client that does not support the protocol used */
package starlan.ErrorClasses;

public class UnsupportedProtocolException extends Exception {
    public UnsupportedProtocolException() {
        super("The protocol attempted to be used is not supported by the client");
    }
    
    public UnsupportedProtocolException(String protocol) {
        super("The protocol attempted to be used ("+protocol+" is not supported by the client");
    }
}
