# DSA-Assignment-1
The first assignment I've gotten for DSA610S.

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




