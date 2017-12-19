public class BreadthFirstSearcher<N extends Comparable<N>,W> implements ISearcher<N,W> {

  Queue<INode<N>> path_finder;
  IList<INode<N>> new_list;
  IList<INode<N>> list;
  IList<INode<N>> final_list;
  boolean is_found;
  IDict<N,IEdge<N,W>> dictionary;

  public BreadthFirstSearcher() {
    path_finder = new Queue<INode<N>>(100);
    new_list = new DoubleLinkList<INode<N>>();
    list = new DoubleLinkList<INode<N>>();
    final_list = new DoubleLinkList<INode<N>>();
    is_found = false;
    dictionary = new Dict<N,IEdge<N,W>>();
  }

  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) throws UnderFlowException, OverFlowException {
    if(s == e) {
      is_found = true;
      return is_found;
    }
    IEdge<N,W>[] edges = g.getEdgesFrom(s);
    for(int i = 0; i < new_list.size(); i++) {
      if(new_list.fetch(i) == s) {
        return is_found;
      }
    }
    N[] nodes = dictionary.keys();
    for(int i = 0; i < edges.length; i++) {
      int m = 0;
      for(int j = 0; j < new_list.size(); j++) {
        if(dictionary.fetch(edges[i].getDestination().getValue()) != null) {
          m = 1;
        }
      }
      if(m == 1) {
        //do nothing
      } else {
        dictionary.add(edges[i].getDestination().getValue(), edges[i]);
      }
      path_finder.enqueue(edges[i].getDestination());
    }
    for(int i = 0; i < edges.length; i++) {
      if(path_finder.size() == 0) {
        return is_found;
      } else {
        new_list.append(s);
        is_found = pathExists(g, edges[i].getDestination(), e);
      }
    }
    return is_found;
  }

  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e) throws UnderFlowException, OverFlowException {
    dictionary.add(s.getValue(), null);
    list.append(e);
    if(pathExists(g, s, e) == true) {
      findPath(e, s);
      for(int i = list.size() - 1; i > -1; i--) {
        final_list.append(list.fetch(i));
      }
      for(int i = 0; i < final_list.size(); i++) {
        System.out.println(final_list.fetch(i).getValue());
      }
      return final_list;
    }
    return null;
  }

  public void findPath(INode<N> end, INode<N> start) {
    if(end == start){
      return;
    }
    IEdge<N,W> edges = dictionary.fetch(end.getValue());
    list.append(edges.getSource());
    findPath(edges.getSource(), start);
  }

  public static void main(String[] args) throws UnderFlowException, OverFlowException {
    IGraph<String,Double> graph = new Graph<String,Double>();
    BreadthFirstSearcher<String,Double> breadth = new BreadthFirstSearcher<String,Double>();
    INode<String> start = graph.addNode("start");
    INode<String> node1 = graph.addNode("node1");
    INode<String> node2 = graph.addNode("node2");
    INode<String> node3 = graph.addNode("node3");
    INode<String> node4 = graph.addNode("node4");
    INode<String> end = graph.addNode("end");
    graph.addEdge(start, node1, 1.0);
    graph.addEdge(node1, node3, -0.2);
    graph.addEdge(node1, node2, 5.5);
    graph.addEdge(node2, node3, 1.2);
    graph.addEdge(node3, end, 100.0);
    graph.addEdge(node1, node4, 10.0);
    breadth.getPath(graph, start, end);
  }

}
