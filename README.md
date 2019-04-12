# DSA-Assignment-1
The first assignment we've gotten for DSA610S.

## Layout
Main class manages networks (Stars). The Star class contains server and client classes which should be able to communicate with one another.

### The Star
Represents the network. Should be able to:
*  Insert nodes (servers or clients)
      * The method should be called insertNode()
*  Delete nodes (servers or clients)
      * The method should be called deleteNode()

### The Servers
Represents nodes that forward messages (should have been called a router I think). Should be able to:
*  Forward messages to the right place
*  Find specific clients

### The Clients
Represents the nodes that send and recieve messages. Should be able to:
*  Send messages
*  Recieve messages
   *  Recieved messages should be printed to stdout by the client

## The Naming scheme
Servers and clients will need to be identified. The easiest way to do that would be by giving the nodes a name related to their subnet. For example, let's take a subnet called A, if we add a server to it, the server should be called A.A and if we add a client to that, the client should be called A.A.A . The actual names of the specific devices should refer to their generic type (server, client or other) and a unique identifier. 
Legal examples include:

*  intnet.server12.client
*  intnet.server12.server21.server3.client
*  intnet

## The links
The connections between the network devices can be done using a modified linked list, where a node would have an array of pointers that point to the devices it's connected to. For example, a server might have three clients connected to it, resulting in it having an array of length three which is filled with pointers to its clients. If a packet gets to a server and wants to go to a client that is not connected to the server, the packet should be dropped.

## Extra features to get those creativity points

### Packets
Messages can be sent in packets of a packet class. This way the nodes can acknowledge the reciept of the packets or even report back to the client if the node the packet is meant for cannot be reached. This will mean that a packet needs to have some kind of a unique identifier.

### Routing
Sent messages can have a header with the name of the rest of their journey, with the current node's name being removed from the header on receipt.

### Server types
The transmission methods do not have to be similar. Hubs can be simulated by having the server transmit the packets to everything it's connected to and trusting the clients to drop them or switches could be simulated by sending only one packet to the next node in the chain.

### Client protocols
Different protocols can be simulated by obfuscating the sent messages in specific ways that require support for a specific protocol to deobfuscate. For example a fictional protocol could be simulated by having the text of the message sent in reverse and only clients with support for the right function will be able to display the message correctly.

### Testing
To make sure that everything is working as intended, automated tests can be set up, making the network perform edge-case operations when this feature is run.

### Client types
Different clients can be simutated by only being able to connect to servers of a specific type. A desktop computer from the late 1980's probably won't be able to connect to a WiFi network without a lot of effort so we could set it up so that's not possible.

### Streams
All devices on the network should be able to write to their own output stream

### List of clients
Servers could use a list to store pointers to all the clients connected to them. A singly linked list should be fine as searching for the right client will be like searching through an unsorted array.
