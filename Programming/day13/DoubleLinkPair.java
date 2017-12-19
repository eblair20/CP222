public class DoubleLinkPair<K extends Comparable<K>,V> {

  IDLink2<K,V> current;
  IDLink2<K,V> head;
  IDLink2<K,V> tail;
  int size;

  public DoubleLinkPair() {
    current = null;
    head = null;
    tail = null;
    size = 0;
  }

  public void append(K k, V v){
      DLink2<K,V> temp = new DLink2(k, v, tail, null);
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

  public V changeValue(K k, V v){
    IDLink2<K,V> temp = head;
    for (int i = 0; i < size; i++){
      if (k.compareTo(temp.getKey()) == 0){
        temp.setValue(v);
      }
      else {
        temp = temp.getNext();
      }
    }
    return temp.getValue();
  }

  public void remove(){
    IDLink2<K,V> temp = head;
    int current_index = 0;
    if(temp == current){
      current = current.getNext();
      head = current;
    }
    else if(current == tail){
      IDLink2<K,V> temp_two = head;
      for(int i=0; i < size; i++){
        temp_two = temp_two.getNext();
      }
      temp_two.setNext(null);
      current = temp;
      tail = temp;
    }
    else {
      IDLink2<K,V> ins = current.getNext();
      while (temp != current){
        temp = temp.getNext();
        current_index++;
      }
      temp = head;
      for(int i = 0; i < current_index - 1; i++){
        temp = temp.getNext();
      }
      temp.setNext(ins);
    }
    size--;
  }

  public V fetch(K k){
      IDLink2<K,V> n = head;
      for (int i = 0; i < size; i++){
        if (k.compareTo(n.getKey()) == 0){
          current = n;
          return n.getValue();
        }
        else {
          n = n.getNext();
        }
      }
    return null;
  }

  public K[] fetch_two(){
    IDLink2<K,V> n = head;
    K[] new_array = (K[])new Comparable[size];
    for (int i = 0; i < size; i++){
      new_array[i] = n.getKey();
      n = n.getNext();
    }
    return new_array;
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
