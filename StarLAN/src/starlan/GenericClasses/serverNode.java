/* This file describes a server and how it should react */
package starlan.GenericClasses;

//import starlan.misc.LinkedList;

import starlan.ErrorClasses.InvalidAddressException;
import starlan.GenericClasses.Device;

import java.util.LinkedList;

import java.util.concurrent.ThreadLocalRandom;

public class serverNode<AnyType> extends Device {
    // This is a linked list nested inside a linked list.
    // It contains the client devices that would be connected to this server device
    private LinkedList<Device> clients = new LinkedList<>();
    // This string stores information about the kind of server we are.
    private String type = null;


    // This constructor does not supply the object created from this class with any additional information
    public serverNode() {
    }

    // This constructor supplies the object with information about it's type.
    // This should be the default constructor.
//    public serverNode(String type) {
//        this.type = type;
//    }

    public serverNode(String address) {
        try {
            super.setAddress(address);
        } catch (InvalidAddressException e) {
        }
    }


    // This constructor supplies the object with information about the kind of server it is and a list of clients it
    // has connected to it.
    public serverNode(String type, LinkedList clients) {
        this.type = type;
        this.clients = clients;
    }


    // A wrapper for the add client method
    public void add(Device d) {
        addClient(d);
    }

    // This method adds a client to the list of clients this server is responsible for
    public void addClient(Device d) {
        this.clients.add(d);
    }

    // A wrapper for the removeClient method
    public void remove(int position) {
        removeClient(position);
    }

    // A wrapper for the removeClient method
    public void remove(Device d) {
        removeClient(d);
    }

    // Removes a client from a specific position in the list
    public void removeClient(int position) {
        try {
            this.clients.remove(position);
            System.out.println("removing done");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    // Removes a specific client from the list
    public void removeClient(Device d) {
        try {
            this.clients.remove(d);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    @Override
    public void receivePacket(Packet packet) {
        String whereto = packet.getDestination();
        // Check if subnet is ours, else send to appropriate server of specifies subnet
        if (packet.getHeaderSubnet().equals(getSubnetName())) {
            // Is our subnet
            // Now find client and send to them. But first check if msg is meant for us
            if (packet.getDestination().equals(getAddress())) {
                // Handle pings
                if (packet.getData().equals("ICMP") && packet.getSource() != null) {
                    System.out.println(packet.getSource());
                    sendPacket(new Packet(packet.getSource(), "[+]ICMP REPLY[+]"), this);
                } else {
                    handleData((AnyType) packet.getData(), packet.getSource());
                }

            } else {
                // Find client then call :meth:`receivePacket`
                for (Device c : clients) {
                    /*
                    packet dst like this: subnet.server.clientx
                    since we're already under the correct subnet
                    let's just compare the client-end address
                    in the above example it would be 'clientx'
                     */

                    String[] tempArrayClientAddress = c.getAddress().split("\\.");
                    String[] tempArrayPacketDst = packet.getDestination().split("\\.");
                    //end address is last element of array
                    String cAddress = tempArrayClientAddress[tempArrayClientAddress.length - 1];
                    String pDst = tempArrayPacketDst[tempArrayPacketDst.length - 1];
                    if (cAddress.equals(pDst)) {
                        c.receivePacket(packet);
                        break;
                    }
                }
            }
        } else {
            // Send to proper subnet
            // This is sort of recursive in a way
            for (String tempSubName : Star._subnets.keySet()) {
                if (packet.getHeaderSubnet().equals(Star._subnets.get(tempSubName).getSubnetName())) {
                    // call receive on server with subnet in packet header
                    Star._subnets.get(packet.getHeaderSubnet()).receive(packet);
                }
            }
        }
    }
}
