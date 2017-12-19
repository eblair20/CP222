You should copy in your graph implementation from day11 including the DiGraphReader. You will use your graph implementation to support implementing two different path finding algorithms. DepthFirstSearcher will implement a depth first graph search and conform to the ISearcher interface. BreadthFirstSearcher will implement a breadth first graph search and conform to the ISearcher interface.

We will test your searcher implementations with several graph files. Sometimes a path will exist from the starting node to the target node, sometimes there will not be a path.

You should feel free to use any data structures you have implemented earlier in the block when implementing your searchers.

Files:
IGraph.java        - An interface for a graph implementation
INode.java         - An interface for nodes used by IGraph instances
IEdge.java         - An interface for edges used by IGraph instances
IGraphReader.java  - An interface for reading in graph files
DiGraphReader.java - This file isn't included, please include your day11 implementation
ISearcher.java     - An interface for classes that provide graph searches.
graphfile.cs2      - A simple graph file for a basic test
DiGraphReader.java - Implementation of IGraphReader
graphfile.cs2 - A sample graph file containing 3 nodes and 3 edges
Edge.java - Implements IEdge.java interface to create an edge
Node.java - Implements INode.java interface to create a node
Graph.java - Implements IGraph.java interface 
DoubleLinkList.java - Creates a doubly linked list
DLink.java - Implements IDLink.java interface
IDLink.java - An interface for creating links in the doubly linked list
IList.java - Interface for the methods for DoubleLinkList.java
IQueue.java - Interface for a queue implementation
Queue.java - Queue implementations backed by an array
IDict.java - Interfact for a dictionary implementation
Dict.java - Used to store keys and values for nodes and edges that allows for a path in the search implementations to be found
DepthFirstSearcher.java - Implements ISearcher.java and finds a path from one node to another based on the order that nodes are added 
BreadthFirstSearcher.java - Implements ISearcher.java and find shortest path from one node to another
