/* This class describes a network and should be able to add and remove nodes.
    This behaviour sounds like the kind of behaviour a LinkedList would have so it would make
    sense to extend that class. */
package starlan.GenericClasses;

import starlan.misc.LinkedList;
import starlan.GenericClasses.Device;

import java.util.HashMap;
//import java.util.LinkedList;
import java.util.Map;

public class Star extends LinkedList {
 private String networkName;
 // To allow easy communication between the server nodes of different stars
 public static Map < String, Device > _subnets = new HashMap < String, Device > ();
 public Star() {}

 // For server nodes
 public void insertNode(serverNode toinsert) {
  _subnets.put(toinsert.getSubnetName(), toinsert);
  super.add(toinsert);
 }

 // For client nodes
 public void insertNode(clientNode toinsert) {
  super.add(toinsert);
 }

 public void removeNode(Device toremove) {
  try {
   super.remove(toremove);
   // Remove server from known subnets
   if (toremove instanceof serverNode) {
    _subnets.remove(toremove.getAddress());
   }
  } catch (Exception e) {
   //            e.printStackTrace();
   //            System.err.println(e.getLocalizedMessage());
  }
 }
}