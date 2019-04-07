/* This file describes a server and how it should react */
package starlan.GenericClasses;

/**
 *
 * @author mweya
 */
import starlan.misc.LinkedList;
public class serverNode<AnyType> extends Device {
        private LinkedList clients = new LinkedList<>();
        private String type = null;
        
        public serverNode() {}
        
        public serverNode(String type) {
            this.type = type;
        }
        
        public serverNode(String type, LinkedList clients) {
            this.type = type;
            this.clients = clients;
        }
        
        @Override
        public void recievePacket(Packet packet) {
            String whereto = packet.getDestination();
            if (packet.getDestination().equals(this.getAddress())) {
                // If we're where it needs to be, handle it
                handleData((AnyType) packet.getData(), packet.getSource());
            } else {
                // If we aren't the final destination, send the packet onwards
                
            }
        }
}
