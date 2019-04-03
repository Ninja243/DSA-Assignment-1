/* This file describes a generic device that can be connected to the network.  
    The model of the device should be set when it is created and it does not 
    seem to make sense to change it later, hence the lack of a set model method*/
package starlan.GenericClasses;

/**
 *
 * @author mweya
 */
import starlan.misc.Address;
import java.io.BufferedOutputStream;
import starlan.ErrorClasses.InvalidAddressException;
public class Device {
    private String address;
    private String model;
    //private BufferedOutputStream console = new BufferedOutputStream();
    
    public Device() {}
    
    public Device(String address) {
        this.address = address;
    }
    
    public Device(String address, String model) {
        this.address = address;
        this.model = model;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getModel() {
        return this.model;
    }
    
    public void setAddress(String address) throws InvalidAddressException {
        if (Address.isLegal(address)) {
            this.address = address;
        } else {
            throw new InvalidAddressException();
        }
    }
    
    @Override
    public String toString() {
        return model+" is at "+address+"\n";
    }
}
