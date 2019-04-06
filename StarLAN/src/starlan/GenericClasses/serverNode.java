/* This file describes a server and how it should react */
package starlan.GenericClasses;

/**
 *
 * @author mweya
 */
import starlan.misc.LinkedList;
public class serverNode extends Device {
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
        
        
}
