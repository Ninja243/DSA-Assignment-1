/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starlan.GenericClasses;

/**
 *
 * @author mweya
 */
import starlan.GenericClasses.Packet;
import starlan.GenericClasses.Device;
public class Client extends Device {
    private String[] protocols;
    
    public Client() {}
    
    public void recievePacket(Packet p) {
        // Check the header to see if we are the right client
        // If not, drop it

        // Split destination address
        // Use \\. since . means something else in regular expressions
        String[] splitAddress = p.getDestination().split("\\.");

        if(splitAddress[splitAddress.length - 1].equals(p.getDestination())){
            // Match :-)
        }else{
            // dropped
        }
        
    }

    public void sendPacket(){

    }

    public boolean isProtocolValid(String prot){
        // Confirm if :param:`prot` is within the permissible protocols
        for (int i = 0; i < protocols.length; i++) {
            if (protocols[i].equals(prot)){
                return true;
            }
        }
        // No match has been found
        return false;
    }
}
