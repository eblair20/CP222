public class DLink2<K extends Comparable<K>,V> implements IDLink2<K,V> {

  V value;
  K key;
  IDLink2<K,V> next;
  IDLink2<K,V> prev;

  public DLink2(K k, V v, IDLink2<K,V> n, IDLink2<K,V> p) {
    value = v;
    key = k;
    next = n;
    prev = p;
  }
  /**
   * Gets the current value for this link cell
   * @return the value
   */
  public V getValue() {
    return value;
  }

  /**
   * Sets the current value for this link cell
   * @param v the value to place in this cell
   */
  public void setValue(V v) {
    value = v;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K k) {
    key = k;
  }

  /**
   * Gets the next cell in the list
   * @return the cell
   */
  public IDLink2<K,V> getNext() {
    return next;
  }

  /**
   * Gets the previous cell in the list
   * @return the cell
   */
  public IDLink2<K,V> getPrev() {
    return prev;
  }

  /**
   * Sets the next cell in the list
   * @param c the next cell
   */
  public void setNext(IDLink2<K,V> c) {
    next = c;
  }

  /**
   * Sets the next cell in the list
   * @param c the next cell
   */
  public void setPrev(IDLink2<K,V> c) {
    prev = c;
  }

}
