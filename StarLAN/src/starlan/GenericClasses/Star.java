/* This class describes a network and should be able to add and remove nodes.
    This behaviour sounds like the kind of behaviour a LinkedList would have so it would make
    sense to extend that class. */
package starlan.GenericClasses;

/**
 *
 * @author mweya
 */
import starlan.misc.LinkedList;
import starlan.GenericClasses.Device;
public class Star extends LinkedList {
    private String networkName;
    
    public Star() {}
    
    public void insertNode(Device toinsert) {
        super.add(toinsert);
    }
    
    public void removeNode(Device toremove) {
        try {
            super.remove(toremove);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
