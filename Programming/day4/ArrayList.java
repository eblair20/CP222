// passes tests A B C D E G H 

import java.util.Scanner;

public class ArrayList<T> implements IList<T> {

  T[] array;
  int cur;
  int size;

  public ArrayList() {
    array = (T[])new Object[size];
    cur = 0;
    size = 0;
  }

   /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */
  public void insert(int idx, T v) {
    T[] new_array = (T[])new Object[array.length + 1];
    for (int i = 0; i < idx; i++) {
      new_array[i] = array[i];
    }
    for(int i = array.length; i > idx; i--) {
      new_array[i] = array[i - 1];
    }
    new_array[idx] = v;
    array = new_array;
    size++;
    cur = idx;
  }

   /**
   * Adds an item to the end of list. Called 'Add' in class, but more usually called
   * append in other libraries. Moves <i>current</i> to the end of the list.
   * @param v Item to add
   */
  public void append(T v) {
    T[] new_array = (T[])new Object[array.length + 1];
    for(int i=0; i<array.length; i++) {
        new_array[i] = array[i];
    }
    new_array[array.length] = v;
    array = new_array;

    cur = array.length;
    size++;
  }

   /**
   * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
   * the previous item in the list, if such element exists.
   */
  public void remove() {
    T[] new_array = (T[])new Object[array.length - 1];
    for(int i = cur; i < array.length - 1; i++) {
        new_array[i] = array[i + 1];
    }
    array = new_array;
    size--;
    cur = cur - 1;
  }

   /**
   * Removes the item at a specific index
   * @param idx index of item to remove
   */
  public void remove(int idx) {
    T[] new_array = (T[])new Object[array.length - 1];
    for (int i = 0; i < idx; i++) {
      new_array[i] = array[i];
    }
    for (int i = idx; i < array.length - 1; i++) {
      new_array[i] = array[i + 1];
    }
    array = new_array;
    size--;
    cur = idx;
  }

  // min for move - referenced class notes
  private int min(int init, int _final) {
      if(init > _final) {
        return _final;
      }
      return init;
  }
  // max for move
  private int max(int init, int _final) {
      if(init < _final) {
        return _final;
      }
      return init;
  }

 /**
  * Changes the location of an existing element in the list
  * @param sidx - The initial index for the element to move
  * @param didx - The final index for the element to move
  */
 public void move(int sidx, int didx) {
    T[] new_array = (T[])new Object[array.length];
    int _min = min(sidx,didx);
    int _max = max(sidx,didx);
    for(int i = 0; i < array.length; i++) {
        if(i < _min || i > _max) {
            new_array[i] = array[i];
        } else {
            if(i == didx) {
                new_array[i] = array[sidx];
            } else {
                array[i + 1] = array[i];
            }
        }
    }
    new_array = array;
  }

   /**
   * Fetches the value at the <i>current</i> index in the list.
   * @return the requested item
   */
  public T fetch() {
    if (cur < 0) {
      cur = 0;
      return array[cur];
    } else if (cur > array.length - 1) {
      cur = array.length - 1;
      return array[cur];
    }
    return array[cur];
  }

   /**
   * Fetches the value at a specific index in the list.
   * @param idx index of the item to return
   * @return the requested item
   */
  public T fetch(int idx) {
    if (idx < 0) {
      idx = 0;
    }
    if (idx > array.length - 1) {
      idx = array.length - 1;
    } else {
      cur = idx;
    }
    return array[cur];
  }

   /**
   * Advances the <i>current</i> index to the next index, if possible.
   */
  public void next() {
    if(cur != array.length) {
      cur++;
    } else {
      cur = array.length;
    }
  }

   /**
   * Advances the <i>current</i> index to the previous index, if possible.
   */
  public void prev() {
    if(cur != 0) {
      cur--;
    } else {
      cur = 0;
    }
  }

   /**
   * Advances the <i>current</i> to the tail element
   */
  public void jumpToTail() {
    cur = array.length - 1;
    array[cur] = array[array.length - 1];
  }

   /**
   * Advances the <i>current</i> to the head element
   */
  public void jumpToHead() {
    cur = 0;
    array[cur] = array[0];
  }

   /**
   * Returns the number of elements in the list
   */
  public int size() {
    return array.length;
  }
}
