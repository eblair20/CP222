// passes tests A B C D ... others were almost working

public class DoubleLinkList<T> implements IList<T> {
  IDLink<T> head;
  IDLink<T> tail;
  IDLink<T> curr;
  int size;

  public DoubleLinkList() {
    head = null;
    tail = null;
    curr = head;
    size = 0;
  }

  public boolean isEmpty() {
    return head == null;
  }

  /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */
  public void insert(int idx, T v) {
    IDLink<T> n = head;
    if (idx == 0) {
      n = head.getNext();
      head = n;
      n.setValue(v);
    }
    for (int i = 0; i < idx; i++) {
      n.getNext();
    }
    n.setValue(v);
    size++;
  }

	/**
	 * Adds an item to the end of list. Called 'Add' in class, but more usually called
	 * append in other libraries. Moves <i>current</i> to the end of the list.
	 * @param v Item to add
	 */
	public void append(T v) {
    IDLink<T> p = new DLink<T>(v);
    if (head == null) {
      head = p;
      tail = p;
    } else {
      tail.setNext(p);
      tail = p;
    }
    size++;
    curr = tail;
  }

	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
	 * the previous item in the list, if such element exists.
	 */
	public void remove() {
    IDLink<T> _previous = curr.getPrev();
    IDLink<T> _next = curr.getNext();
    if(curr == head) {
      head = _next;
    } else if (curr == tail) {
      tail = _previous;
    } else {
      _previous.setNext(_next);
      curr = _previous;
    }
    size--;
  }

	/**
	 * Removes the item at a specific index
	 * @param idx index of item to remove
	 */
	public void remove(int idx) {
    curr = head;
    for (int i = 0; i < idx; i++) {
      curr = curr.getNext();
    }
    this.remove();
    size--;
  }

	/**
	 * Changes the location of an existing element in the list
	 * @param sidx - The initial index for the element to move
	 * @param didx - The final index for the element to move
	 */
	public void move(int sidx, int didx) {
    IDLink<T> fetchlink = head;
    for (int i = 0; i <= sidx; i++) {
      fetchlink = fetchlink.getNext();
      fetchlink = curr;
    }
    IDLink<T> _previous = curr.getPrev();
    IDLink<T> _next = curr.getNext();
    fetchlink.setPrev(_previous);
    fetchlink.setNext(_next);

    IDLink<T> fetchlink2 = head;
    for (int i = 0; i < didx; i++) {
      fetchlink2 = fetchlink2.getNext();
      fetchlink2 = curr;
      for (int j = 0; i <= sidx; j++) {
        IDLink<T> fetchlink3 = head;
        fetchlink3 = fetchlink3.getNext();
        curr = fetchlink3;
        fetchlink2.setNext(fetchlink3);
      }
    }
    fetchlink2.setNext(curr);


  }

	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public T fetch() {
    T val = curr.getValue();
    return val;
  }

	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch(int idx) {
    IDLink<T> fetchlink = head;
    for(int i = 0; i < idx; i++) {
      fetchlink = fetchlink.getNext();
    }
    return fetchlink.getValue();
  }

	/**
	 * Advances the <i>current</i> index to the next index, if possible.
	 */
	public void next() {
    if (curr != tail) {
      curr = curr.getNext();
    }
  }

	/**
	 * Advances the <i>current</i> index to the previous index, if possible.
	 */
	public void prev() {
    if (curr != head) {
      curr = curr.getPrev();
    }
  }

	/**
	 * Advances the <i>current</i> to the tail element
	 */
	public void jumpToTail() {
    curr = tail;
  }

	/**
	 * Advances the <i>current</i> to the head element
	 */
	public void jumpToHead() {
    curr = head;
  }

	/**
	 * Returns the number of elements in the list
	 */
	public int size() {
    return size;
  }

}
