/* This file contains methods that handle Addresses */
package starlan.MiscMethods;

/**
 *
 * @author mweya
 */
public class Address {
    public static boolean isLegal(String address) {
        if (address.contains("..")) {
            return false;
        }
        if (address.contains(". ")) {
            return false;
        }
        if (address.contains(" .")) {
            return false;
        }
        // If nothing else has returned false, we're golden
        return true;
    }
}
