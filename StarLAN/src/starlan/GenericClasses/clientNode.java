/* This class describes how a client should act */
package starlan.GenericClasses;

import starlan.ErrorClasses.InvalidAddressException;
import starlan.GenericClasses.Packet;
import starlan.GenericClasses.Device;
public class clientNode extends Device {
 private String[] protocols;

 public clientNode() {}

 public clientNode(String address) {
  try {
   super.setAddress(address);
  } catch (InvalidAddressException e) {
   System.err.println(e.toString());
  }
 }

 public boolean isProtocolValid(String prot) {
  // Confirm if :param:`prot` is within the permissible protocols
  for (int i = 0; i < protocols.length; i++) {
   if (protocols[i].equals(prot)) {
    return true;
   }
  }
  // No match has been found
  return false;
 }
}