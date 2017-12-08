/*
made a new doubly linked list with help for this assignment
*/

public class DoubleLinkList<T> implements IList<T> {

  IDLink<T> current;
  IDLink<T> head;
  IDLink<T> tail;
  int size;

  public DoubleLinkList() {
    current = null;
    head = null;
    tail = null;
    size = 0;
  }

  public void insert(int idx, T v){
    if (idx == 0){
      IDLink<T> insert = new DLink(v, null, head);
//      head.setPrev(insert);
      head = insert;
      size++;
      return;
    }
    else if(idx == size){
      append(v);
      return;
       }
    else {
      IDLink<T> before = head;
      IDLink<T> after = head;
      IDLink<T> insert = new DLink(v, null, null);
      for(int i=0; i < idx-1; i++){
        before = before.getNext();
      }
      for (int i=0; i < idx; i++){
        after = after.getNext();
      }
      insert.setPrev(before);
      after.setPrev(insert);
      before.setNext(insert);
      insert.setNext(after);
      size++;
      }
  }


  public void append(T v){
      DLink<T> temp = new DLink(v, tail, null);
      if (size == 0){
        head = temp;
        tail = temp;
        temp.setPrev(temp);
        temp.setNext(temp);
        size++;
      }
      else {
      tail.setNext(temp);
      temp.setPrev(tail);
      temp.setNext(temp);
      tail = temp;
      current = temp;
      size++;
    }

  }

  public void remove(){
    IDLink<T> temp = head;
    int current_index = 0;
    if(temp == current){
      current = current.getNext();
      head = current;
    }
    else if(current == tail){
      IDLink<T> temp2 = head;
      for(int i = 0; i < size; i++){
        temp2 = temp2.getNext();
      }
      temp.setNext(null);
      current = temp;
      tail = temp;
    }
    else {
      IDLink<T> insert = current.getNext();
      while (temp != current){
        temp = temp.getNext();
        current_index++;
      }
      temp = head;
      for(int i=0; i < current_index-1; i++){
        temp = temp.getNext();
      }
      temp.setNext(insert);
    }
  }

  public void remove(int idx){
    if (idx == 0){
      // need two new nodes
      IDLink<T> temp = new DLink(head.getValue(), head.getNext(), head.getNext());
      IDLink<T> temp2 = temp.getNext();
      head = temp2;
      }
    else if (idx == size - 1){
      IDLink<T> temp = head;
      for(int i=0; i < size - 2; i++){
        temp = temp.getNext();
      }
      temp.setNext(null);
      tail = temp;
    }
    else {
      IDLink<T> temp = head;
      for(int i=0; i < idx-1; i++){
        temp = temp.getNext();
      }
      IDLink delete = temp.getNext();
      IDLink after = delete.getNext();
      temp.setNext(after);
      after.setPrev(temp);
    }
    size--;
  }


  public void move(int sidx, int didx){
      T value = fetch(sidx);
      IDLink<T> temp = head;
      if (sidx == 0){
        //do nothing
      } else {
      }
      remove(sidx);
      insert(didx, value);
    }

    public T fetch(){
      T val = current.getValue();
      return val;
    }

    public T fetch(int idx){
      if (idx > size){
        return null;
      } else {
        IDLink<T> n = head;
        for (int i = 0; i < idx; i++){
          n = n.getNext();
        }
        return n.getValue();
      }
    }

  public void next(){
    if (current == tail){
      //do nothing
    } else {
      current = current.getNext();
    }
  }

  public void prev(){
    if (current == head){
      //do nothing
    } else {
      current = current.getPrev();
    }
  }

  public void jumpToTail(){
    current = tail;
  }

  public void jumpToHead(){
    current = head;
  }

  public int size(){
    return size;
  }
}
