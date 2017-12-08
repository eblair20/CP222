public class TreeNode<K extends Comparable<K>,V> {

  K key;
  V value;
  TreeNode right;
  TreeNode left;

  public TreeNode(K k, V v) {
    key = k;
    value = v;
  }

  public boolean isLeaf() {
    if(left == null && right == null) {
      return true;
    }
      return false;
  }

  public void setLeft(TreeNode<K,V> l) {
    left = l;
  }

  public void setRight(TreeNode<K,V> r) {
    right = r;
  }

  public TreeNode<K,V> getLeft() {
    return left;
  }

  public TreeNode<K,V> getRight() {
    return right;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K k) {
    key = k;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V v) {
    value = v;
  }

}
