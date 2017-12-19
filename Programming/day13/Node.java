public class Node<N> implements INode<N> {

  N value;

  public Node(N n) {
    value = n;
  }

  public void setValue(N n) {
    value = n;
  }

  public N getValue() {
    return value;
  }

}
