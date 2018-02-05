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
    sortFromLoToHi(items,0, items.length - 1);
  }

  public static void sortFromLoToHi(Comparable[] items, int lo, int hi) {
    if (lo >= hi) return;

    int mid = (hi + lo) / 2;

    sortFromLoToHi(items, lo, mid);
    sortFromLoToHi(items, mid+1, hi);
    merge(items, lo, mid, hi);
  }

  public static void merge(Comparable[] items, int lo, int mid, int hi) {
    int N = hi - lo + 1;
    Comparable clone[] = new Comparable[N];
    for (int i = 0; i < N; i++) clone[i] = items[i + lo];

    int a = 0;
    int correspondingMid = mid - lo;
    int b = correspondingMid + 1;
    int i;

    for (i = lo; i <= hi && a <= correspondingMid && b < N; i++) {
      if (less(clone[a], clone[b])) {
        items[i] = clone[a++];
      } else {
        items[i] = clone[b++];
      }
    }

    if (a > correspondingMid) {
      for (; i <= hi; i++,b++) items[i] = clone[b];
    } else {
      for (; i <= hi; i++,a++) items[i] = clone[a];
    }
  }
}
