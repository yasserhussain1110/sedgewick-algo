package com.yasser;

public class MergeSort {
  public static void main(String[] args) {
    Integer[] numbers = {12, 15, 18, 14, 5, 7, 9, 2, 16, 13};
    sort(numbers);
    for (int n : numbers) System.out.println(n);
  }

  public static boolean less(Comparable item1, Comparable item2) {
    return item1.compareTo(item2) < 0;
  }

  public static void sort(Comparable[] items) {
    Comparable[] aux = new Comparable[items.length];
    sortFromLoToHi(items, aux,0, items.length - 1);
  }

  public static void sortFromLoToHi(Comparable[] items, Comparable[] aux, int lo, int hi) {
    if (lo >= hi) return;

    int mid = (hi + lo) / 2;

    sortFromLoToHi(items, aux, lo, mid);
    sortFromLoToHi(items, aux,mid+1, hi);
    if (less(items[mid], items[mid+1])) return;
    merge(items, aux, lo, mid, hi);
  }

  public static void merge(Comparable[] items, Comparable[] aux, int lo, int mid, int hi) {
    for (int i=lo; i<=hi; i++) aux[i] = items[i];

    int  i = lo, j = mid + 1;
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
