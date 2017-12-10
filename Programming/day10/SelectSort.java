public class SelectSort<T extends Comparable> implements ISort<T>{

  public SelectSort() {
  }

  public void sort(T[] in) { //T[] is the array to sort
    for(int i = 0; i < in.length - 1; i++) {
      int index = i;
      for (int j = i + 1; j < in.length; j++) {
        if(in[j].compareTo(in[index]) < 0) {
          index = j;
        }
      }
      //switch elements
      T small_number = in[index];
      in[index] = in[i];
      in[i] = small_number;
    }
  }

  public String sortName() {
    return "Select Sort";
  }

  public static void main(String[] args) {
    ISort<Integer> n = new SelectSort<Integer>();
    Integer[] array = {11, 9, 17, 5, 12, 7, 6, 20, 2};
    System.out.println("Original array:");

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();

    n.sort(array);

    System.out.println("Array after sort:");

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();

  }

}
