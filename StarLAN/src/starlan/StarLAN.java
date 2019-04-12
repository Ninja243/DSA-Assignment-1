/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starlan;

import starlan.ErrorClasses.EmptyListException;
import starlan.ErrorClasses.InvalidAddressException;
import starlan.ErrorClasses.InvalidPositionException;
import starlan.ErrorClasses.NodeNotFoundException;
import starlan.GenericClasses.Packet;
import starlan.GenericClasses.Star;
import starlan.GenericClasses.clientNode;
import starlan.GenericClasses.serverNode;
import starlan.misc.LinkedList;

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
    // This instance of a scanner is used to handle user input
    static Scanner input = new Scanner(System.in);
    // This creates a new network for us to mess with
    static Star star = new Star();
    // Holds all servers for easy referencing to connected clients
    static ArrayList<serverNode> allServers = new ArrayList<>();

    static String mainOptions = ConsoleColors.CYAN + "Select an option\n" + ConsoleColors.RESET +
            ConsoleColors.YELLOW_BOLD + "1 create subnet\n" + ConsoleColors.RESET + // insertNode
            ConsoleColors.GREEN + "2 manage subnet\n" + ConsoleColors.RESET +
            ConsoleColors.PURPLE_BOLD + "3 delete subnet\n" + ConsoleColors.RESET +
            ConsoleColors.BLUE_BOLD + "4 display current subnets\n" + ConsoleColors.RESET +
            ConsoleColors.WHITE + "5 try out demo mode\n" + ConsoleColors.RESET +
            ConsoleColors.RED + "6 exit\n> " + ConsoleColors.RESET;
    static String manageOptions = ConsoleColors.CYAN + "1. Add clients\n" +
            "2. Remove client\n" +
            "3. Send message\n" +
            "4. Back" + ConsoleColors.RESET;

    public static Map<String, clientNode> clientsDict = new HashMap<String, clientNode>();

    public static void main(String[] args) {
//        testing();
        startScreen();
//        lltest();
    }

    // This is a method we used to test the linked list due to a null pointer exception we
    // got every once in a while.
    public static void lltest() {
        LinkedList list = new LinkedList("test");
        try {
            list.remove(0);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    // This method describes the demonstration feature that shows off some of
    // what this program can do. Most of this demonstration's code has been lifted
    // from the following methods that actually handle user input so for a more in 
    // depth explanation of how this works, have a look at the methods that follow
    // this one.
    // User input is simulated by pausing between printing statements to the screen.
    public static void demoMode() throws InterruptedException {
        String topBar = ConsoleColors.BLUE + "\n[Demo Mode] \n" + ConsoleColors.RESET;

        // This is a demo so let's  have it loop infinitely
        boolean demo = true;
        while (demo) {
            // Need some way to break out just in case
            /*if () {demo = false;}*/

            // Make a network
            System.out.println(topBar + ConsoleColors.YELLOW + "Build your network!\n" + ConsoleColors.RESET);
            Thread.sleep(2000);
            System.out.print(mainOptions);
            Thread.sleep(1400);
            System.out.println("1");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.CYAN + "Enter server full address\n" +
                    "E.g. subnetName.serverAddress" + ConsoleColors.RESET);
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "intnet.server1" + ConsoleColors.RESET);
            serverNode temp = new serverNode("intnet.server1");
            allServers.add(temp);
            star.insertNode(temp);
            Thread.sleep(2400);

            // Manage Network
            System.out.println("\n" + topBar + ConsoleColors.YELLOW + "Manage your very own networks!\n" + ConsoleColors.RESET);
            Thread.sleep(2000);
            System.out.print(mainOptions);
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "2" + ConsoleColors.RESET);
            Thread.sleep(1400);
            System.out.println("Enter subnet index");
            for (int i = 0; i < allServers.size(); i++) {
                System.out.println(i + " " + allServers.get(i).getSubnetName());
            }
            System.out.print("> ");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "0" + ConsoleColors.RESET);
            Thread.sleep(1400);
            System.out.println(manageOptions);
            System.out.print("> ");
            Thread.sleep(2400);

            // Add clients
            System.out.println("\n" + topBar + ConsoleColors.YELLOW + "Add clients to your subnet!\n" + ConsoleColors.RESET);
            System.out.println(manageOptions);
            System.out.print("> ");
            Thread.sleep(1400);
            System.out.println("1");
            Thread.sleep(1400);
            System.out.println("How many client(s)?");
            System.out.print("> ");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "4" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.PURPLE + "Enter client address [e.g. client1]: " + ConsoleColors.RESET);
            Thread.sleep(1400);
            String cAddress = temp.getSubnetName() + "." + "cl1";
            System.out.println(ConsoleColors.GREEN + "cl1" + ConsoleColors.RESET);
            clientNode tempClient = new clientNode(cAddress);
            // Add to respective data structures
            temp.add(tempClient);
            clientsDict.put(cAddress, tempClient);
            System.out.print(ConsoleColors.PURPLE + "Enter client address [e.g. client1]: " + ConsoleColors.RESET);
            Thread.sleep(1400);
            cAddress = temp.getSubnetName() + "." + "cl2";
            System.out.println(ConsoleColors.GREEN + "cl2" + ConsoleColors.RESET);
            tempClient = new clientNode(cAddress);
            // Add to respective data structures
            temp.add(tempClient);
            clientsDict.put(cAddress, tempClient);
            System.out.print(ConsoleColors.PURPLE + "Enter client address [e.g. client1]: " + ConsoleColors.RESET);
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "cl3" + ConsoleColors.RESET);
            cAddress = temp.getSubnetName() + "." + "cl3";
            tempClient = new clientNode(cAddress);
            // Add to respective data structures
            temp.add(tempClient);
            clientsDict.put(cAddress, tempClient);
            System.out.print(ConsoleColors.PURPLE + "Enter client address [e.g. client1]: " + ConsoleColors.RESET);
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "cl4" + ConsoleColors.RESET);
            cAddress = temp.getSubnetName() + "." + "cl4";
            tempClient = new clientNode(cAddress);
            // Add to respective data structures
            temp.add(tempClient);
            clientsDict.put(cAddress, tempClient);
            Thread.sleep(2400);

            // Remove clients
            System.out.println("\n" + topBar + ConsoleColors.YELLOW + "Remove unwanted clients!\n" + ConsoleColors.RESET);
            System.out.println(manageOptions);
            System.out.print("> ");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "2" + ConsoleColors.RESET);
            Thread.sleep(1400);
            if (clientsDict.size() > 0) {
                System.out.println("Enter client to remove");
                for (String key : clientsDict.keySet()) {
                    System.out.println(key);
                }
                System.out.print("> ");
                Thread.sleep(1400);
                System.out.println(ConsoleColors.GREEN + "cl3" + ConsoleColors.WHITE);
                Thread.sleep(1400);
                String clientToRemoveAddress = "cl3";
                Thread.sleep(1400);
                temp.remove(clientsDict.get(clientToRemoveAddress));
                clientsDict.remove(clientToRemoveAddress);
                System.out.println(ConsoleColors.RED + "Client removed" + ConsoleColors.RESET);
            }

            // Send messages same network
            System.out.println("\n" + topBar + ConsoleColors.YELLOW + "Send messages between clients!\n" + ConsoleColors.RESET);
            System.out.println(manageOptions);
            System.out.print("> ");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "3" + ConsoleColors.RESET);
            Thread.sleep(1400);
            System.out.print("From: ");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + temp.getSubnetName() + ".cl1" + ConsoleColors.RESET);
            String from = temp.getSubnetName() + ".cl1";
            Thread.sleep(1400);
            System.out.print("To: ");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + temp.getSubnetName() + ".cl4" + ConsoleColors.RESET);
            Thread.sleep(1400);
            String to = temp.getSubnetName() + ".cl4";
            System.out.print("Message: ");
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "Hello from client 1!" + ConsoleColors.GREEN);
            Thread.sleep(1400);
            String msg = "Hello from client 1!";
            // Retrieve client object from HashMap
            clientsDict.get(from).sendPacket(new Packet(to, from, msg), temp);
            Thread.sleep(2400);

            // Display subnets
            System.out.println("\n" + topBar + ConsoleColors.YELLOW + "Look at all your networks!\n" + ConsoleColors.RESET);
            System.out.print(mainOptions);
            Thread.sleep(1400);
            System.out.println(ConsoleColors.GREEN + "4" + ConsoleColors.RESET);
            Thread.sleep(1400);
            for (serverNode sub : allServers) {
                System.out.println(ConsoleColors.GREEN + sub.getSubnetName() + ConsoleColors.RESET);
            }
            Thread.sleep(2400);

            // Delete subnet
            System.out.println("\n" + topBar + ConsoleColors.RED + "Delete all your hard work!\n" + ConsoleColors.RESET);
            System.out.print(mainOptions);
            Thread.sleep(1400);
            System.out.println("3");
            Thread.sleep(1400);
            if (allServers.size() > 0) {
                System.out.println(ConsoleColors.RED + "[WARNING] Action cannot be reversed!" + ConsoleColors.RESET);
                for (int i = 0; i < allServers.size(); i++) {
                    System.out.println(i + " " + allServers.get(i).getAddress());
                }
                System.out.print("> ");
                Thread.sleep(1400);
                System.out.println(ConsoleColors.GREEN + "0" + ConsoleColors.RESET);
                Thread.sleep(1400);
                int index = 0;
                serverNode tempServerNode = allServers.get(index);
                try {
                    star.remove(star.search(tempServerNode));
                } catch (EmptyListException e) {
                    e.printStackTrace();
                } catch (InvalidPositionException e) {
                    e.printStackTrace();
                }
                allServers.remove(index);
                System.out.println(ConsoleColors.YELLOW + "[INFO] network removed" + ConsoleColors.RESET);
            }

            System.out.println(ConsoleColors.RED + "\nExiting demo...\n\n" + ConsoleColors.RESET);
            // End the demo after one iteration
            demo = false;
        }
    }

    // This method is responsible for displaying and handling the first menu the user sees
    public static void startScreen() {
        boolean shouldBreak = false;
        while (!shouldBreak) {
            System.out.print(mainOptions);
            try {
                // Reference
                // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
                int selection = Integer.parseInt(input.nextLine());
                switch (selection) {
                    case 1:
                        // create subnet
                        System.out.println(ConsoleColors.YELLOW + "Enter server full address\n" +
                                "E.g. subnetName.serverAddress" + ConsoleColors.RESET);
                        System.out.print("> ");
                        serverNode temp = new serverNode(input.nextLine());
                        allServers.add(temp);
                        // Create the subnet
                        star.insertNode(temp);
                        break;
                    case 2:
                        // manage subnet
                        System.out.println(ConsoleColors.PURPLE + "Enter subnet index" + ConsoleColors.RESET);
                        for (int i = 0; i < allServers.size(); i++) {
                            System.out.println(i + " " + ConsoleColors.BLUE + allServers.get(i).getSubnetName() + ConsoleColors.RESET);
                        }
                        System.out.print("> ");
                        manageSubnet(allServers.get(Integer.parseInt(input.nextLine())));
                        break;
                    case 3:
                        // delete subnet
                        if (allServers.size() > 0) {
                            System.out.println(ConsoleColors.RED + "[WARNING] Action cannot be reversed!" + ConsoleColors.RESET);
                            for (int i = 0; i < allServers.size(); i++) {
                                System.out.println(i + " " + ConsoleColors.BLUE + allServers.get(i).getAddress() + ConsoleColors.RESET);
                            }
                            System.out.print("> ");
                            int index = Integer.parseInt(input.nextLine());
                            serverNode tempServerNode = allServers.get(index);
                            try {
                                star.remove(star.search(tempServerNode));
                                allServers.remove(index);
                                System.out.println(ConsoleColors.YELLOW + "[INFO] remove successful" + ConsoleColors.RESET);
                            } catch (EmptyListException e) {
                                e.printStackTrace();
                            } catch (InvalidPositionException e) {
                                e.printStackTrace();
                            }
                        }

                        break;
                    case 4:
                        // List subnets
                        for (serverNode sub : allServers) {
                            System.out.println(ConsoleColors.BLUE + sub.getSubnetName() + ConsoleColors.RESET);
                        }
                        break;
                    case 5:
                        try {
                            demoMode();
                        } catch (InterruptedException e) {
                            System.err.println(e.toString());
                        }
                        break;
                    case 6:
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
    // This method is responsible for the menu the user sees when they 
    // try to manage a subnet and the handling thereof
    public static void manageSubnet(serverNode s) {
        boolean shouldBreak = false;
        while (!shouldBreak) {
            System.out.println(manageOptions);
            System.out.print("> ");
            try {
                int selection = Integer.parseInt(input.nextLine());
                switch (selection) {
                    case 1:
                        // Add client(s) to subnet
                        System.out.println(ConsoleColors.GREEN + "How many client(s)?" + ConsoleColors.RESET);
                        System.out.print("> ");
                        int num = Integer.parseInt(input.nextLine());
                        for (int i = 0; i < num; i++) {
                            System.out.print(ConsoleColors.PURPLE + "Enter client address [e.g. client1]: " + ConsoleColors.RESET);
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
                            System.out.println(ConsoleColors.GREEN + "Enter client to remove" + ConsoleColors.RESET);
                            for (String key : clientsDict.keySet()) {
                                System.out.println(key);
                            }
                            System.out.print("> ");
                            String clientToRemoveAddress = input.nextLine();
                            s.remove(clientsDict.get(clientToRemoveAddress));
                            clientsDict.remove(clientToRemoveAddress);
                            System.out.println(ConsoleColors.RED + "Client removed" + ConsoleColors.RESET);
                        }

                        break;
                    case 3:
                        // Send message
                        System.out.print(ConsoleColors.GREEN + "From: " + ConsoleColors.RESET);
                        String from = input.nextLine();
                        System.out.print(ConsoleColors.GREEN + "To: " + ConsoleColors.RESET);
                        String to = input.nextLine();
                        System.out.print(ConsoleColors.GREEN + "Message: " + ConsoleColors.RESET);
                        String msg = input.nextLine();
                        // Retrieve client object from HashMap
                        clientsDict.get(from).sendPacket(new Packet(to, from, msg), s);
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


    // This is a method we used to make sure that the underlying code worked properly
    // before implementing a menu.
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
            // :meth:`~LinkedList.remove(int)` works
            // :meth:`~LinkedList.remove(Node)` doesn't work right now
            // so use this temporary workaround
            star.remove(star.search(server));
            // Currently has a bug, use above as temporary workaround
//            star.remove(server);
        } catch (EmptyListException e) {
            e.printStackTrace();
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
    }

}
