/* This file describes a server and how it should react */
package starlan.GenericClasses;

/**
 *
 * @author mweya
 */
import starlan.misc.LinkedList;
import starlan.GenericClasses.Device;
public class serverNode<AnyType> extends Device {
        // This is a linked list nested inside a linked list. 
        // It contains the client devices that would be connected to this server device
        private LinkedList clients = new LinkedList<>();
        // This string stores information about the kind of server we are.
        private String type = null;
        
        // This constructor does not supply the object created from this class with any additional information
        public serverNode() {}
        
        // This constructor supplies the object with information about it's type.
        // This should be the default constructor.
        public serverNode(String type) {
            this.type = type;
        }
        
        // This constructor supplies the object with information about the kind of server it is and a list of clients it
        // has connected to it.
        public serverNode(String type, LinkedList clients) {
            this.type = type;
            this.clients = clients;
        }
        
        // A wrapper for the add client method
        public void add(Device d) {
            addClient(d);
        }
        
        // This method adds a client to the list of clients this server is responsible for
        public void addClient(Device d) {
            this.clients.add(d);
        }
        
        // A wrapper for the removeClient method
        public void remove(int position) {
            removeClient(position);
        }
        
        // A wrapper for the removeClient method
        public void remove(Device d) {
            removeClient(d);
        }
        
        // Removes a client from a specific position in the list
        public void removeClient(int position) {
            try {
              this.clients.remove(position);  
            } catch (Exception e) {
                System.err.println(e.toString());
            } 
        }
        
        // Removes a specific client from the list
        public void removeClient(Device d) {
            try {
              this.clients.remove(d);  
            } catch (Exception e) {
                System.err.println(e.toString());
            } 
        }
        
        @Override
        public void receivePacket(Packet packet) {
            String whereto = packet.getDestination();
            if (packet.getDestination().equals(this.getAddress())) {
                // If we're where it needs to be, handle it
                handleData((AnyType) packet.getData(), packet.getSource());
            } else {
                // If we aren't the final destination, send the packet onwards
                
            }
        }
}
