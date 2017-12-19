/*
Referenced notes from class
*/

public class Stack<T> implements IStack<T> {

  //stack is first in last out

  T[] array;
  int array_size;
  int size;

  public Stack(int new_size) {
    array = (T[]) new Object[new_size];
    array_size = 0;
    size = 0;
  }

  /**
   * Pushes a new value onto the stack
   * @param v the value to push
   */
  public void push(T v) throws OverFlowException {
    if(array_size == array.length) {
      throw new OverFlowException();
    }
    array[array_size++] = v;
    size++;
  }

  /**
   * Pops the top value from the stack
   * @return the value
   */
  public T pop() throws UnderFlowException {
    if(array_size == 0) {
      throw new UnderFlowException();
    }
    T r = array[array_size - 1];
    array[array_size--] = null;
    size--;
    return r;
  }

  public T getTop() {
    return array[array_size - 1];
  }

  public T getTop2() {
    return array[array_size - 2];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

}
