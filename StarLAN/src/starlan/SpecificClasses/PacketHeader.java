/* This file describes how the packet's header should act. No methods for editing the packet's source should be implemented to make it harder to forge packets. */
package starlan.SpecificClasses;

public class PacketHeader {
        private String destination = null;
        private String source = null;
        private String headerSubnet;
        public PacketHeader() {

        }
        
        public PacketHeader(String destination) {
            this.destination = destination;
            headerSubnet = destination.split("\\.")[0];
        }
        
        public PacketHeader(String destination, String source) {
            this.destination = destination;
            headerSubnet = destination.split("\\.")[0];
            this.source = source;
        }


        public String getDestination() {
            return this.destination;
        }
        
        public String getSource() {
            return this.source;
        }
        
        public String getTheSubnet(){
            return headerSubnet;
        }
        public void setDestination(String destination) {
            this.destination = destination;
        }

        
        @Override
        public String toString() {
            return source+" -> "+destination;
        }
}
