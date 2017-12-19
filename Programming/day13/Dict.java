public class Dict<K extends Comparable<K>,V> implements IDict<K,V>{

  DoubleLinkPair<K,V> list;
  int size;

  public Dict(){
    list = new DoubleLinkPair<K,V>();
    size = 0;
  }

  public V add(K k, V v){
    if (list.fetch(k) == null){
      list.append(k,v);
      size++;
      return v;
    }
    else {
      list.changeValue(k,v);
      return v;
    }
  }

  public V remove(K k){
    V value = list.fetch(k);
    list.remove();
    size--;
    return value;
  }

  public int size(){
    return size;
  }

  public V fetch(K k){
      V value = list.fetch(k);
      return value;
  }

  public K[] keys(){
    K[] array = list.fetch_two();
    return array;
  }
}
