package starlan.GenericClasses;

import starlan.SpecificClasses.PacketHeader;
import starlan.ErrorClasses.ObjectNotCreatedException;
public class Packet < AnyType > {
 private AnyType data = null;
 private PacketHeader header = null;

 public Packet() {

 }

 // Sending a device a packet with no data should result in ping like behaviour.
 // This will be handled in the host class
 public Packet(String destination) {
  header = new PacketHeader(destination);
 }

 public Packet(String destination, AnyType data) {
  header = new PacketHeader(destination);
  this.data = data;
 }

 public Packet(String destination, String source, AnyType data) {
  header = new PacketHeader(destination, source);
  this.data = data;
 }

 public void setDestination(String destination) throws ObjectNotCreatedException {
  if (header == null) {
   throw new ObjectNotCreatedException("Packet Header");
  } else {
   header.setDestination(destination);
  }
  header.setDestination(destination);
 }

 // No method to set data or the source, only get it as otherwise information can be more easily
 // forged.

 public String getDestination() {
  return header.getDestination();
 }

 public String getSource() {
  return header.getSource();
 }

 public AnyType getData() {
  return this.data;
 }

 public String getHeaderSubnet() {
  return header.getTheSubnet();
 }

 @Override
 public String toString() {
  return header.toString() + "\n" + this.data + "\n";
 }
}