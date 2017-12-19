/*
Referenced notes from class
*/

public class Queue<T> implements IQueue<T> {

  //queue is first in first out

  T[] array;
  int array_size;
  int size;

  public Queue(int new_size) {
    array = (T[]) new Object[new_size];
    array_size = 0;
    size = 0;
  }

  /**
   * Dequeues the Front element from the queue
   * @return dequeued element
   * @throws UnderFlowException if dequeueing an empty queue
   */
  public T dequeue() throws UnderFlowException {
    if(array_size == 0) {
      throw new UnderFlowException();
    }
    T r = array[0];
    for(int i = 1; i < array_size; i++) {
      array[i - 1] = array[i];
    }
      array_size--;
      size--;
      return r;
  }

  /**
   * Enqueues an element at the back of the queue
   * @param v enqueued element
   * @throws OverFlowException if enqueueing a full queue
   */
  public void enqueue(T v) throws OverFlowException {
    if(array_size == array.length) {
      throw new OverFlowException();
    }
    array[array_size] = v;
    array_size++;
    size++;
  }

  public T getTop() {
    return array[array_size - 1];
  }

  public int size() {
    return size;
  }

}
