public class Graph<N,W> implements IGraph<N,W> {

  IList<Node<N>> nodes;
  IList<Edge<N,W>> edges;
  Node<N> current;

  public Graph() {
    nodes = new DoubleLinkList<Node<N>>();
    edges = new DoubleLinkList<Edge<N,W>>();
    current = null;
  }

  public INode<N>[] getNodeSet() {
    INode<N>[] temp_array = allNodes(nodes);
    for(int i = 0; i < temp_array.length; i++) {
    }
    return temp_array;
  }

  public INode<N>[] allNodes(IList<Node<N>> o) {
    INode<N>[] node_array = (Node<N>[])new Node[o.size()];
    for(int i = 0; i < o.size(); i++) {
      node_array[i] = nodes.fetch(i);
    }
    return node_array;
  }

  public IEdge<N,W>[] getEdgeSet() {
    IEdge<N,W>[] edge_array = allEdges(edges);
    for(int i = 0; i < edge_array.length; i++) {
    }
    return edge_array;
  }

  public IEdge<N,W>[] allEdges(IList<Edge<N,W>> o) {
    IEdge<N,W>[] edge_array = (Edge<N,W>[])new Edge[o.size()];
    for(int i = 0; i < o.size(); i++) {
      edge_array[i] = edges.fetch(i);
    }
    return edge_array;
  }

  public INode<N> addNode(N v) {
    Node<N> n = new Node<N>(v);
    INode<N>[] temp_array = allNodes(nodes);
    int counter = 0;
    for(int i = 0; i < temp_array.length; i++) {
      if(n.getValue() == temp_array[i].getValue()) {
        return null;
      } else {
        counter++;
      }
    }
    if(counter != temp_array.length) {
      return null;
    } else {
      current = n;
      nodes.append(n);
      return n;
    }
  }

  public void addEdge(INode<N> s, INode<N> d, W w) {
    Edge<N,W> n = new Edge<N,W>(s, d, w);
    IEdge<N,W>[] temp_array = allEdges(edges);
    int counter = 0;
    for(int i = 0; i < temp_array.length; i++) {
      if(n.equals(temp_array[i]) == true){
        counter++;
      } else {
      }
    }
    if (counter == 0) {
      edges.append(n);
    }
  }

  public IEdge<N,W>[] getEdgesFrom(INode<N> n) {
    //get all the edges that have the input node as their source
    IEdge<N,W>[] edge_array = allEdges(edges);
    int count = 0;
    for (int i = 0; i < edge_array.length; i++) {
      if (edge_array[i].getSource() == n) {
        count++;
      } else {
      }
    }
    int count2 = 0;
    IEdge<N,W>[] source = (IEdge<N,W>[])new Edge[count];
    for(int i = 0; i < edge_array.length; i++) {
      if (edge_array[i].getSource() == n) {
        source[count2] = edge_array[i];
        count2++;
      } else {
      }
    }
    return source;
  }

  public IEdge<N,W>[] getEdgesTo(INode<N> n) {
    //get all the edges that have the input node as their destination
    IEdge<N,W>[] edge_array = allEdges(edges);
    int count = 0;
    for (int i = 0; i < edge_array.length; i++) {
      if (edge_array[i].getDestination() == n) {
        count++;
      } else {
      }
    }
    int count2 = 0;
    IEdge<N,W>[] source = (IEdge<N,W>[])new Edge[count];
    for(int i = 0; i < edge_array.length; i++) {
      if (edge_array[i].getDestination() == n) {
        source[count2] = edge_array[i];
        count2++;
      } else {
      }
    }
    return source;
  }

  public INode<N>[] getNeighbors(INode<N> n) {
    IEdge<N,W>[] to_edges = getEdgesTo(n);
    IEdge<N,W>[] from_edges = getEdgesFrom(n);
    INode<N>[] neighbor_array = (Node<N>[])new Node[to_edges.length + from_edges.length];
    int counter = 0;
    for(int i = 0; i < to_edges.length; i++) {
      INode<N> to_neighbor_node = to_edges[i].getSource();
      neighbor_array[i] = to_neighbor_node;
      counter++;
    }
    int counter2 = 0;
    for(int j = counter - 1 ; j < counter + from_edges.length - 1; j++) {
      INode<N> from_neighbor_node = from_edges[counter2].getDestination();
      neighbor_array[j] = from_neighbor_node;
      counter2++;
    }
    return neighbor_array;
  }

}
