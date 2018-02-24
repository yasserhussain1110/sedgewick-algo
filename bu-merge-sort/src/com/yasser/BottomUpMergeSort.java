package com.yasser;

public class BottomUpMergeSort {
  public static void main(String[] args) {
    Integer[] numbers = {12, 15, 18, 14, 5, 7, 9, 2, 16, 13};
    sort(numbers);
    for (int n : numbers) System.out.println(n);
  }

  public static boolean less(Comparable item1, Comparable item2) {
    return item1.compareTo(item2) < 0;
  }

  public static void sort(Comparable[] items) {
    int N = items.length;
    Comparable[] aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int i = 0; i < N - sz; i += sz + sz) {
        merge(items, aux, i, i + sz - 1, Math.min(i + sz + sz - 1, N - 1));
      }
    }
  }

  public static void merge(Comparable[] items, Comparable[] aux, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; i++) aux[i] = items[i];

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        items[k] = aux[j++];
      } else if (j > hi) {
        items[k] = aux[i++];
      } else if (less(aux[i], aux[j])) {
        items[k] = aux[i++];
      } else {
        items[k] = aux[j++];
      }
    }
  }
}