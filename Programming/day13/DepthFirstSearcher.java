public class DepthFirstSearcher<N extends Comparable<N>,W> implements ISearcher<N,W> {

  Stack<INode<N>> path_finder;
  IList<INode<N>> list;
  IList<INode<N>> new_list;
  IList<INode<N>> final_list;
  IGraph<N,W> graph;
  INode<N> start;
  INode<N> end;
  int path;
  boolean is_found;
  IDict<N,IEdge<N,W>> dictionary;


  public DepthFirstSearcher() {
    path_finder = new Stack<INode<N>>(100);
    graph = new Graph<N,W>();
    new_list = new DoubleLinkList<INode<N>>();
    list = new DoubleLinkList<INode<N>>();
    final_list = new DoubleLinkList<INode<N>>();
    start = null;
    end = null;
    graph = null;
    path = 0;
    is_found = false;
    dictionary = new Dict<N,IEdge<N,W>>();
  }

  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) throws UnderFlowException, OverFlowException {
    start = s;
    end = e;
    graph = g;
    if(start == end) {
      is_found = true;
      System.out.println("true");
      return is_found;
    }
    IEdge<N,W>[] edges = graph.getEdgesFrom(s);
    for(int i = 0; i < new_list.size(); i++) {
      if(new_list.fetch(i) == s) {
        return is_found;
      }
    }
    for(int i = 0; i < edges.length; i++) {
      new_list.append(s);
      dictionary.add(edges[i].getDestination().getValue(), edges[i]);
      is_found = pathExists(graph, edges[i].getDestination(), end);
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
    DepthFirstSearcher<String,Double> depth = new DepthFirstSearcher<String,Double>();
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
    depth.getPath(graph, start, end);

  }

}
