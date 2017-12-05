public class DLink<T> implements IDLink<T> {

  T value;
  IDLink<T> next;
  IDLink<T> prev;

  public DLink(T v) {
    value = v;
  }
  /**
   * Gets the current value for this link cell
   * @return the value
   */
  public T getValue() {
    return value;
  }

  /**
   * Sets the current value for this link cell
   * @param v the value to place in this cell
   */
  public void setValue(T v) {
    value = v;
  }

  /**
   * Gets the next cell in the list
   * @return the cell
   */
  public IDLink<T> getNext() {
    return next;
  }

  /**
   * Gets the previous cell in the list
   * @return the cell
   */
  public IDLink<T> getPrev() {
    return prev;
  }

  /**
   * Sets the next cell in the list
   * @param c the next cell
   */
  public void setNext(IDLink<T> c) {
    next = c;
  }

  /**
   * Sets the next cell in the list
   * @param c the next cell
   */
  public void setPrev(IDLink<T> c) {
    prev = c;
  }

}
