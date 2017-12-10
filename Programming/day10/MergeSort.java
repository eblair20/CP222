import java.util.Arrays;

public class MergeSort<T extends Comparable> implements ISort<T>{

  public MergeSort() {
  }

  public void sort(T[] in) {
    if(in.length < 1) {
      return;
    }
    T[] first = (T[])new Comparable[in.length / 2];
    T[] second = (T[])new Comparable[in.length - first.length];

    if(in.length > 1) {
      for (int i = 0; i < first.length; i++) {
        first[i] = in[i];
      }
      for (int i = 0; i < second.length; i++) {
        second[i] = in[first.length + i];
      }
      sort(first);
      sort(second);
      merge(first, second, in);
    }
  }

  public void merge(T[] first, T[] second, T[] in) {
    int first_one = 0;
    int second_one = 0;
    int j = 0;

    while (first_one < first.length && second_one < second.length) {
      if (first[first_one].compareTo(second[second_one]) < 0) {
        in[j] = first[first_one];
        first_one++;
      } else {
        in[j] = second[second_one];
        second_one++;
      }
      j++;
    }

    while (first_one < first.length) {
      in[j] = first[first_one];
      first_one++;
      j++;
    }

    while (second_one < second.length) {
      in[j]  = second[second_one];
      second_one++;
      j++;
    }
  }

  public String sortName() {
    return "Merge Sort";
  }

  public static void main(String[] args) {
    ISort<Integer> n = new MergeSort<Integer>();
    Integer[] a = {11, 7, 20, 5, 31, 26, 4};
    System.out.println(Arrays.toString(a));

    n.sort(a);

    System.out.println(Arrays.toString(a));

  }

}
