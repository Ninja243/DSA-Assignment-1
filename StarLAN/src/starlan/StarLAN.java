/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starlan;

import starlan.ErrorClasses.EmptyListException;
import starlan.ErrorClasses.InvalidAddressException;
import starlan.ErrorClasses.InvalidPositionException;
import starlan.GenericClasses.Packet;
import starlan.GenericClasses.Star;
import starlan.GenericClasses.clientNode;
import starlan.GenericClasses.serverNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author mweya
 */
public class StarLAN {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static Star star = new Star();
    // Holds all servers for easy referencing
    static ArrayList<serverNode> allServers = new ArrayList<>();

    public static Map<String, clientNode> clientsDict = new HashMap<String, clientNode>();

    public static void main(String[] args) {
        testing();
//        startScreen();
    }

    public static void startScreen() {
        boolean shouldBreak = false;
        while (!shouldBreak) {
            System.out.print("Select an option\n" +
                    "1 create subnet\n" + // insertNode
                    "2 manage subnet\n" +
                    "3 delete subnet\n" +
                    "4 display current subnets\n" +
                    "5 exit\n> "); // removeNode
            try {
                // Reference
                // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
                int selection = Integer.parseInt(input.nextLine());
                switch (selection) {
                    case 1:
                        // create subnet
                        System.out.println("Enter server full address\n" +
                                "E.g. subnetName.serverAddress");
                        serverNode temp = new serverNode(input.nextLine());
                        allServers.add(temp);
                        // Create the subnet
                        star.insertNode(temp);
                        break;
                    case 2:
                        // manage subnet
                        System.out.println("Enter subnet index");
                        for (int i = 0; i < allServers.size(); i++) {
                            System.out.println(i + " " + allServers.get(i).getSubnetName());
                        }
                        System.out.print("> ");
                        manageSubnet(allServers.get(Integer.parseInt(input.nextLine())));
                    case 3:
                        // delete subnet
                        if (allServers.size() > 0) {
                            System.out.println("[WARNING] Action cannot be reversed!");
                            for (int i = 0; i < allServers.size(); i++) {
                                System.out.println(i + " " + allServers.get(i).getAddress());
                            }
                            System.out.print("> ");
                            int index = Integer.parseInt(input.nextLine());
                            serverNode tempServerNode = allServers.get(index);
                            System.out.println("adddddddrrrrrrr "+tempServerNode.getAddress());
                            star.removeNode(tempServerNode);
                            allServers.remove(index);
                        }

                        break;
                    case 4:
                        // List subnets
                        for (serverNode sub : allServers) {
                            System.out.println(sub.getSubnetName());
                        }
                        break;
                    case 5:
                        shouldBreak = true;
                        break;
                    default:
                        System.err.println("unknown option");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    // To manage a subnet

    /**
     * Optionalities:
     * add client
     * remove client
     * send msg
     *
     * @param s: main server of subnet
     */
    public static void manageSubnet(serverNode s) {
        boolean shouldBreak = false;
        while (!shouldBreak) {
            System.out.println("1. Add clients\n" +
                    "2. Remove client\n" +
                    "3. Send message\n" +
                    "4. Back");
            System.out.print("> ");
            try {
                int selection = Integer.parseInt(input.nextLine());
                switch (selection) {
                    case 1:
                        // Add client(s) to subnet
                        System.out.println("How many client(s)?");
                        System.out.print("> ");
                        int num = Integer.parseInt(input.nextLine());
                        for (int i = 0; i < num; i++) {
                            System.out.print("Enter client address [e.g. client1]: ");
                            String cAddress = s.getSubnetName() + "." + input.nextLine();
                            clientNode tempClient = new clientNode(cAddress);
                            // Add to respective data structures
                            s.add(tempClient);
                            clientsDict.put(cAddress, tempClient);
                        }
                        break;
                    case 2:
                        // Remove client from subnet
                        if (clientsDict.size() > 0) {
                            System.out.println("Enter client to remove");
                            for (String key : clientsDict.keySet()) {
                                System.out.println(key);
                            }
                            System.out.print("> ");
                            String clientToRemoveAddress = input.nextLine();
                            s.remove(clientsDict.get(clientToRemoveAddress));
                            clientsDict.remove(clientToRemoveAddress);
                            System.out.println("Client removed");
                        }

                        break;
                    case 3:
                        // Send message
                        System.out.print("From: ");
                        String from = input.nextLine();
                        System.out.print("To: ");
                        String to = input.nextLine();
                        System.out.print("Message: ");
                        String msg = input.nextLine();
                        // Retrieve client object from HashMap
                        clientsDict.get(from).sendPacket(new Packet(to, msg), s);
//                        fromClient.sendPacket(new Packet(to, from, msg), s);
                        break;
                    case 4:
                        shouldBreak = true;
                        break;
                    default:
                        System.err.println("unknown selection");
                        break;
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

    }


    public static void testing() {
        Star star = new Star();
        serverNode server = new serverNode("subnet1.server1");

        clientNode c1 = new clientNode("subnet1.client1");
        clientNode c2 = new clientNode();
        clientNode c3 = new clientNode();
        try {
//            c1.setAddress("subnet1.client1");
            c2.setAddress("subnet1.client2");
            c3.setAddress("subnet1.client3");
        } catch (InvalidAddressException e) {
            System.err.println(e.toString());
        }

        server.add(c1);
        server.add(c2);
        server.add(c3);

        serverNode server2 = new serverNode("subnet2.server2");

        clientNode c12 = new clientNode("subnet2.client12");
        clientNode c22 = new clientNode();
        clientNode c32 = new clientNode();
        try {
//            c12.setAddress("subnet2.client12");
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
        Packet pt = new Packet("subnet2.client12", c1.getAddress(), "Hello from client1");
        c1.sendPacket(pt, server);

        try {
            star.remove(star.search(server));
        } catch (EmptyListException e) {
            e.printStackTrace();
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
    }

}
