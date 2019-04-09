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
public class StarLAN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testing();

    }

    public static void testing() {
        Star star = new Star();
        serverNode server = new serverNode("server1","subnet1");

        clientNode c1 = new clientNode();
        clientNode c2 = new clientNode();
        clientNode c3 = new clientNode();
        try {
            c1.setAddress("client1");
            c1.setSubnetName("subnet1");
            c2.setAddress("client2");
            c3.setAddress("client3");
        } catch (InvalidAddressException e) {}

        server.add(c1);
        server.add(c2);
        server.add(c3);

        serverNode server2 = new serverNode("server2", "subnet2");

        clientNode c12 = new clientNode();
        clientNode c22 = new clientNode();
        clientNode c32 = new clientNode();
        try {
            c12.setAddress("client12");
            c22.setAddress("client22");
            c32.setAddress("client32");
        } catch (InvalidAddressException e) {}

        server.add(c12);
        server.add(c22);
        server.add(c32);

        star.insertNode(server);
        star.insertNode(server2);

//        Packet p = new Packet("subnet2.server2", "ICMP");
//        c1.sendPacket(p,server);

        Packet pt = new Packet("subnet2.server2", c1.getSubnetName()+"."+c1.getAddress(),"ICMP");
        c1.sendPacket(pt,server);
    }
    
}
