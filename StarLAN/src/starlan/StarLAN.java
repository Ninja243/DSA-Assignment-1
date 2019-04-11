/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starlan;

import starlan.ErrorClasses.InvalidAddressException;
import starlan.GenericClasses.Packet;
import starlan.GenericClasses.Star;
import starlan.GenericClasses.clientNode;
import starlan.GenericClasses.serverNode;

/**
 *
 * @author mweya
 */
import starlan.misc.LinkedList;
public class StarLAN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testing();
        //lltest();
    }

    public static void lltest() {
        LinkedList list = new LinkedList("test");
        try {
            list.remove(0);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    public static void testing() {
        Star star = new Star();
        serverNode server = new serverNode("subnet1.server1");

        clientNode c1 = new clientNode();
        clientNode c2 = new clientNode();
        clientNode c3 = new clientNode();
        try {
            c1.setAddress("subnet1.client1");
            c2.setAddress("subnet1.client2");
            c3.setAddress("subnet1.client3");
        } catch (InvalidAddressException e) {System.err.println(e.toString());}

        server.add(c1);
        server.add(c2);
        server.add(c3);

        serverNode server2 = new serverNode("subnet2.server2");

        clientNode c12 = new clientNode();
        clientNode c22 = new clientNode();
        clientNode c32 = new clientNode();
        try {
            c12.setAddress("subnet2.client12");
            c22.setAddress("subnet2.client22");
            c32.setAddress("subnet2.client32");
        } catch (InvalidAddressException e) {
            System.err.println(e.toString());
        }

        server2.add(c12);
        server2.add(c22);
        server2.add(c32);

        star.insertNode(server);
        star.insertNode(server2);

//        Packet p = new Packet("subnet2.server2", "ICMP");
//        c1.sendPacket(p,server);

//        System.out.println(c1.getAddress());
        Packet pt = new Packet("subnet2.server2.client12", c1.getAddress(),"Hello from client1");
        c1.sendPacket(pt,server);
    }
    
}
