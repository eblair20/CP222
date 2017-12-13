public class Edge<N,W> implements IEdge<N,W> {

  W weight;
  INode<N> source;
  INode<N> destination;


  public Edge(INode<N> s, INode d, W w) {
    weight = w;
    source = s;
    destination = d;
  }

  public INode<N> getSource() {
    return source;
  }

  public INode<N> getDestination() {
    return destination;
  }

  public W getWeight() {
    return weight;
  }

  public boolean equals(Object o) {
    try {
      IEdge<N,W> e = (IEdge<N,W>) o;
      if (e.getDestination().equals(this.getDestination()) && e.getSource().equals(this.getSource())) {
       return true;
      }
    }
    catch (Exception e) {
      System.out.println("ERROR: " + e);
    }
    return false;
  }

}
