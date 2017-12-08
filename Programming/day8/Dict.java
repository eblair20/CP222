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

  public void printArray(){
    K[] array = list.fetch_two();
    for(int i = 0; i < size; i++){
      System.out.println(array[i]);
    }
  }


  public static void main(String[] argv){
      Dict<String,Integer> linear = new Dict<String,Integer>();
      linear.add("one", 1);
      linear.add("two", 2);
      linear.add("three", 3);
      System.out.println("Keys in the list: ");
      System.out.println(linear.fetch("one"));
      System.out.println(linear.fetch("two"));
      System.out.println(linear.fetch("three"));
      //linear.remove("one");
      linear.remove("three");
      System.out.println("Keys after removal: ");
      System.out.println(linear.fetch("one"));
      System.out.println(linear.fetch("two"));
      System.out.println(linear.fetch("three"));
      System.out.println("Remaining keys: ");
      linear.printArray();
  }


}
