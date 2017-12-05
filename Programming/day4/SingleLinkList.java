// passes tests A B C D 

public class SingleLinkList <T> implements IList<T> {

  ISLink<T> head; //first node
  ISLink<T> tail; //last node
  ISLink<T> curr; //current node
  int size;

  public SingleLinkList() {
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
    ISLink<T> n = new SLink<T>(v);
    curr = head;
    for (int i = 0; i < idx; i++) {
      curr = curr.getNext();
    }
    if (idx == 0) {
      n.setNext(head);
    } else {
      n.setValue(v);
    }
    size++;
  }

/**
 * Adds an item to the end of list. Called 'Add' in class, but more usually called
 * append in other libraries. Moves <i>current</i> to the end of the list.
 * @param v Item to add
 */
  public void append(T v) {
    ISLink<T> p = new SLink<T>(v);
    if (isEmpty()) {
      head = tail = p;
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
    curr.setNext(curr.getNext().getNext());
    size--;
  }

/**
 * Removes the item at a specific index
 * @param idx index of item to remove
 */
  public void remove(int idx) {
    if (idx == 0){
      head = head.getNext();
    }
    curr = head;
    for (int i = 0; i < idx; i++) {
      curr = curr.getNext();
    }
    this.remove();
  }

/**
 * Changes the location of an existing element in the list
 * @param sidx - The initial index for the element to move
 * @param didx - The final index for the element to move
 */
  public void move(int sidx, int didx) {
    ISLink<T> fetchlink = head;
    for (int i = 0; i <= sidx; i++) {
      fetchlink = fetchlink.getNext();
      fetchlink = curr;
    }
    fetchlink.setNext(curr.getNext());

    ISLink<T> fetchlink2 = head;
    for (int i = 0; i <= didx; i++) {
      fetchlink2 = fetchlink2.getNext();
      fetchlink2 = curr;
    }
    fetchlink2.setNext(fetchlink);
  }


/**
 * Fetches the value at the <i>current</i> index in the list.
 * @return the requested item
 */
  public T fetch() {
    return curr.getValue();
  }

/**
 * Fetches the value at a specific index in the list.
 * @param idx index of the item to return
 * @return the requested item
 */
  public T fetch(int idx) {
    ISLink<T> fetchlink = head;
    for(int i = 0; i < idx; i++) {
      fetchlink = fetchlink.getNext();
    }
    return fetchlink.getValue();
  }

/**
 * Advances the <i>current</i> index to the next index, if possible.
 */
  public void next() {
    if (curr == tail) {
      curr = tail;
    } else {
      curr = curr.getNext();
    }
  }

/**
 * Advances the <i>current</i> index to the previous index, if possible.
 */
  public void prev() {
    ISLink<T> get_prev = head;
    if (get_prev.getNext() == curr) {
      curr = get_prev;
    }
    if (curr == head) {
      get_prev = head;
    }
    curr = get_prev;
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
