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
public class clientNode extends Device {
    private String[] protocols;
    
    public clientNode() {}
    
    public void RecievePacket(Packet p) {
        // Check the header to see if we are the right client
        // If not, drop it
        
        
    }
}
